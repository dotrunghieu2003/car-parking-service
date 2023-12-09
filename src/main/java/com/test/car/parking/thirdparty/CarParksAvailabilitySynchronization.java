package com.test.car.parking.thirdparty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@AllArgsConstructor
@Getter
public class CarParksAvailabilitySynchronization {

    private final ExternalAPIService externalAPIService;

    protected Map<String,  List<CarparkInfo>> carparkDataMap = new ConcurrentHashMap<>();

    public void loadCarParksAvailability(){
        this.carparkDataMap.clear();
        List <CarParkItems> carParkItemsLis = this.externalAPIService.getCarParkAvailabilityData().getItems();
        log.info("Loading Car Park Availability total items:{}", carParkItemsLis.size());

        for(CarParkItems carParkItem : carParkItemsLis){
            for(CarparkData carparkData : carParkItem.carpark_data){
                carparkDataMap.put(carparkData.carpark_number, carparkData.carpark_info);
            }
        }
    }

    public boolean isHasCarParksAvailability(String car_park_no){
        return ObjectUtils.isEmpty(this.carparkDataMap.get(car_park_no))? false: true;
    }
}
