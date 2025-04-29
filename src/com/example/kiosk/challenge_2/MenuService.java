package com.example.kiosk.challenge_2;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    // 속성
    private final List<List<MenuItem>> menuItems = new ArrayList<>();

    // 생성자
    public MenuService() {
        for(int i = 0; i < MenuType.values().length; i ++) {
            menuItems.add(new ArrayList<>());
        }
    }

    // 메뉴 추가하는 기능
    public void addMenu(MenuItem newFood) {
        menuItems.get(newFood.getMenuType().getNum()-1).add(newFood);
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

        System.out.println("\n[ SHAKESHACK MENU ]");
        System.out.println("0. 뒤로가기\t\t");
        for (MenuItem menuItem : menuItems.get(input-1)) {
            System.out.println(num++ + ". "
                    + menuItem.getFood_name() + "\t | w "
                    + menuItem.getPrice() + " |\t"
                    + menuItem.getIngredients());
        }
    }


    // 메뉴 정보 제공
    public void showSelectedFood(int mainMenuInput, int menuInput) {
        System.out.println("선택한 메뉴 : "
                + menuItems.get(mainMenuInput-1).get(menuInput-1).getFood_name() + "\t | w "
                + menuItems.get(mainMenuInput-1).get(menuInput-1).getPrice() + " |\t"
                + menuItems.get(mainMenuInput-1).get(menuInput-1).getIngredients());
        System.out.println();
    }

    public MenuItem getMenuItems(int num, int num1) {
        return menuItems.get(num-1).get(num1-1);
    }

    public int getTotalMenuCount() {
        return MenuType.values().length;
    }
}
