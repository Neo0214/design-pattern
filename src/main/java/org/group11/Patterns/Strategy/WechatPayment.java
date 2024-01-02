package org.group11.Patterns.Strategy;

public class WechatPayment implements Payment{
    @Override
    public void Payment(int price) {
        System.out.println("使用微信支付"+price+"元");
        return;
    }
}
