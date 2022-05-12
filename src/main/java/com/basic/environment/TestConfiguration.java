package com.basic.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;

//@Configuration
//@Profile("test")
//public class TestConfiguration {
//    // test 프로파일 일 때만 사용 되는 빈 설정 파일
//    // test라는 프로파일로 이 어플리케이션을 실행해야지만 적용
//
//    @Bean
//    @Profile("test")//메서드 자체에 프로파일 표시
//    public BookRepository bookRepository(){
//        return new TestRepository();
//    }

//@Configuration
//@Profile("!proud & test") //표현식 사용 가능
//public class TestConfiguration {
    // test 프로파일 일 때만 사용 되는 빈 설정 파일
    // test라는 프로파일로 이 어플리케이션을 실행해야지만 적용

//    @Bean
//    public BookRepository bookRepository(){
//        return new TestRepository();
//    }
  /*
  * 현재 적용중인 프로파일과 `default` 프로파일을 확인해볼때 사용하는 코드
  * */
    @Configuration
    public class TestConfiguration {

        @Autowired
    Environment environment;
        // test 프로파일 일 때만 사용 되는 빈 설정 파일
        // test라는 프로파일로 이 어플리케이션을 실행해야지만 적용
    @PostConstruct
    public  void print(){
        System.out.println("--------------------------------------------------"); // 현재 적용된 프로파일
        System.out.println(Arrays.toString(environment.getActiveProfiles())); // 현재 적용된 프로파일
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));// default 프로파일.
        System.out.println("--------------------------------------------------"); // 현재 적용된 프로파일
    }

}
