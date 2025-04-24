package com.example.kiosk.lv_4;

public enum MenuType {
    // 새로운 메뉴 생성 시, 변경해줘야함 (ex. BURGER("Cakes", 4))
    BURGER("Burgers", 1),
    DRINK("Drinks", 2),
    DESSERT("Desserts",3),
    CAKE("Cakes",4);

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
