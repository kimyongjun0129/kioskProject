package com.example.kiosk.Lv_2;

public class MenuItem {
    private String food_name;
    private double price;
    private String ingredients;

    public MenuItem(String food_name, double price, String ingredients) {
        this.food_name = food_name;
        this.price = price;
        this.ingredients = ingredients;
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
}
