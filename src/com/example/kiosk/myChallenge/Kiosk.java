package com.example.kiosk.myChallenge;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    // 속성
    private final MenuService menuService = new MenuService();
    private final ShoppingBascketService shoppingBascketService = new ShoppingBascketService();

    // 생성자
    public Kiosk() {
        menuService.addItem(new Item("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거", MenuType.BURGER));
        menuService.addItem(new Item("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", MenuType.BURGER));
        menuService.addItem(new Item("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", MenuType.BURGER));
        menuService.addItem(new Item("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거", MenuType.BURGER));
        menuService.addItem(new Item("Coke", 1.5, "기본 코카콜라", MenuType.DRINK));
    }

    // 기능
    // 키오스크 동작
    public void start() {
        int mainMenuInput;
        int menuInput;
        int shoppingBascketInput;

        do {
            try {
                // 메인 메뉴를 보여준다.
                menuService.showMainMenu();
                if (!shoppingBascketService.getList().isEmpty()) shoppingBascketService.showOrderMenu();

                // 메인 메뉴에 대한 사용자의 입력을 받는다.
                System.out.print("메뉴를 선택하세요 : ");

                mainMenuInput = userInput();
                if (mainMenuInput == 0) {
                    System.out.println("종료합니다.");
                    return;
                }


                // 장바구니 메뉴가 보이지 않을 때, 전체 메뉴 갯수 보다 큰 수를 입력 시 예외 생성
                if (shoppingBascketService.getList().isEmpty() && mainMenuInput > menuService.getTotalMenuCount()) throw new IndexOutOfBoundsException();
                // 장바구니가 보일 때, 전체 메뉴 갯수 + 장바구니 메뉴 갯수(2) 보다 큰 수를 입력 시 예외 생성
                if (mainMenuInput > menuService.getTotalMenuCount() + 2) throw new IndexOutOfBoundsException();

                // 장바구니 확인
                if (mainMenuInput == menuService.getTotalMenuCount() + 1) {
                    shoppingBascketService.showShoppingBascketMenu();

                    System.out.println("\n1. 주문\t\t2. 메뉴 삭제\t\t3. 메뉴판");
                    System.out.print("주문하시겠습니까? ");
                    int input = userInput();

                    // 주문 완료
                    switch (input) {
                        case 1 -> {
                            int num = 1;

                            System.out.println("할인 정보를 입력해주세요.");
                            for (DiscountType discountType : DiscountType.values()) {
                                System.out.println(num++ + ". " + discountType.getTarget() + "\t: " + discountType.getDiscount() + "%");
                            }

                            System.out.print("입력해주세요 : ");
                            Discount discount = new Discount(userInput());

                            double totalCost = shoppingBascketService.getTotalCost();
                            System.out.printf("주문이 완료되었습니다. 금액은 w %.2f 입니다.\n\n", discount.Calculate(totalCost));
                            shoppingBascketService.resetTotalCost();
                            shoppingBascketService.resetshoppingBascket();
                            continue;
                        }
                        case 2 -> {
                            Scanner scanner = new Scanner(System.in);

                            shoppingBascketService.showShoppingBascketMenu();
                            System.out.print("장바구니에서 어떤 음식을 삭제하시겠습니까? ");
                            String food_name = scanner.nextLine();

                            shoppingBascketService.deleteMenu(food_name);
                            continue;
                        }
                        case 3 -> {
                            System.out.println();   // 줄바꿈
                            continue;
                        }
                        default -> throw new IndexOutOfBoundsException();
                    }
                }

                // 주문 취소
                if (mainMenuInput == menuService.getTotalMenuCount() + 2) {
                    System.out.println("주문이 취소되었습니다.\n");
                    shoppingBascketService.resetshoppingBascket();
                    continue;
                }

                // 메뉴를 보여준다.
                menuService.showMenu(mainMenuInput);

                // 메뉴에 대한 사용자의 입력을 받는다.
                System.out.print("메뉴를 선택하세요 : ");
                menuInput = userInput();
                if (menuInput == 0) {
                    System.out.println();
                    continue;
                }

                // 선택된 메뉴 보여주기
                menuService.showSelectedFood(mainMenuInput, menuInput);

                // 장바구니에 추가할건지에 대한 사용자의 입력받기
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인\t\t2. 취소");
                System.out.print("추가하시겠습니까? ");
                shoppingBascketInput = userInput();

                // 장바구니에 추가하기
                switch (shoppingBascketInput) {
                    case 1 -> shoppingBascketService.addMenu(menuService.getMenuItems(mainMenuInput, menuInput));
                    case 2 -> System.out.println("취소되었습니다.\n");
                    default -> throw new IndexOutOfBoundsException();
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("없는 메뉴입니다.\n");
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.\n");
            }
        } while(true);
    }

    // 유저 메뉴 입력 받는 함수
    private int userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
