package com.shopsphere.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class CheckoutTests extends BaseTest {
    @Test
    public void checkoutPageLoads() {
        addFirstProductToCart();
        driver.get(Config.CHECKOUT_URL);

        waitForAny(
            By.cssSelector("form.checkout"),
            By.cssSelector(".woocommerce-checkout"),
            By.cssSelector(".wc-block-checkout")
        );
        Assert.assertTrue(
            driver.findElements(By.cssSelector("#payment, .wc-block-checkout__payment-method")).size() > 0,
            "Payment section should be visible"
        );
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("cash on delivery"),
            "Cash on delivery should be available");
    }
}
