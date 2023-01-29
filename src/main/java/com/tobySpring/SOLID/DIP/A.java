package com.tobySpring.SOLID.DIP;

/**
* A사의 알람 서비스
* */
public class A implements Alarm{

    @Override
    public String beep() {
        return "Beep!";
    }
}
