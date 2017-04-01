package com.codeclan.shoppingbasketcodetest;

/**
 * Created by DRC on 31/03/2017.
 */

public class ShoppingItem {

    // considered option of making this an interface or abstract class
    // but at the moment don't have sufficient reason to consider lots of different
    // 'Basketables' based on the brief.

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
