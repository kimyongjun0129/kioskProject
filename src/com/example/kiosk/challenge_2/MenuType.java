package com.example.kiosk.challenge_2;

public enum MenuType {
    BURGER(1),
    DRINK(2),
    DESSERT(3),
    CAKE(4);

    private final int num;

    MenuType(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
