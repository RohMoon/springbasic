package com.tobySpring.SOLID.DIP2;

public class PayService {
    private Pay pay;

    public void setPay(final Pay pay) {
        this.pay = pay;
    }

    public String payment(){
        return pay.payment();
    }

}
