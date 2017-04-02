package com.codeclan.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by DRC on 02/04/2017.
 */

public class LoyaltyCardTest {

    private ShoppingItem cheese;
    private ShoppingItem giftCard;
    private ShoppingBasket basket;
    private Checkout checkout;
    private ArrayList<IOffer> offers;
    private LoyaltyCard loyaltycard;



    @Before
    public void setUp() throws Exception {
        cheese = new ShoppingItem("250g Brie", 125);
        giftCard = new ShoppingItem("iTunes Gift Card", 1000);
        basket = new ShoppingBasket();
        loyaltycard = new LoyaltyCard(2.0f);
        offers = new ArrayList<IOffer>();
        offers.add(loyaltycard);
        basket.add(giftCard);
//        basket.add(cheese);

    }

    @Test
    public void canGetSavingsOnCard() throws Exception {
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)20, loyaltycard.saving(checkout));
    }

    @Test
    public void noFailureWithoutCard() throws Exception {
        checkout = new Checkout(basket, new ArrayList<IOffer>());
        assertEquals((Integer)1000, checkout.getBillAfterCardDiscounts() );
    }
}
