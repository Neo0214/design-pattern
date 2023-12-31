package org.group11.Patterns.Strategy;

public class WechatPayment implements Payment{
    @Override
    public String Payment() {
        System.out.println("使用微信支付");
        return "微信支付";
    }
}
