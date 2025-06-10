package com.lab5;

public class Bonus {
    private double amount;

    public Bonus(double amount) {
        if (amount < 0 || amount > 5000) {
            throw new IllegalArgumentException("Бонус нь 0-5000 хооронд байх ёстой");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
