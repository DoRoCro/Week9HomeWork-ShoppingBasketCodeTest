package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 01/04/2017.
 * ShoppingBasketTest
 */

public class ShoppingBasketTest {

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
    public void canEmptyBasket(){
        basket.add(cheese);
        basket.add(milk);
        basket.add(knife);
        basket.add(giftCard);
        assertEquals((Integer) 4, basket.itemCount());
        basket.empty();
        assertEquals((Integer) 0, basket.itemCount());
    }

    @Test
    public void has1CheeseAfterAdding2Removing1FromBasket(){
        basket.add(cheese);
        basket.add(cheese);
        basket.remove((cheese));
        assertEquals((Integer)1, basket.count(cheese));
    }

    @Test
    public void has0CheeseAfterAdding1Removing1FromBasket(){
        basket.add(cheese);
        basket.remove((cheese));
        assertEquals((Integer)0, basket.count(cheese));
    }

    @Test
    public void canCountManyOfTheSameItemInTheBasket() {
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        basket.add(cheese);
        assertEquals((Integer) 4, basket.count(cheese));
    }

    @Test
    public void cannotRemoveFromNewBasket(){
        basket.remove(cheese);
        assertEquals((Integer) 0, basket.count(cheese));
        assertEquals((Integer) 0, basket.itemCount());
    }
}
