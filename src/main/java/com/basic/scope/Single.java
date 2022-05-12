package com.basic.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component //bean으로 등록
public class Single {
    //Single이 Proto를 가지게
//    @Autowired
//    private Proto proto; //Single이 처음 만들어 질 때 같이 세팅되므로 값 변화X
//
//    @Autowired
//    private ObjectProvider<Proto> proto;

//    public Proto getProto(){
//        return proto.getIfAvailable();
//    }

    @Autowired
    private Proto proto;

    int number = 0;

    public Proto getProto(){
        return proto;
    }


}
