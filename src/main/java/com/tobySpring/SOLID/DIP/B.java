package com.tobySpring.SOLID.DIP;
/**
 * B사의 알림 서비스
 * */
public class B implements Alarm{
    @Override
    public String beep(){
        return "beep";
    }
}
