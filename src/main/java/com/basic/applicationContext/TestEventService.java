package com.basic.applicationContext;

import org.springframework.stereotype.Service;

@Service
public class TestEventService implements EventService{
    @PerfLogging
    @Override
    public void createEvent() {
        System.out.println("Create Event");
    }
    @PerfLogging
    @Override
    public void publishEvent() {
        System.out.println("Publish Event");
    }
}
