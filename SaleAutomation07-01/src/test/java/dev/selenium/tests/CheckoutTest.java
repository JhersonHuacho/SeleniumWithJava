package dev.selenium.tests;

import org.testng.annotations.Test;

public class CheckoutTest extends LoginTest {

    @Test (dependsOnMethods = {"doLoginAfterRegister"})
    public void addItemsToCart() {
        System.out.println("Method -> addItemsToCart");
    }

    @Test (dependsOnMethods = {"addItemsToCart"})
    public void checkoutPay() {
        System.out.println("Method -> addItemsToCart");
    }
}
