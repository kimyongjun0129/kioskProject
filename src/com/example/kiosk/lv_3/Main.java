package com.example.kiosk.lv_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        kiosk.addMenu("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        kiosk.addMenu("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        kiosk.addMenu("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        kiosk.addMenu("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        Scanner scanner = new Scanner(System.in);
        int input = 1;

        do {
            kiosk.showMenu();
            System.out.print("메뉴를 선택하세요 : ");
            input = userInput(scanner);

            if (kiosk.totalFoodCount() < input) {
                System.out.println("음식이 없습니다.");
            }
        } while(input != 0);
    }

    public static int userInput(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("올바른 값을 입력하세요.");
            scanner.nextLine();
            return -1;
        }
    }
}
