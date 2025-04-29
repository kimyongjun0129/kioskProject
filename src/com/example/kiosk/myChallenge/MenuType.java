package com.example.kiosk.myChallenge;

public enum MenuType {
    BURGER(1),
    DRINK(2),
    DESSERT(3);

    private final int num;

    MenuType(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
