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
    private LoyaltyCard loyaltycard;
    private ArrayList<IOffer> offers;
    private BasketDiscountOverThreshold discountOver20;

    @Before
    public void before() throws Exception{
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
        discountOver20 = new BasketDiscountOverThreshold( 2000, 10.0f);
        loyaltycard = new LoyaltyCard(2.0f);
        offers = new ArrayList<IOffer>();

    }

    @Test
    public void emptyBasketCalculatesZeroBill() throws Exception{
        checkout = new Checkout(new ShoppingBasket());
        assertEquals((Integer)0, checkout.getBillBeforeDiscounts());
    }

    @Test
    public void canCalculateBillNoOffers() throws Exception{
        checkout = new Checkout(basket);
        assertEquals((Integer)(125+87+650+1000), checkout.getBillBeforeDiscounts());
    }

    @Test
    public void canCalculateBillWithEmptyOffers() throws Exception {
        checkout = new Checkout(basket, new ArrayList<IOffer>());
        assertEquals((Integer)(125+87+650+1000), checkout.getBillBeforeDiscounts());
        assertEquals((Integer)(125+87+650+1000), checkout.getBillAfterCardDiscounts());
    }

    @Test
    public void canCalculateBillWithBogof() throws Exception{
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
    public void canCalculateBillWith2Bogofs() throws Exception {
        basket.add(cheese);
        offers.add(offerCheese);
        offers.add(new BuyOneGetOneFree(giftCard));
        basket.add(giftCard);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)(125+87+650+1000+125+1000), checkout.getBillBeforeDiscounts());
        assertEquals((Integer)(125+87+650+1000), checkout.getBillAfterItemDiscounts());
    }


    @Test
    public void canCalculateWithBogofAndBasketDiscount() throws Exception {
        basket.add(cheese);
        basket.add(giftCard);
        offers.add(offerCheese);
        offers.add(discountOver20);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer) (125 + 87 + 650 + 1000 + 125 + 1000), checkout.getBillBeforeDiscounts());
        assertEquals((Integer) (125 + 87 + 650 + 1000 + 1000), checkout.getBillAfterItemDiscounts());
        assertEquals((Integer) ((125 + 87 + 650 + 1000 + 1000) - (125 + 87 + 650 + 1000 + 1000) / 10), checkout.getBillAfterBasketDiscounts());
        assertEquals((Integer) ((125 + 87 + 650 + 1000 + 1000) - (125 + 87 + 650 + 1000 + 1000) / 10), checkout.getBillAfterCardDiscounts());
    }


    @Test
    public void canCalculateAllDiscounts() throws Exception {
        basket.add(cheese);
        basket.add(giftCard);
        offers.add(offerCheese);
        offers.add(discountOver20);
        offers.add(loyaltycard);
        checkout = new Checkout(basket, offers);
        System.out.println(checkout);
        int bill = 125 + 87 + 650 + 1000 + 125 + 1000;
        assertEquals((Integer) bill, checkout.getBillBeforeDiscounts());
        bill = bill -  125;
        assertEquals((Integer) bill, checkout.getBillAfterItemDiscounts());
        bill = bill - (bill / 10);
        assertEquals((Integer) bill, checkout.getBillAfterBasketDiscounts());
        bill = bill - (bill / 50);
        assertEquals((Integer) bill, checkout.getBillAfterCardDiscounts());
    }

    @Test
    public void testEffectOfRepeatedBogofs() throws Exception {
        // multiply defined BOGOFs accumulate, i.e. if defined twice, will double discount.
        basket.add(cheese);
        offers.add(offerCheese);
        offers.add(offerCheese);
        checkout = new Checkout(basket, offers);
        assertEquals((Integer)(125+87+650+1000+125), checkout.getBillBeforeDiscounts());
        assertEquals((Integer)(125+87+650+1000-125), checkout.getBillAfterItemDiscounts());

    }
}
