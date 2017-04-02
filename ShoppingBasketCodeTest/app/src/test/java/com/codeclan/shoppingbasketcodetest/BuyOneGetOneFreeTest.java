package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 *
 */

public class BuyOneGetOneFreeTest {

    ShoppingItem cheese;
    BuyOneGetOneFree offerCheese;
    ShoppingBasket basket;
    Checkout checkout;
    ArrayList<IOffer> offers;

    @Before
    public void before() {
        cheese = new ShoppingItem("250g Brie", 125);
        offerCheese = new BuyOneGetOneFree(cheese);
        basket = new ShoppingBasket();
        offers = new ArrayList<IOffer>();
        offers.add(offerCheese);
        checkout = new Checkout(basket, offers);
    }

    @Test
    public void canGetClass() throws Exception {
        assertEquals(ShoppingItem.class, offerCheese.appliesTo());
    }

    @Test
    public void canGetSavingForTwoItems() throws Exception {
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer)125, offerCheese.saving(checkout));
    }

    @Test
    public void canGetSavingForOneItems() throws Exception {
        basket.add(cheese);
        assertEquals((Integer)0, offerCheese.saving(checkout));
    }

    @Test
    public void canGetSavingForZeroItems() throws Exception {
        assertEquals((Integer)0, offerCheese.saving(checkout));
    }

    @Test
    public void canGetSavingForThreeItems() throws Exception {
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer)125, offerCheese.saving((checkout)));
    }

    @Test
    public void canGetSavingForFourItems() throws Exception {
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer)250, offerCheese.saving(checkout));
    }

    @Test
    public void canGetNoSavingsForNonBogofItem(){
        ShoppingItem milk = new ShoppingItem("1pt Semi-Skimmed Milk", 87);
        basket.add(milk);
        basket.add(milk);
        assertEquals((Integer) 0 , offerCheese.saving(checkout));
    }

}
