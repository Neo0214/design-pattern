package org.group11.Patterns.Strategy;

import org.group11.Patterns.Adapter.Payment;

public class WechatPayment implements Payment {
    @Override
    public void Payment(int price) {
        System.out.println("使用微信支付"+price+"元");
        return;
    }
}
