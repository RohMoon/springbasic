package com.basic.applicationContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component// bean으로 등록
@Aspect  // Aspect 클래스임을 나타냄
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PerfAspect {

//    @Around("execution(* com.basic.*(..))")// 이 Advice를 어떻게 적용할 것인가?/PonitCut을 적어줌.
//    @Around("bean(testEventService)")// 해당 bean의 모든 public 메서드에 적용
@Around("@annotation(PerfLogging)")//@PerfLoggin 어노테이션이 달려 있는 곳에 이 advice를 적용하라는 뜻.
public Object logPerf(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{// ProceedingJoinPoint: 이 advice가 적용되는 대상.
    long begin = System.currentTimeMillis();
    Object retVal = proceedingJoinPoint.proceed(); // target에 해당하는 메서드를 호출
    System.out.println(System.currentTimeMillis() - begin);
    return retVal;
}
    @Before("bean(carService))") //해당 bean의 모든 메서드 실행 이전에 advice를 실행.
    public void hello(){
        System.out.println("hello");
    }

}
