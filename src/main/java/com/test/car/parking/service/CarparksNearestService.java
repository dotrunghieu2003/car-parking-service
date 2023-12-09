package com.test.car.parking.service;

import com.test.car.parking.cache.CarParksMemoryCache;
import com.test.car.parking.entity.CarParks;
import com.test.car.parking.thirdparty.CarParksAvailabilitySynchronization;
import com.test.car.parking.thirdparty.CarparkInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
@Slf4j
public class CarparksNearestService {
    @Autowired
    protected CarParksAvailabilitySynchronization carParksAvailabilitySynchronization;

    @Autowired
    protected CarParksMemoryCache carParksMemoryCache;

    public List<CarparksNearest> getCarparksNearest(Double lat, Double lon, int page, int per_page){
        List<CarparksNearest> carparksNearestsLst = new ArrayList<>();
        List<CarParks> carParksList = this.carParksMemoryCache.getCarParksList();
        for(CarParks carParks : carParksList){
            if(this.carParksAvailabilitySynchronization.isHasCarParksAvailability(carParks.car_park_no)) {
                carparksNearestsLst.add(this.create(carParks, lat, lon));
            }
        }

        List<CarparksNearest> carparksNearests = this.returnWithPaging(carparksNearestsLst, page, per_page);

        return carparksNearests;
    }

    private CarparksNearest create(CarParks carParks, Double lat, Double lon){
        CarparksNearest carparksNearest = new CarparksNearest();
        carparksNearest.carpark_number = carParks.car_park_no;
        carparksNearest.address = carParks.address;
        carparksNearest.latitude = carParks.x_coord;
        carparksNearest.longitude = carParks.y_coord;
        List<CarparkInfo> carparkInfos = carParksAvailabilitySynchronization.getCarparkDataMap().get(carParks.car_park_no);

        if(!ObjectUtils.isEmpty(carparkInfos)){
            CarparkInfo carparkInfo = carparkInfos.get(0);
            carparksNearest.available_lots = carparkInfo.lots_available;
            carparksNearest.total_lots = carparkInfo.total_lots;
        }
        Double distance_kilometers = DistanceCalculator.calculateDistance(lat, lon, carparksNearest.latitude, carparksNearest.longitude);
        carparksNearest.distance_kilometers = distance_kilometers;

        return  carparksNearest;
    }

    protected List<CarparksNearest> returnWithPaging(List<CarparksNearest> carparksNearestsSet,
                                                     int page, int per_page){
        return carparksNearestsSet.stream()
                .sorted(comparing(CarparksNearest::getDistance_kilometers))
                .skip((page-1)*per_page).limit(per_page)
                .collect(Collectors.toList());
    }
}
