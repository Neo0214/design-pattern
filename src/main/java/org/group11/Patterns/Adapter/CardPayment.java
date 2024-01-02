package org.group11.Patterns.Adapter;

public class CardPayment implements Payment{
    @Override
    public void Payment(int price) {
        System.out.println("使用信用卡支付"+price+"元");
        return ;
    }
}
