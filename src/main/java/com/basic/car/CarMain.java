package com.basic.car;

import com.basic.applicationContext.Event;
import com.basic.applicationContext.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public class CarMain {

//    @Autowired
//    Environment environment;
    public static void main(String[] args) {
        Event event = new Event();//이벤트 객체 생성
        EventValidator eventValidator = new EventValidator();//validator 생성
        // 에러를 담는 객체, 어떤 객체를 검사할 것이며, 어떤 이름인지
        Errors errors = new BeanPropertyBindingResult(event , "event");

        eventValidator.validate(event,errors); //event 객체를 검사하고, errors에 검증에러를 담아줌.

        System.out.println(errors.hasErrors());// error가 있는지 확인.

        errors.getAllErrors().forEach(e->{
            System.out.println("===== error code =====");
            Arrays.stream(e.getCodes()).forEach(System.out::println);// validate메서드에서 정해준 errorCode 값들
            System.out.println(e.getDefaultMessage()); //validate 메서드에서 정해준 defaultMessage 값
        });



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
