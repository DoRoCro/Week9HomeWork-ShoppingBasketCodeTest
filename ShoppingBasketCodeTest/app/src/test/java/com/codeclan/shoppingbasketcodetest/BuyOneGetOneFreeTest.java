package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 */

public class BuyOneGetOneFreeTest {

    ShoppingItem cheese;
    BuyOneGetOneFree offerCheese;

    @Before
    public void before() {
        cheese = new ShoppingItem("250g Brie", 125);
        offerCheese = new BuyOneGetOneFree(cheese);
    }

    @Test
    public void canGetClass() throws Exception {
        assertEquals(ShoppingItem.class, offerCheese.appliesTo());
    }
}
