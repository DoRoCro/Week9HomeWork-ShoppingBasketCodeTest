package com.codeclan.shoppingbasketcodetest;

import java.util.ArrayList;

/**
 * Created by DRC on 01/04/2017.
 * Design decision - its the responsibility of the checkout to track / calculate bills, so any
 * intermediate calcs done in the checkout, not in the basket
 */

class Checkout {

    private ShoppingBasket basket;
    private ArrayList<IOffer> offers;
    private Integer billBeforeDiscounts;
    private Integer billAfterItemDiscounts;
    private Integer billAfterBasketDiscounts;

    public Checkout(ShoppingBasket basket, ArrayList<IOffer> offers) {
        this.basket = basket;
        this.offers = offers;
        this.billBeforeDiscounts = 0;
        this.billAfterItemDiscounts = 0;
        this.billAfterBasketDiscounts = 0;
        this.calcNoDiscountsBill();
        this.calcWithItemDiscountsBill();
        this.calcWithBasketDiscountsBill();
    }

    public Checkout(ShoppingBasket basket) {
        this.basket = basket;
        this.billBeforeDiscounts = 0;
        this.billAfterItemDiscounts = 0;
        this.billAfterBasketDiscounts = 0;
        this.calcNoDiscountsBill();
        this.billAfterItemDiscounts = this.billBeforeDiscounts;
        this.billAfterBasketDiscounts = this.billAfterItemDiscounts;
    }

    private void calcNoDiscountsBill() {
        this.billBeforeDiscounts = 0;
        for(ShoppingItem item : this.basket.getItems().keySet()){
            this.billBeforeDiscounts += item.getPrice() * this.basket.count(item);
        }
    }

    private void calcWithItemDiscountsBill() {
        this.billAfterItemDiscounts = this.billBeforeDiscounts;
        // apply item discounts first
        for(IOffer offer : this.offers){
            if(offer.appliesTo() == ShoppingItem.class){
                this.billAfterItemDiscounts -= offer.saving(this);
            }
        }

    }
    private void calcWithBasketDiscountsBill() {
        // apply basket discounts after item offers
        this.billAfterBasketDiscounts = this.billAfterItemDiscounts;
        for (IOffer offer : this.offers) {
            if (offer.appliesTo() == ShoppingBasket.class) {
                this.billAfterBasketDiscounts -= offer.saving(this);
            }
        }
    }

    public Integer getBillBeforeDiscounts() {
        return billBeforeDiscounts;
    }

    public Integer getBillAfterItemDiscounts() {
        return billAfterItemDiscounts;
    }

    public Integer getBillAfterBasketDiscounts() {
        return billAfterBasketDiscounts;
    }

    public ShoppingBasket getBasket() {
        return this.basket;
    }
}
