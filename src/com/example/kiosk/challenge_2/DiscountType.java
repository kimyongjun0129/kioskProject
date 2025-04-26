package com.example.kiosk.challenge_2;

public enum DiscountType {
    VETERAN("국가 유공자", 10),
    SOLDER("군인", 5),
    STUDENT("학생",3),
    NORMAL("일반",0);

    private final String target;
    private final int discount;

    DiscountType(String target, int discount) {
        this.target = target;
        this.discount = discount;
    }

    public String getTarget() {
        return target;
    }

    public int getDiscount() {
        return discount;
    }
}
