package com.basic.applicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class TestComponent {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void run(){
        applicationEventPublisher.publishEvent(new MyEvent(this,100));//myEvent라는 이벤트를 발생시킴
    }

    @Autowired
    MessageSource messageSource;

    @Autowired
    Environment environment;

    @Value("${my.name}")
    String name;

    @PostConstruct
    public void print() {
        // default 값
        System.out.println("--------Environment");
        System.out.println(environment.getProperty("my.hobby"));
        System.out.println(environment.getProperty("my.name"));
        System.out.println("--------messageSource");
        //Default 값
        System.out.println(messageSource.getMessage("greeting", new String[]{"sangMoon"}, Locale.getDefault()));
        //한글 ( _ko_KR 파일 사용)
        System.out.println(messageSource.getMessage("greeting", new String[]{"sangMoon"}, Locale.KOREA));
        //영어 ( _en 파일 사용)
        System.out.println(messageSource.getMessage("greeting", new String[]{"sangMoon"}, Locale.ENGLISH));

    }

}
