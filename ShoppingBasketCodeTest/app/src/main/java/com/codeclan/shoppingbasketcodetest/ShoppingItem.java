package com.codeclan.shoppingbasketcodetest;

/**
 * Created by DRC on 31/03/2017.
 */

public class ShoppingItem {

    private String description;
    private Integer price;

    ShoppingItem(String description, Integer price){
        this.description = description;
        this.price = price;
    }

    Integer getPrice() {
        return price;
    }

    String getDescription() {
        return description;
    }
}
