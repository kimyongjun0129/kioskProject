package com.example.kiosk.challenge_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    // 속성
    private final Menu menu = new Menu();
    private final ShoppingBascket shoppingBascket = new ShoppingBascket();

    // 생성자
    public Kiosk() {
        menu.addMenu(new Burger("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거", MenuType.BURGER));
        menu.addMenu(new Burger("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", MenuType.BURGER));
        menu.addMenu(new Burger("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", MenuType.BURGER));
        menu.addMenu(new Burger("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거", MenuType.BURGER));
        menu.addMenu(new Cake("CheeseCake", 10.4, "내가 제일 좋아하는 치즈 케이크", MenuType.CAKE));
        menu.addMenu(new Cake("chocolateCake", 5.4, "내가 제일 싫어하는 치즈 케이크", MenuType.CAKE));
    }

    // 기능
    // 키오스크 동작
    public void start() {
        int mainMenuInput;
        int menuInput;
        int shoppingBascketInput;

        do {
            // 메인 메뉴를 보여준다.
            menu.showMainMenu();
            if (!shoppingBascket.getList().isEmpty()) shoppingBascket.showOrderMenu();

            // 메인 메뉴에 대한 사용자의 입력을 받는다.
            System.out.print("메뉴를 선택하세요 : ");
            try {
                mainMenuInput = userInput();
                if (mainMenuInput == 0) {
                    System.out.println("종료합니다.");
                    return;
                }

                // 장바구니 메뉴가 보이지 않을 때, 전체 메뉴 갯수 보다 큰 수를 입력 시 예외 생성
                if (shoppingBascket.getList().isEmpty() && mainMenuInput > menu.getTotalMenuCount()) throw new InputMismatchException();
                // 장바구니가 보일 때, 전체 메뉴 갯수 + 장바구니 메뉴 갯수(2) 보다 큰 수를 입력 시 예외 생성
                if (mainMenuInput > menu.getTotalMenuCount()+2) throw new InputMismatchException();

                // 장바구니 확인
                if (mainMenuInput == menu.getTotalMenuCount()+1) {
                    shoppingBascket.printTotalMenu();

                    System.out.println("1. 주문\t\t2.메뉴판");
                    System.out.print("주문하시겠습니까? ");
                    int input = userInput();
                    if(!(input > 0 && input < 3)) throw new InputMismatchException();

                    // 주문 완료
                    if (input == 1) {
                        System.out.println("주문이 완료되었습니다. 금액은 w " + shoppingBascket.getSum() + " 입니다.\n");
                        shoppingBascket.resetSum();
                        shoppingBascket.resetshoppingBascket();
                    }
                    continue;
                }

                // 주문 취소
                if (mainMenuInput == menu.getTotalMenuCount()+2) {
                    System.out.println("주문이 취소되었습니다.\n");
                    shoppingBascket.resetshoppingBascket();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("없는 메뉴입니다.\n");
                continue;
            }

            // 메뉴를 보여준다.
            System.out.println();
            menu.showMenu(mainMenuInput);

            // 메뉴에 대한 사용자의 입력을 받는다.
            System.out.print("메뉴를 선택하세요 : ");
            try {
                menuInput = userInput();
                if (menuInput == 0) {
                    System.out.println();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력했습니다.");
                continue;
            }

            // 선택된 메뉴 보여주기
            try {
                menu.showSelectedFood(mainMenuInput, menuInput);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("음식이 존재하지 않습니다.\n");
                continue;
            }

            // 장바구니에 추가할건지에 대한 사용자의 입력받기
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인\t\t2. 취소");
            try {
                System.out.print("추가하시겠습니까? ");
                shoppingBascketInput = userInput();
                if(!(shoppingBascketInput > 0 && shoppingBascketInput < 3)) throw new InputMismatchException();

                // 장바구니에 추가하기
                if(shoppingBascketInput == 1) {
                    shoppingBascket.addMenu(menu.getMenuItems(mainMenuInput, menuInput));
                } else {
                    System.out.println("취소되었습니다.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("없는 메뉴입니다.\n");
            }
        } while(true);
    }

    // 유저 메뉴 입력 받는 함수
    private int userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
