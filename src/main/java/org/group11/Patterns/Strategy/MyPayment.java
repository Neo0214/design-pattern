package org.group11.Patterns.Strategy;

public class MyPayment {
private Payment payment;

    public MyPayment(Payment payment) {
        this.payment = payment;
    }

    public void Payment(int price) {
        payment.Payment(price);
    }
}
