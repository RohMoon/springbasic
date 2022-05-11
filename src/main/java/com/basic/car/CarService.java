package com.basic.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public void setCarRepository(CarRepository carRepository){
        this.carRepository = carRepository;
    }

}
