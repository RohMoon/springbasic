package com.basic.applicationContext;

import org.springframework.core.convert.converter.Converter;

public class EventConverter {
    // String을 Event 타입으로
    public static class StringToEventConverter implements Converter<String, Event>{

        @Override
        public Event convert(String s) {
            return new Event(Integer.parseInt(s));
        }
    }

    //Event 타입을 String으로
    public static class EventToStringConverter implements Converter<Event, String>{
        @Override
        public String convert(Event event) {
            return event.getId().toString();
        }
    }

}
