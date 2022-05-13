package com.basic.applicationContext;

import java.beans.PropertyEditorSupport;

public class EventEditor extends PropertyEditorSupport {

    //Value라는 것은 PropertyEditor가 가지고 있는 값
    //이 값이 서로 다른 쓰레드에 공유가 됨 -> Stateful -> 쓰레드 safe하지 않음
    // -> 여러 쓰레드에 공유해서 사용하면 안된다 (Bean으로 등록해서 사용하면 안된다)


    @Override
    public String getAsText() {
        Event event = (Event) getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
