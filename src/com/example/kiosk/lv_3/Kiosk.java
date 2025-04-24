package com.example.kiosk.lv_3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 속성
    List<MenuItem> menuItems;

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 기능
    // 키오스크 동작
    public void start() {
        int input = 1;
        do {
            showMenu();
            System.out.print("메뉴를 선택하세요 : ");
            input = userInput();

            if (totalFoodCount() < input) {
                System.out.println("음식이 없습니다.");
            }
        } while(input != 0);
    }

    // 유저 메뉴 입력 받는 함수
    private int userInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("올바른 값을 입력하세요.");
            scanner.nextLine();
            return -1;
        }
    }

    // 메뉴 추가하는 기능
    public void addMenu(String foodName, double price, String ingredient) {
        menuItems.add(new MenuItem(foodName, price, ingredient));
    }

    // 메뉴 보여주는 기능
    private void showMenu() {
        int num = 1;

        System.out.println(" [ SHAKESHACK MENU ]");
        System.out.println("0. 종료\t\t\t\t | 종료");
        for (MenuItem foodInfo : menuItems) {
            System.out.println(num++ + ". "
                    + foodInfo.getFood_name() + "\t\t | w "
                    + foodInfo.getPrice() + "\t "
                    + foodInfo.getIngredients());
        }
    }

    // 총 메뉴 갯수 반환하는 기능
    private double totalFoodCount() {
        return (long) menuItems.size();
    }

}
