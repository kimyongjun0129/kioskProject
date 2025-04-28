package com.example.kiosk.challenge_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingBascket {
    List<MainMenu> shoppingBascket = new ArrayList<>();
    double totalCost = 0;

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
        addItemPrice(mainMenu);
    }

    public List<MainMenu> getList() {
        return shoppingBascket;
    }

    public void showShoppingBascketMenu() {

        System.out.println("\n[ Orders ]");
        for (MainMenu menu : shoppingBascket) {
            System.out.println(menu.getFood_name() + " | " + menu.getPrice() + " | " + menu.getIngredients());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("w %.2f\n", totalCost);
    }

    public double getTotalCost() {
        return totalCost;
    }

    private boolean isFindMenu(String name) {
        for (MainMenu mainMenu : shoppingBascket) {
            if(mainMenu.getFood_name().equalsIgnoreCase(name)) return true;
        }
        return false;
    }


    public void deleteMenu(String name) {
        // 전체 비용에서 메뉴 값 만큼 삭제
        subtractItemPrice(name);

        if (isFindMenu(name)) {
            shoppingBascket = shoppingBascket.stream()
                    .filter(menu -> !menu.getFood_name().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
            System.out.println(name + "이/가 장바구니에서 삭제되었습니다.\n");

        } else {
            System.out.println("음식이 존재하지 않습니다.\n");
        }
    }

    public void addItemPrice(MainMenu mainMenu) {
        totalCost += mainMenu.getPrice();
    }

    private void subtractItemPrice(String name) {
        if (isFindMenu(name)) {
            shoppingBascket.stream()
                    .filter(menu -> menu.getFood_name().equalsIgnoreCase(name))
                    .findAny().ifPresent(mainMenu -> totalCost -= mainMenu.getPrice());
        } else {
            System.out.println("음식이 존재하지 않습니다.\n");
        }
    }

    public void resetshoppingBascket () {
        shoppingBascket.clear();
    }

    public void resetTotalCost() {
        totalCost = 0;
    }
}
