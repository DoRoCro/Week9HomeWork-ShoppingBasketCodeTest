package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 *
 */

public class BuyOneGetOneFreeTest {

    ShoppingItem cheese;
    BuyOneGetOneFree offerCheese;
    ShoppingBasket basket;

    @Before
    public void before() {
        cheese = new ShoppingItem("250g Brie", 125);
        offerCheese = new BuyOneGetOneFree(cheese);
        basket = new ShoppingBasket();
    }

    @Test
    public void canGetClass() throws Exception {
        assertEquals(ShoppingItem.class, offerCheese.appliesTo());
    }

    @Test
    public void canGetSavingForTwoItems() throws Exception {
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer)125, offerCheese.saving(basket));
    }

    @Test
    public void canGetSavingForOneItems() throws Exception {
        basket.add(cheese);
        assertEquals((Integer)0, offerCheese.saving(basket));
    }

    @Test
    public void canGetSavingForZeroItems() throws Exception {
        assertEquals((Integer)0, offerCheese.saving(basket));
    }

    @Test
    public void canGetSavingForThreeItems() throws Exception {
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer)125, offerCheese.saving((basket)));
    }

    @Test
    public void canGetSavingForFourItems() throws Exception {
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer)250, offerCheese.saving(basket));
    }
}
