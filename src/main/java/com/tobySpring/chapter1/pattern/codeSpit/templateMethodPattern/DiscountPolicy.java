package com.tobySpring.chapter1.pattern.codeSpit.templateMethodPattern;

import java.util.HashSet;

abstract class DiscountPolicy {
    private Set<DiscountCondition> conditions = new HashSet<>();

    public void addCondition(DiscountCondition condition){conditions.add(condition)}

    public Money calculateFee(Screening screening, int count, Money fee){// 템플릿 메서드
    for (DiscountCondition condition : conditions){
        if (condition.isSatisfiedBy(screening, count)) return calculateFee(fee);
    }
    return fee;
    }
    protected abstract Money calculateFee(Money fee); //훅  ?? 선택적으로 받아야하는게 훅이라고 토비의 스프링에서 이야기하는데 ??
}
