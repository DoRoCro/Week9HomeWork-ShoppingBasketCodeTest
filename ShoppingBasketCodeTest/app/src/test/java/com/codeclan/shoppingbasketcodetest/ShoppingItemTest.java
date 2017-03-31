package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 31/03/2017.
 */

public class ShoppingItemTest {

    ShoppingItem cheese;
    ShoppingItem milk;
    ShoppingItem knife;
    ShoppingItem giftCard;

    @Before
    public void before() {
        cheese = new ShoppingItem("250g Brie", 125);
        milk = new ShoppingItem("1pt Semi-Skimmed Milk", 87);
        knife = new ShoppingItem("Paring Knife", 650);
        giftCard = new ShoppingItem("iTunes Gift Card", 1000);
    }


    @Test
    public void itemHasNameAndPrice(){
        assertEquals("250g Brie", cheese.getDescription());
        assertEquals((Integer)650, knife.getPrice());
    }
}
