package com.example.kiosk.myChallenge;

public enum DiscountType {
    VETERAN("국가 유공자", 10),
    SOLDER("군인", 5),
    STUDENT("학생",3),
    NORMAL("일반",0);

    // 속성
    private final String target;
    private final int discount;

    // 생성자
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
