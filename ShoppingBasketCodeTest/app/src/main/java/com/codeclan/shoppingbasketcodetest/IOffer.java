package com.codeclan.shoppingbasketcodetest;

/**
 * Created by DRC on 01/04/2017.
 * Define what offer returns - what it applies to (used in ordering application of discounts)
 *                           - what the saving is based on what is at the checkout
 */

interface IOffer {
    Class appliesTo();
    Integer saving(Checkout checkout);
}