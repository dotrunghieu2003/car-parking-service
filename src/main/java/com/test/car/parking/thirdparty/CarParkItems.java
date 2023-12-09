package com.test.car.parking.thirdparty;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class CarParkItems {

    public List<CarparkData> carpark_data = new ArrayList<>();
    public Timestamp timestamp ;
}
