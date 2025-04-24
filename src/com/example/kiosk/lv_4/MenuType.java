package com.example.kiosk.lv_4;

public enum MenuType {
    BURGER("Burgers", 1),
    DRINK("Drinks", 2),
    DESSERT("Desserts",3);

    private final String type;
    private final int num;

    MenuType(String type, int num) {
        this.type = type;
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public int getNum() {
        return num;
    }
}
