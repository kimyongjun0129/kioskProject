package com.example.kiosk.lv_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    // 속성
    Menu menu = new Menu();

    // 생성자
    public Kiosk() {
        menu.addMenu(new Burger("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거", MenuType.BURGER));
        menu.addMenu(new Burger("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", MenuType.BURGER));
        menu.addMenu(new Burger("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", MenuType.BURGER));
        menu.addMenu(new Burger("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거", MenuType.BURGER));
        menu.addMenu(new Cake("CheeseCake", 10.4, "내가 제일 좋아하는 치즈 케이크", MenuType.CAKE));
    }

    // 기능
    // 키오스크 동작
    public void start() {
        int mainMenuInput;
        int menuInput;
        do {
            menu.showMainMenu();
            System.out.print("메뉴를 선택하세요 : ");
            mainMenuInput = userInput();

            if (mainMenuInput == 0) {
                System.out.println("종료합니다.");
                return;
            } else if (MenuType.values().length < mainMenuInput) {
                System.out.println("메뉴가 없습니다.");
                continue;
            } else if (mainMenuInput == -1) {
                continue;
            }

            System.out.println();
            menu.showMenu(mainMenuInput);
            System.out.print("메뉴를 선택하세요 : ");
            menuInput = userInput();

            if (menuInput == 0) {
                System.out.println();
                continue;
            }

            menu.showSelectedFood(mainMenuInput, menuInput);
        } while(true);
    }

    // 유저 메뉴 입력 받는 함수
    private int userInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("올바른 값을 입력하세요.");
            scanner.nextLine();
            System.out.println();
            return -1;
        }
    }
}
