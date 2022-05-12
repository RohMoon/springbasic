package com.basic.applicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//public class MyEventHandler implements ApplicationListener<MyEvent> {
public class MyEventHandler  {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE +2 )//가장 높은  우선순위에 숫자를 더해줘서 가장 높은 우선순위보다 2단계 뒤의 우선순위를 가짐.
    public void print (MyEvent myEvent){
        System.out.println("이벤트 발생"+ myEvent.getData());// MyEvent 이벤트에서 data 가져옴.
    }

    /*@Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("이벤트 발생" + myEvent.getData());// MyEvent 이벤트에서 data 가져옴.
    }*/
}
