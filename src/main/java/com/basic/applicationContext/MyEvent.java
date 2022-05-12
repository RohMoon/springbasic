package com.basic.applicationContext;

import org.springframework.context.ApplicationEvent;

// 어떤 데이터를 담아서 전송 할 수 있는 이벤트
//public class MyEvent extends ApplicationEvent {
public class MyEvent {

    private int data;
    private Object source;

//    public MyEvent(Object source){
    public MyEvent(Object source,int data){
        this.source = source;
        this.data = data;
    }

    public Object getSource(){
        return source;
    }

    public int getData(){
        return data;
    }
}
