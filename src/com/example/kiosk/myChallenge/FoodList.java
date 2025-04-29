package com.example.kiosk.myChallenge;

import java.util.ArrayList;
import java.util.List;

public class FoodList  {

    private final List<Item> foodList = new ArrayList<>();

    public void addItem(Item item) {
        foodList.add(item);
    }

    public List<Item> getList() {
        return foodList;
    }
}
