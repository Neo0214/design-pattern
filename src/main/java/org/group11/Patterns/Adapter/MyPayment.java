package org.group11.Patterns.Adapter;

public class MyPayment {
    private Payment payment;

    public MyPayment(Payment payment) {
        this.payment = payment;
    }

    public void Payment(int price) {
        payment.Payment(price);
    }

    public static class WechatPayment implements Payment {
        @Override
        public void Payment(int price) {
            System.out.println("使用微信支付" + price + "元");
            return;
        }
    }
}
