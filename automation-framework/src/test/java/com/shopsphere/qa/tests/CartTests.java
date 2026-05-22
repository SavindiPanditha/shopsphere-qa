package com.shopsphere.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class CartTests extends BaseTest {
    @Test
    public void addProductToCart() {
        addFirstProductToCart();
        driver.get(Config.CART_URL);

        waitForAny(
            By.cssSelector("form.woocommerce-cart-form"),
            By.cssSelector(".cart"),
            By.cssSelector(".wc-block-cart"),
            By.cssSelector(".cart_totals")
        );
        Assert.assertTrue(
            driver.findElements(By.cssSelector("tr.cart_item, .wc-block-cart-items__row")).size() > 0,
            "Cart item should be present"
        );
    }
}
