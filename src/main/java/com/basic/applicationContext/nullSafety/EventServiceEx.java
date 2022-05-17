package com.basic.applicationContext.nullSafety;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventServiceEx {
    @NonNull //return도 null을 허용 하면 된다
    public String createEvent(@NonNull String name) {
        return "hello" + name;
    }
}
