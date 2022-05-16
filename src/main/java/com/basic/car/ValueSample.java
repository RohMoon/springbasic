package com.basic.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueSample {

    @Value("#{1+1}")
    private int a;

    @Value("${my.name}")
     private String name;

    @Value("#{${my.score} eq 100}")
    boolean bool;

    @Value("#{componentValueSample.data}")
    int data;

    public ValueSample() {
    }

    public int getA() {
        return a;
    }

    public String getName() {
        return name;
    }

    public boolean isBool() {
        return bool;
    }

}
