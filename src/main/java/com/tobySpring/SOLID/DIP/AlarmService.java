package com.tobySpring.SOLID.DIP;


/**
 * 서비스 코드
 */
public class AlarmService {

    private Alarm alarm;

    public AlarmService(Alarm alarm) {
        this.alarm = alarm;
    }

    public String beep() {
        return alarm.beep();
    }
}
