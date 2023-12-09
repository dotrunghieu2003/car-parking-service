package com.test.car.parking.service;

import lombok.Data;

@Data
public class CarparksNearest {

    public String carpark_number;

    public String address;

    public Double latitude;

    public Double longitude;

    public Integer total_lots;

    public Integer available_lots;

    public Double distance_kilometers;

}
