package com.basic.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CarMain.class)
public class ApplicationConfig{

    @Bean
    public CarRepository carRepository(){ // bean의 id 값이 메서드의 이름.
        return new CarRepository() {
        }; // 실제 객체
    }

    @Bean
    public CarService carService(){ // bean 의 id 값이 메서드의 이름,
        return new CarService(); // 실제 객체
    }

/*    @Bean
    public CarService carService(){
        CarService carService = new CarService();
        carService.setCarRepository(carRepository()); // 의존성 주입
        return carService;
    }

    @Bean
    public CarService carService (CarRepository carRepository){ //파라미터로 받음.
        CarService carService = new CarService();
        carService.setCarRepository(carRepository); // 의존성 주입
        return carService;
    }*/


}
