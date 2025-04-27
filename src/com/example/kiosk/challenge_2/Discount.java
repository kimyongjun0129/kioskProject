package com.example.kiosk.challenge_2;

public class Discount {
    DiscountType type;

    public Discount(int num) {
        switch(num) {
            case 1 -> type=DiscountType.VETERAN;
            case 2 -> type=DiscountType.SOLDER;
            case 3 -> type=DiscountType.STUDENT;
            case 4 -> type=DiscountType.NORMAL;
            default -> throw new IndexOutOfBoundsException();
        }
    }

    public double Calculate(double totalCost) {
        return totalCost - totalCost*(type.getDiscount()*0.01);
    }
}
