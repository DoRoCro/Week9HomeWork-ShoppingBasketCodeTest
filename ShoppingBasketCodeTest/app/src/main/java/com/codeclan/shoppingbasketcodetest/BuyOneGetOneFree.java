package com.codeclan.shoppingbasketcodetest;

/**
 * Created by DRC on 01/04/2017.
 *
 */

public class BuyOneGetOneFree implements IOffer {
    // Design choice: either
    //    have one instance per item under offer,
    // or
    //    have a single BOGOF object with a list of items included in the offer
    // initial choice - one instance per offer, (single responsibility)

    private ShoppingItem bogofItem;

    @Override
    public Class appliesTo() {
        return ShoppingItem.class;
    }

    @Override
    public Integer saving(ShoppingBasket basket) {
        int numberDiscounts =  basket.count(this.bogofItem)/ 2;
        return numberDiscounts * this.bogofItem.getPrice();
    }

    public BuyOneGetOneFree(ShoppingItem item){
        this.bogofItem = item;
    }
}
