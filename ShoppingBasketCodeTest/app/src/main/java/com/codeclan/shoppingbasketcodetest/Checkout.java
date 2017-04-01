package com.codeclan.shoppingbasketcodetest;

import java.util.ArrayList;

/**
 * Created by DRC on 01/04/2017.
 */

class Checkout {

    private ShoppingBasket basket;
    private ArrayList<IOffer> offers;

    public Checkout(ShoppingBasket basket, ArrayList<IOffer> offers) {
        this.basket = basket;
        this.offers = offers;
    }

    public Checkout(ShoppingBasket basket) {
        this.basket = basket;
    }

    public Integer noDiscountsBill() {
        Integer bill = 0;
        for(ShoppingItem item : this.basket.getItems().keySet()){
            bill += item.getPrice() * this.basket.count(item);
        }
        return bill;
    }

    public Integer withDiscountsBill() {
        Integer bill = this.noDiscountsBill();
        for(IOffer offer : this.offers){
            bill -= offer.saving(this.basket);
        }
        return bill;
    }
}
