package com.example.kiosk.lv_4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 속성
    List<List<MainMenu>> menuItems = new ArrayList<>();
    List<MainMenu> burgerList = new ArrayList<>();
    List<MainMenu> drinkList = new ArrayList<>();
    List<MainMenu> dessertList = new ArrayList<>();

    public Menu() {
        menuItems.add(burgerList);
        menuItems.add(drinkList);
        menuItems.add(dessertList);
    }

    // 메뉴 추가하는 기능
    public void addMenu(MainMenu newFood) {
        switch (newFood.getMenuType()) {
            case MenuType.BURGER -> menuItems.get(0).add(newFood);
            case MenuType.DRINK -> menuItems.get(1).add(newFood);
            case MenuType.DESSERT -> menuItems.get(2).add(newFood);
        }
    }

    // 메인 메뉴 보여주는 기능
    public void showMainMenu() {
        int num = 1;
        System.out.println("[ MAIN MENU ]");
        System.out.println("0. 종료\t\t | 종료");
        for(MenuType type : MenuType.values()){
            System.out.println(num++ + ". " + type.name());
        }
    }


    // 메뉴 보여주는 기능
    public void showMenu(int input) {
        int num = 1;

        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("0. 뒤로가기\t\t | 종료");
        for (MainMenu menuItem : menuItems.get(input-1)) {
            if (menuItem.getMenuType().getNum() == input) {
                System.out.println(num++ + ". "
                        + menuItem.getFood_name() + "\t | w "
                        + menuItem.getPrice() + " |\t"
                        + menuItem.getIngredients());
            }
        }
    }


    // 메뉴 정보 제공
    public void showSelectedFood(int mainMenuInput, int menuInput) {
        try {
            System.out.println("선택한 메뉴 : "
                    + menuItems.get(mainMenuInput-1).get(menuInput-1).getFood_name() + "\t | w "
                    + menuItems.get(mainMenuInput-1).get(menuInput-1).getPrice() + " |\t"
                    + menuItems.get(mainMenuInput-1).get(menuInput-1).getIngredients());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("음식이 존재하지 않습니다.");
        } finally {
            System.out.println();
        }
    }
}
