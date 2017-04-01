package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 * Applies 10% discount when basket total over £20 (= 2000p)
 */

public class BasketDiscountOverThresholdTest{

    private ShoppingItem cheese;
    private ShoppingItem giftCard;
    private ShoppingBasket basket;
    private BasketDiscountOverThreshold discountOver20;


    @Before
    public void before(){
        cheese = new ShoppingItem("250g Brie", 125);
        giftCard = new ShoppingItem("iTunes Gift Card", 1000);
        basket = new ShoppingBasket();
        discountOver20 = new BasketDiscountOverThreshold((Integer)2000, 10.0f);
        basket.add(giftCard);
        basket.add(giftCard);
    }

    @Test
    public void canApplyDiscountToBasket() throws Exception {
        assertEquals((Integer)200, discountOver20.saving(basket));
    }
}