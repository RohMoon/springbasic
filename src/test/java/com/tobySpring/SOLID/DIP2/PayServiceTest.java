package com.tobySpring.SOLID.DIP2;

//import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PayServiceTest {
    private PayService payService = new PayService();

    @Test
    void samsungPay_Test(){
        /* Given*/
        Pay samsungPay = new SamsungPay();
        /* When */
        payService.setPay(samsungPay);
        /* Then */
        //Assert.assertEquals(payService.payment(),"samsung");
    }

    @Test
    void kakao_Test(){
        /* Given*/
        Pay kakaoPay = new KakaoPay();
        /* When */
        payService.setPay(kakaoPay);
        /* Then */
        //Assert.assertEquals(payService.payment(),"kakao");
    }


}