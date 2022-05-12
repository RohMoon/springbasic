package com.basic.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public class CarMain {

//    @Autowired
//    Environment environment;
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

        CarService carService = (CarService) applicationContext.getBean("carService");//<<
        System.out.println(carService != null);
//        print();

    }
//    public static void print(){
//        System.out.println(Arrays.toString(environment.getActiveProfiles())); // 현재 적용된 프로파일
//        System.out.println(Arrays.toString(environment.getDefaultProfiles()));// default 프로파일.
//    }
}
