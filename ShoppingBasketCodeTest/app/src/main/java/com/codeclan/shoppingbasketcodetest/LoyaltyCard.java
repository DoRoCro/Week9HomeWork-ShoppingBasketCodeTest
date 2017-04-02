package com.codeclan.shoppingbasketcodetest;

/**
 * Created by DRC on 02/04/2017.
 * appliesTo returns Checkout as different from ShoppingItem and ShoppingBasket to be distinct for ordering of
 * discount operation.  Could alternatively return a Shopper class if preferred, but not yet implemented in this model
 * as beyond brief.
 */

public class LoyaltyCard implements IOffer {

    private float discountPercent;

    @Override
    public Class appliesTo() {
        return Checkout.class;
    }

    @Override
    public Integer saving(Checkout checkout) {
        // mimicing int arithmetic used in testing here for consistency when using integer arithmetic for money.
        // otherwise rounding problems in tests.
        double savings = Math.floor(checkout.getBillAfterBasketDiscounts().floatValue() * discountPercent / 100f);
        return (Integer) (int) savings;
    }

    public LoyaltyCard(float discountPercent) {
        this.discountPercent = discountPercent;
    }
}
