package com.basic.applicationContext;

import java.lang.annotation.*;

@Documented//javaDoc 만들 때,Documentation이 되도록
@Target(ElementType.METHOD)// 메서드를 타겟으로 잡음.
@Retention(RetentionPolicy.CLASS)//이 어노테이션 정보를 얼마나 유지할 것인지.(즉, 이경우 .Class파일까지 유지하겠다는 뜻)
public @interface PerfLogging {

}
