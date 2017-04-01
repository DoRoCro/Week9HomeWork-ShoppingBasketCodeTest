package com.codeclan.shoppingbasketcodetest;

import java.util.HashMap;

/**
 * Created by DRC on 01/04/2017.
 */

class ShoppingBasket {
    // need a data structure to store items.  ArrayList<ShoppingItem> or HashMap<ShoppingItem, Integer> are potential options.
    // using a HashMap to store a count of items rather than having to count up multiple occurrences of the same object.
    // Then need to decide whether removing all of an item leaves the key with value zero, or deletes mapping altogether.
    // keeping the mapping acts as a memory that an item was added.
    // To count items in basket need to sum values in HashMap vs. using size of ArrayList, or maintain a count.

    private HashMap<ShoppingItem, Integer> items;
    private Integer itemsCount;

    public ShoppingBasket(){
        this.items = new HashMap<ShoppingItem, Integer>();
        this.itemsCount = 0;
    }

    public void add(ShoppingItem newItem) {
        this.items.put(newItem, 1);
        this.itemsCount ++;
    }

    public Integer itemCount() {
        return this.itemsCount;
    }

    public void remove(ShoppingItem cheese) {
        this.itemsCount --;
    }
}
