package com.tobySpring.SOLID.DIP2;

public class KakaoPay implements Pay{
    @Override
    public String payment() {
        return "kakao";
    }
}
