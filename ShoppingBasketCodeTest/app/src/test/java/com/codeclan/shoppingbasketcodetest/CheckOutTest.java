package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 */

public class CheckOutTest {

    private Checkout checkout;
    private ShoppingBasket basket;
    private ShoppingItem cheese;
    private ShoppingItem milk;
    private ShoppingItem knife;
    private ShoppingItem giftCard;

    @Before
    public void before(){
        basket = new ShoppingBasket();
        cheese = new ShoppingItem("250g Brie", 125);
        milk = new ShoppingItem("1pt Semi-Skimmed Milk", 87);
        knife = new ShoppingItem("Paring Knife", 650);
        giftCard = new ShoppingItem("iTunes Gift Card", 1000);
        basket.add(cheese);
        basket.add(milk);
        basket.add(knife);
        basket.add(giftCard);

    }

    @Test
    public void emptyBasketCalculateBill(){
        checkout = new Checkout();
        assertEquals((Integer)0, checkout.bill());
    }

}
