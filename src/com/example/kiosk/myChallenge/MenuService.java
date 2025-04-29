package com.example.kiosk.myChallenge;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    // 속성
    private final List<FoodList> menuList = new ArrayList<>();

    // 생성자
    public MenuService() {
        for (int i = 0; i < MenuType.values().length; i++) {
            menuList.add(new FoodList());
        }
    }

    public void addItem(Item item) {
        switch (item.getMenuType()) {
            case BURGER -> menuList.get(MenuType.BURGER.getNum()-1).addItem(item);
            case DRINK -> menuList.get(MenuType.DRINK.getNum()-1).addItem(item);
            case DESSERT -> menuList.get(MenuType.DESSERT.getNum()-1).addItem(item);
        }
    }

    public List<Item> menuItemList (int input) {
        return menuList.get(input-1).getList();
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
        for (Item item : menuItemList(input)) {
            System.out.println(num++ + ". "
                    + item.getFood_name() + "\t | w "
                    + item.getPrice() + " |\t"
                    + item.getIngredients());
        }
    }


    // 메뉴 정보 제공
    public void showSelectedFood(int mainMenuInput, int menuInput) {
        System.out.println("선택한 메뉴 : "
                + menuItemList(mainMenuInput).get(menuInput-1).getFood_name() + "\t | w "
                + menuItemList(mainMenuInput).get(menuInput-1).getPrice() + " |\t"
                + menuItemList(mainMenuInput).get(menuInput-1).getIngredients() + "\n");
    }

    public Item getMenuItems(int num, int num1) {
        return menuItemList(num).get(num1-1);
    }

    public int getTotalMenuCount() {
        return MenuType.values().length;
    }
}
