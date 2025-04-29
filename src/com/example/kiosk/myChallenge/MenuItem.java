package com.example.kiosk.myChallenge;

public abstract class MenuItem {
    private final String food_name;
    private final double price;
    private final String ingredients;
    private final MenuType menuType;

    public MenuItem(String food_name, double price, String ingredients, MenuType menuType) {
        this.food_name = food_name;
        this.price = price;
        this.ingredients = ingredients;
        this.menuType = menuType;
    }

    public String getFood_name() {
        return food_name;
    }

    public double getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public MenuType getMenuType() {
        return menuType;
    }
}

