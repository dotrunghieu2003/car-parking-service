package com.test.car.parking.cache;

import com.test.car.parking.entity.CarParks;
import com.test.car.parking.repository.CarParksRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
@Getter
public class CarParksMemoryCache {

    private final CarParksRepository carParksRepository;

    protected List<CarParks> carParksList  = new ArrayList<>();

    @PostConstruct
    public void loadCarParks(){
        this.carParksList.clear();
        this.carParksList = this.carParksRepository.findAll();
        log.info("Loading and caching CarParks address data total items:{}", this.carParksList.size());
    }

    public Optional<CarParks> getCarParks(String car_park_no){
        return this.carParksList.stream().filter( t -> t.car_park_no.equals(car_park_no)).findFirst();
    }

}
