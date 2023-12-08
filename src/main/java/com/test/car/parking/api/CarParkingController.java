package com.test.car.parking.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car-parking")
@Slf4j
public class CarParkingController {

    @GetMapping(path = "/health-check")
    public String healthCheck(){
       return  "Car Parking API running...";
    }
}
