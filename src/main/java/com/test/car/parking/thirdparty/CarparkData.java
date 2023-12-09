package com.test.car.parking.thirdparty;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CarparkData {

    public List<CarparkInfo> carpark_info = new ArrayList<>();
    public String carpark_number;

    public Date update_datetime;
}
