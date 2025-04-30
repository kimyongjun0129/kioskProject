package com.example.kiosk.myChallenge;

public class Discount {
    // 속성
    DiscountType type;

    // 생성자 // 입력 값에 따른 할인 타입 선택
    public Discount(int num) {
        switch(num) {
            case 1 -> type= DiscountType.VETERAN;
            case 2 -> type= DiscountType.SOLDER;
            case 3 -> type= DiscountType.STUDENT;
            case 4 -> type= DiscountType.NORMAL;
            default -> throw new IndexOutOfBoundsException();
        }
    }

    // 전체 값에서 할인율을 적용한 값을 계산
    public double Calculate(double totalCost) {
        return totalCost - totalCost*(type.getDiscount()*0.01);
    }
}
