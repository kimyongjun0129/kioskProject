package com.example.kiosk.myChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingBascketService {
    List<Item> shoppingBascket = new ArrayList<>();
    double totalCost = 0;

    // 장바구니 선택 메뉴를 보여준다.
    public void showOrderMenu() {
        int num = MenuType.values().length;

        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println(++num + " Orders\t\t | 장바구니를 확인 후 주문합니다.");
        System.out.println(++num + " Cancel\t\t | 진행중인 주문을 취소합니다.");
    }

    // 장바구니에 특정 Item을 추가해준다.
    public void addMenu(Item item) {
        System.out.println(item.getFood_name() + "이 장바구니에 추가되었습니다.\n");
        shoppingBascket.add(item);
        addItemPrice(item);
    }

    // 장바구니 리스트를 반환한다.
    public List<Item> getList() {
        return shoppingBascket;
    }

    // 장바구니 속 물품, 총 비용을 보여준다.
    public void showShoppingBascketMenu() {

        System.out.println("\n[ Orders ]");
        for (Item menu : shoppingBascket) {
            System.out.println(menu.getFood_name() + " | " + menu.getPrice() + " | " + menu.getIngredients());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("w %.2f\n", totalCost);
    }

    public double getTotalCost() {
        return totalCost;
    }

    // 특정 메뉴가 있으면 true를 반환
    private boolean isFindMenu(String name) {
        for (Item item : shoppingBascket) {
            if(item.getFood_name().equalsIgnoreCase(name)) return true;
        }
        return false;
    }


    // 특정 메뉴를 장바구니에서 삭제
    public void deleteMenu(String name) {
        if (isFindMenu(name)) {
            // 전체 비용에서 메뉴 값 만큼 삭제
            subtractItemPrice(name);

            shoppingBascket = shoppingBascket.stream()
                    .filter(menu -> !menu.getFood_name().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
            System.out.println(name + "이/가 장바구니에서 삭제되었습니다.\n");

        } else {
            System.out.println("음식이 존재하지 않습니다.\n");
        }
    }

    // 특정 Item의 가격을 전체 비용에 더해준다.
    public void addItemPrice(Item item) {
        totalCost += item.getPrice();
    }

    // 특정 Item의 가격을 전체 비용에서 빼준다.
    private void subtractItemPrice(String name) {
        if (isFindMenu(name)) {
            shoppingBascket.stream()
                    .filter(menu -> menu.getFood_name().equalsIgnoreCase(name))
                    .findAny().ifPresent(mainMenu -> totalCost -= mainMenu.getPrice());
        }
    }

    // 장바구니를 초기화해준다.
    public void resetshoppingBascket () {
        shoppingBascket.clear();
        resetTotalCost();
    }

    // 전체 비용을 초기화해준다.
    public void resetTotalCost() {
        totalCost = 0;
    }
}
