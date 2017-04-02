package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    private Checkout checkout;
    private ArrayList<IOffer> offers;


    @Before
    public void before(){
        cheese = new ShoppingItem("250g Brie", 125);
        giftCard = new ShoppingItem("iTunes Gift Card", 1000);
        basket = new ShoppingBasket();
        discountOver20 = new BasketDiscountOverThreshold((Integer)2000, 10.0f);
        offers = new ArrayList<IOffer>();
        offers.add(discountOver20);
        basket.add(giftCard);
        basket.add(giftCard);
        checkout = new Checkout(basket, offers);

    }

    @Test
    public void canApplyDiscountToBasket() throws Exception {
        assertEquals((Integer)200, discountOver20.saving(checkout));
    }

    @Test
    public void willNotDiscountBelowThreshold() throws Exception {
        basket.remove(giftCard);
        basket.add(cheese);
        assertEquals((Integer)0, discountOver20.saving(new Checkout(basket, offers)));
    }
}