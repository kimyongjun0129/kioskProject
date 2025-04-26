package com.example.kiosk.challenge_2;

public enum DiscountType {
    VETERAN(0.1),
    SOLDER(0.05),
    STUDENT(0.03),
    NORMAL(0);

    private final double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
