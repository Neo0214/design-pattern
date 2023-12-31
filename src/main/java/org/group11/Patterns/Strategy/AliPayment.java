package org.group11.Patterns.Strategy;

public class AliPayment implements Payment{
    @Override
    public String Payment() {
        System.out.println("使用支付宝支付");
        return "支付宝支付";
    }
}

