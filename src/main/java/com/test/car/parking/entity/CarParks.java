package com.test.car.parking.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_parks")
@Data
public class CarParks {
    @Id
    public String car_park_no;

    public String address;

    public Double x_coord;

    public Double y_coord;

    public String car_park_type;

    public String type_of_parking_system;

    public String short_term_parking;

    public String free_parking;

    public String night_parking;

    public Integer car_park_decks;

    public Double gantry_height;

    public  String car_park_basement;

}
