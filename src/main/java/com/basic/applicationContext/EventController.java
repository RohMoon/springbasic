package com.basic.applicationContext;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    
    @InitBinder // 컨트롤러에서 사용할 바인더 등록
    public void init(WebDataBinder webDataBinder){
        // WebDataBinder에 Event 클래스 타입을 처리할 PropertyEditor 등록
        // WebDataBinder에 DataBinder의 구현체 중 하나
        webDataBinder.registerCustomEditor(Event.class,new EventEditor());

    }

    //event/1
    //event/2
    //이런식으로 요청이 들어오면 입력한 숫자를 Event 타입으로 변환하여 스프링이 받는다.
    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event){ //@PathVariable로 Event를 도메인으로 받음.
        System.out.println(event);
        return event.getId().toString();
    }
}