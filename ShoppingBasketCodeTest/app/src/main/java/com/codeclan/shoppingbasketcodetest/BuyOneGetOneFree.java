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
    // initial choice - one instance per offer, passing to checkout as a list of offers to be processed

    ShoppingItem bogofItem;

    @Override
    public Class appliesTo() {
        return ShoppingItem.class;
    }

    @Override
    public Integer saving(Object count) {
        // need to pass in count of items somehow
        int numberDiscounts = (Integer)count / 2;
        return numberDiscounts * this.bogofItem.getPrice();
    }

    public BuyOneGetOneFree(ShoppingItem item){
        this.bogofItem = item;
    }
}
