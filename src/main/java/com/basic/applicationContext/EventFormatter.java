package com.basic.applicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component // 빈으로 등록
public class EventFormatter implements Formatter<Event> {

//    @Autowired // 다른 Bean을 주입받을 수 있다.
//    MessageSource messageSource;

    //문자를 받아서 객체로 (Locale 정보를 기반으로)
    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(s));
    }
    // 객체를 받아서 문자로 (Locale 정보를 기반으로)
    @Override
    public String print(Event event, Locale locale) {
        return event.getId().toString();
    }
}
