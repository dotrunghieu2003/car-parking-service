package com.test.car.parking.event;

import com.test.car.parking.thirdparty.CarParksAvailabilitySynchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupEventListener {

    @Autowired
    protected CarParksAvailabilitySynchronization carParksAvailabilitySynchronization;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
        carParksAvailabilitySynchronization.loadCarParksAvailability();
    }
}
