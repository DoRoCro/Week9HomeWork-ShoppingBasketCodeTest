package com.codeclan.shoppingbasketcodetest;

import java.util.HashMap;

/**
 * Created by DRC on 01/04/2017.
 * ShoppingBasket class for Code Test Week 9
 */

class ShoppingBasket {
    // need a data structure to store items.  ArrayList<ShoppingItem> or HashMap<ShoppingItem, Integer> are potential options.
    // using a HashMap to store a count of items rather than having to count up multiple occurrences of the same object.
    // Then need to decide whether removing all of an item leaves the key with value zero, or deletes mapping altogether.
    // keeping the mapping acts as a memory that an item was added.
    // To count items in basket need to sum values in HashMap vs. using size of ArrayList, or maintain a count.
    // This implementation uses HashMap and maintains a count, so may not be thread safe.

    private HashMap<ShoppingItem, Integer> items;
    private Integer itemsCount;

    public ShoppingBasket(){
        this.items = new HashMap<ShoppingItem, Integer>();
        this.itemsCount = 0;
    }

    public void add(ShoppingItem newItem) {
        if (this.contains(newItem)) {
            Integer currentCount = this.items.get(newItem);
            this.items.put(newItem, currentCount + 1 );
        }
        else {
            this.items.put(newItem, 1);
        }
        this.itemsCount ++;
    }

    public Integer itemCount() {
        return this.itemsCount;
    }

    public void remove(ShoppingItem item) {
        if (this.contains(item)) {
            this.itemsCount--;
            Integer currentCount = this.items.get(item);
            this.items.put(item, currentCount - 1);
        }
        else {
            // option to throw exception, but silent for now.
            return;
        }
    }

    public void empty() {
        this.items.clear();
        this.itemsCount = 0;
    }

    public boolean contains(ShoppingItem item){
        // NB - may be zero of this item if all have been removed, but will return true.
        return  (this.items.containsKey(item)) &&
                (this.items.get(item) > 0 );

    }

    public Integer count(ShoppingItem item) {
        if (this.contains(item)) {
            return this.items.get(item);
        }
        else return 0;
    }
}
