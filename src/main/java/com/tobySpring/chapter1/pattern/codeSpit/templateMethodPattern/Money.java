package com.tobySpring.chapter1.pattern.codeSpit.templateMethodPattern;

public class Money {
    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public Money minus(Money amount) {
        return new Money( this.amount - amount.amount);
    }
}
