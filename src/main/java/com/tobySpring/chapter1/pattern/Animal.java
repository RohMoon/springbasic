package com.tobySpring.chapter1.pattern;

public abstract class Animal {
    public abstract String getName();
    public String hello(){
        return "안녕하세요.";
    }
}
class Dog extends Animal {
    @Override
    public String getName() {
        return "강아지";
    }
}
class Cat extends Animal{
    @Override
    public String getName() {
        return "고양이";
    }

    @Override
    public String hello() {
        return "냐옹";
    }
}
/*
 * 부모 클래스의 getName(), hello()를 자식클래스에서 오버라이드 했다.
 * => 템플릿 메서드 패턴
 * 특히 getName()는 추상메서드, hello()는 훅메서드이다.
 * */