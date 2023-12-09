package com.test.car.parking.api;


import com.test.car.parking.service.CarparksNearest;
import com.test.car.parking.service.CarparksNearestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carparks")
@Slf4j
public class CarParkingController {

    @Autowired
    protected CarparksNearestService carparksNearestService;

    @GetMapping(path = "/health-check")
    public String healthCheck(){
       return  "Car Parking API running...";
    }

    @GetMapping(path = "/nearest")
    public List<CarparksNearest> carparksNearests(
            @RequestParam(required = true) Double latitude,
            @RequestParam(required = true) Double longitude,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "5") Integer per_page){
        return this.carparksNearestService.getCarparksNearest(latitude,longitude, page, per_page);
    }

}
