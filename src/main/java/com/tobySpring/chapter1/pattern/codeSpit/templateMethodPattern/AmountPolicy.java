package com.tobySpring.chapter1.pattern.codeSpit.templateMethodPattern;

public class AmountPolicy extends DiscountPolicy{
    private final Money amount;
    public AmountPolicy(Money amount){
        this.amount = amount;
    }

    @Override
    protected Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}
