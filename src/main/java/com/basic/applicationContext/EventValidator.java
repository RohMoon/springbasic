package com.basic.applicationContext;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
     return Event.class.equals(aClass);// 파라미터로 전달되는 aClass의 타입이 Event(우리가 임의로 만들어준 클래스)인지 확인.
    }

    @Override
    public void validate(Object o, Errors errors) {
    //errorCode는 key값
    // defaulMessage : errorCode로 메세지를 찾지 못했을 때, 사용할 메시지
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","notempty","Empty title is not allowed");
    }
}
