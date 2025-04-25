package com.example.kiosk.lv_4;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBascket {
    List<MainMenu> shoppingBascket = new ArrayList<>();
    double sum = 0;

    public void showOrderMenu() {
        int num = MenuType.values().length;

        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(++num + " Orders\t\t | 장바구니를 확인 후 주문합니다.");
        System.out.println(++num + " Cancel\t\t | 진행중인 주문을 취소합니다.");
    }

    public void addMenu(MainMenu mainMenu) {
        System.out.println(mainMenu.getFood_name() + "이 장바구니에 추가되었습니다.\n");
        shoppingBascket.add(mainMenu);
        sum += mainMenu.getPrice();
    }

    public List<MainMenu> getList() {
        return shoppingBascket;
    }

    public void printTotalMenu() {

        System.out.println("[ Orders ]");
        for (MainMenu menu : shoppingBascket) {
            System.out.println(menu.getFood_name() + " | " + menu.getPrice() + " | " + menu.getIngredients());
        }
        System.out.println("\n[ Total ]");
        System.out.println("w " + sum + "\n");
    }

    public double getSum() {
        return sum;
    }

    public void resetshoppingBascket () {
        shoppingBascket.clear();
    }

    public void resetSum() {
        sum = 0;
    }
}
