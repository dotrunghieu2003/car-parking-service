package com.test.car.parking;

import com.test.car.parking.service.DistanceCalculator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DistanceCalculatorTest {

    public static void main(String[] args) {
        // Coordinates of two points
        double lat1 = 40.7128; // Latitude of Point 1
        double lon1 = -74.0060; // Longitude of Point 1
        double lat2 = 34.0522; // Latitude of Point 2
        double lon2 = -118.2437; // Longitude of Point 2

        // Calculate distance between the points
        double distance = DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2);
        log.info("Distance between the points: " + distance + " kilometers");
    }
}
