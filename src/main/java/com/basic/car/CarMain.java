package com.basic.car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class CarMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

        CarService carService = (CarService) applicationContext.getBean("carService");//<<
        System.out.println(carService != null);//<<

    }
}
