package com.example.kiosk.Lv_2;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    // 속성
    List<MenuItem> foodList = new ArrayList<>();

    // 생성자

    // 기능
    // 메뉴 추가하는 기능
    public void addMenu(String foodName, double price, String ingredient) {
        foodList.add(new MenuItem(foodName, price, ingredient));
    }

    // 메뉴 보여주는 기능
    public void showMenu() {
        int num = 1;

        System.out.println(" [ SHAKESHACK MENU ]");
        System.out.println("0. 종료\t\t\t\t | 종료");
        for (MenuItem foodInfo : foodList) {
            System.out.println(num++ + ". " + foodInfo.getFood_name() + "\t\t | w " + foodInfo.getPrice() + "\t " + foodInfo.getIngredients());
        }
    }

    public double totalFoodCount() {
        return (long) foodList.size();
    }
}
