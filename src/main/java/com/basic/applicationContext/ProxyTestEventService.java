package com.basic.applicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary //client에서 EventService를 주입받아 메서드를 호출하면 @Primary 어노테이션으로 인해, 프록시 객체가 호출된다.
@Service
public class ProxyTestEventService implements EventService{//원래 객체와 같은 interface를 구현해줘야함.

    @Autowired
    TestEventService testEventService; //이론적으로는 interface 타입의 bean을 주입받는걸 추천
                                       //그러나, 프록시는 원래 객체의 bean을 주입받아 사용 해야 한다.
//    @Autowired
//    EventService eventService;

    @Override
    public void createEvent() {
        long begin =  System.currentTimeMillis(); // 새로 추가한 기능
        testEventService.createEvent(); // 원래 객체의 기능 위임
//        eventService.createEvent();
        System.out.println(System.currentTimeMillis()-begin);//새로 추가한 기능
    }

    @Override
    public void publishEvent() {
        long begin =  System.currentTimeMillis(); // 새로 추가한 기능
        testEventService.publishEvent(); // 원래 객체의 기능 위임
//        eventService.publishEvent();
        System.out.println(System.currentTimeMillis()-begin);//새로 추가한 기능
    }
}