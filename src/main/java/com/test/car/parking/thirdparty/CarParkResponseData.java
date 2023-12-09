package com.test.car.parking.thirdparty;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarParkResponseData {

    public List<CarParkItems> items = new ArrayList<>();
}
