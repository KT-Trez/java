package org.was;

public class BlikPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Blik payment: " + amount + " PLN");
    }
}
