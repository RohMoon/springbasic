package com.tobySpring.chapter1.pattern.animal;

abstract class AnimalFactory {
    abstract Animal factoyryReturn(String srt);
}
class FactoryReturn extends AnimalFactory{
    @Override
    Animal factoyryReturn(String str) {
        switch (str){
            case "dog" : return new Dog();
            case "cat" : return new Cat();
        }
        return null;
    }
}
/*
* 오버라이드된 메서드(factoryReturn)가 객체를 반환한다.
* => 팩토리 메서드 패턴
* */