package com.example.kiosk.myChallenge;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    // 속성
    private final List<FoodList> menuList = new ArrayList<>();

    // 생성자 // 메인 메뉴 갯수만큼 빈 배열 생성 후, menuList에 추가
    public MenuService() {
        for (int i = 0; i < MenuType.values().length; i++) {
            menuList.add(new FoodList());
        }
    }

    // MenuType 속 값을 인덱스 삼아, menuList 속 List에 item 저장
    public void addItem(Item item) {
        menuList.get(item.getMenuType().getNum()-1).addItem(item);
    }

    // 매개 변수로 인덱스를 넘겨 받아, 해당 인덱스에 해당하는 FoodList 반환
    public List<Item> getFoodList (int input) {
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
        for (Item item : getFoodList(input)) {
            System.out.println(num++ + ". "
                    + item.getFood_name() + "\t | w "
                    + item.getPrice() + " |\t"
                    + item.getIngredients());
        }
    }


    // 메뉴 정보 제공
    public void showSelectedFood(int mainMenuInput, int menuInput) {
        System.out.println("선택한 메뉴 : "
                + getFoodList(mainMenuInput).get(menuInput-1).getFood_name() + "\t | w "
                + getFoodList(mainMenuInput).get(menuInput-1).getPrice() + " |\t"
                + getFoodList(mainMenuInput).get(menuInput-1).getIngredients() + "\n");
    }

    // 매개 변수로 인덱스를 넘겨받아 특정 FoodList의 item을 반환한다.
    public Item getMenuItem(int num, int num1) {
        return getFoodList(num).get(num1-1);
    }

    // 메인 메뉴의 총 갯수를 반환한다.
    public int getTotalMenuCount() {
        return MenuType.values().length;
    }
}
