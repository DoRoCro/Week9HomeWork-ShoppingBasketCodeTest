package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 */

public class ShoppingBasketTest {

    ShoppingBasket basket;
    ShoppingItem cheese;
    ShoppingItem milk;
    ShoppingItem knife;
    ShoppingItem giftCard;

    @Before
    public void before(){
        basket = new ShoppingBasket();
        cheese = new ShoppingItem("250g Brie", 125);
        milk = new ShoppingItem("1pt Semi-Skimmed Milk", 87);
        knife = new ShoppingItem("Paring Knife", 650);
        giftCard = new ShoppingItem("iTunes Gift Card", 1000);

    }

    @Test
    public void canAddItemToBasket(){
        basket.add(cheese);
        assertEquals((Integer) 1, basket.itemCount());
    }

    @Test
    public void canRemoveItemFromBasket() {
        basket.add(cheese);
        basket.add(milk);
        assertEquals((Integer)2, basket.itemCount());
        basket.remove(cheese);
        assertEquals((Integer)1, basket.itemCount());
    }

    @Test
    public void canEmptyBasket(){}

    @Test
    public void canCountManyOfTheSameItemInTheBasket(){}

}
