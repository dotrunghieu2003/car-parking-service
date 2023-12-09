package com.test.car.parking.repository;

import com.test.car.parking.entity.CarParks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarParksRepository extends JpaRepository<CarParks, String> {
}
