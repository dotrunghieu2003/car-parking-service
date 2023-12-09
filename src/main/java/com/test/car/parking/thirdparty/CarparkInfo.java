package com.test.car.parking.thirdparty;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class CarparkInfo {

    public Integer total_lots;
    public String lot_type;
    public Integer lots_available;
}
