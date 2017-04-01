package com.codeclan.shoppingbasketcodetest;

/**
 * Created by DRC on 01/04/2017.
 */

class BasketDiscountOverThreshold implements IOffer{

    private Integer threshold;
    private float discountPercent;

    public BasketDiscountOverThreshold(Integer threshold, float discountPercent) {
        this.threshold = threshold;
        this.discountPercent = discountPercent;
    }

    @Override
    public Class appliesTo() {
        return ShoppingBasket.class;
    }

    @Override
    public Integer saving(ShoppingBasket basket) {
        return 200;
    }
}
