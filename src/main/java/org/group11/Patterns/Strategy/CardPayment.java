package org.group11.Patterns.Strategy;

public class CardPayment implements Payment{
    @Override
    public String Payment() {
        System.out.println("使用信用卡支付");
        return "信用卡支付";
    }
}
