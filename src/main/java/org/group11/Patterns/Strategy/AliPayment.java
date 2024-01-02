package org.group11.Patterns.Strategy;

public class AliPayment implements Payment{
    @Override
    public void Payment(int price) {
        System.out.println("使用支付宝支付"+price+"元");
        return ;
    }
}

