package com.tobySpring.chapter1.pattern;

public class Main {
    public static void main(String[] args) {
        AnimalFactory af = new FactoryReturn();

        Animal dog = af.factoyryReturn("dog");
        //강아지 안녕하세요.
        System.out.println(dog.getName() + " " + dog.hello());

        Animal cat = af.factoyryReturn("cat");
        //고양이 야옹
        System.out.println(cat.getName() + " " + cat.hello());
    }
}
