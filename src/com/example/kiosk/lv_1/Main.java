package com.example.kiosk.lv_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 1;

        do {
            try {
                showMenu();
                System.out.print("메뉴를 선택하세요 : ");
                input = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("올바른 값을 입력하세요.");
                scanner.nextLine();
            }
        } while(input != 0);
    }

    private static void showMenu() {
        System.out.println(" [ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger\t\t | w 6.9\t 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack\t\t | w 8.9\t 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger\t\t | w 6.9\t 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger\t\t | w 5.4\t 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료\t\t\t\t | 종료");
    }
}
