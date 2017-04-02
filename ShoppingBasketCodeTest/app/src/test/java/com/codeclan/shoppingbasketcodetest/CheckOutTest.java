package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    private BuyOneGetOneFree offerCheese;
    private ArrayList<IOffer> offers;

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
        offerCheese = new BuyOneGetOneFree(cheese);
        offers = new ArrayList<IOffer>();

    }

    @Test
    public void emptyBasketCalculatesZeroBill(){
        checkout = new Checkout(new ShoppingBasket());
        assertEquals((Integer)0, checkout.getBillBeforeDiscounts());
    }

    @Test
    public void canCalculateBillNoOffers(){
        checkout = new Checkout(basket);
        assertEquals((Integer)(125+87+650+1000), checkout.getBillBeforeDiscounts());
    }

    @Test
    public void canCalculateBillWithBogof(){
        basket.add(cheese);
        offers.add(offerCheese);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)(125+87+650+1000+125), checkout.getBillBeforeDiscounts());
        assertEquals((Integer)(125+87+650+1000), checkout.getBillAfterItemDiscounts());
        basket.add(cheese);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)(125+87+650+1000+125), checkout.getBillAfterItemDiscounts());
        basket.add(cheese);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)(125+87+650+1000+125), checkout.getBillAfterItemDiscounts());
    }

    @Test
    public void canCalculateBillWith2Bogofs() {
        basket.add(cheese);
        offers.add(offerCheese);
        offers.add(new BuyOneGetOneFree(giftCard));
        basket.add(giftCard);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)(125+87+650+1000+125+1000), checkout.getBillBeforeDiscounts());
        assertEquals((Integer)(125+87+650+1000), checkout.getBillAfterItemDiscounts());
    }

}
