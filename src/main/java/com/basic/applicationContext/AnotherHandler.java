package com.basic.applicationContext;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {
    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE)// 가장 높은 우선순위이므로 , 가장 먼저 실행
    public void check(MyEvent myEvent){
        System.out.println("Another Handler" + myEvent.getData());
    }
}
