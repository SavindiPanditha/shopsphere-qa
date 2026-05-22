package com.shopsphere.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;

public class ProductTests extends BaseTest {
    @Test
    public void viewProductDetails() {
        openFirstProduct();
        waitForAny(
            By.cssSelector("body.single-product"),
            By.cssSelector(".product"),
            By.cssSelector(".summary"),
            By.cssSelector("button.single_add_to_cart_button")
        );
        boolean hasTitle = !driver.findElements(By.cssSelector("h1.product_title, h1.entry-title, .summary h1")).isEmpty();
        boolean hasAddToCart = !driver.findElements(By.cssSelector("button.single_add_to_cart_button")).isEmpty();
        boolean hasPrice = !driver.findElements(By.cssSelector("p.price, .price, .woocommerce-Price-amount")).isEmpty();
        Assert.assertTrue(hasTitle || hasAddToCart, "Product page should show title or add-to-cart");
        Assert.assertTrue(hasPrice, "Product price should be visible");
    }
}
