package com.shopsphere.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class NegativeTests extends BaseTest {
    @Test
    public void loginWithInvalidCredentials() {
        ensureLoggedOut();
        driver.get(Config.ACCOUNT_URL);

        List<WebElement> loginUser = driver.findElements(By.id("username"));
        List<WebElement> loginPass = driver.findElements(By.id("password"));
        if (loginUser.isEmpty() || loginPass.isEmpty()) {
            throw new SkipException("Login form not available");
        }

        loginUser.get(0).sendKeys("invalid_user");
        loginPass.get(0).sendKeys("invalid_pass");
        driver.findElement(By.cssSelector("button[name='login']")).click();

        waitForNotices();
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("error"), "Error message should appear");
    }

    @Test
    public void checkoutRequiredFieldValidation() {
        addFirstProductToCart();
        driver.get(Config.CHECKOUT_URL);

        waitForAny(
            By.cssSelector("form.checkout"),
            By.cssSelector(".woocommerce-checkout"),
            By.cssSelector(".wc-block-checkout")
        );
        if (!driver.findElements(By.id("place_order")).isEmpty()) {
            driver.findElement(By.id("place_order")).click();
        } else {
            driver.findElement(By.cssSelector(".wc-block-components-checkout-place-order-button, button[name='woocommerce_checkout_place_order']")).click();
        }

        waitForAny(
            By.cssSelector(".woocommerce-error"),
            By.cssSelector(".wc-block-components-notice-banner"),
            By.cssSelector(".wc-block-components-validation-error")
        );
        Assert.assertTrue(
            driver.findElements(By.cssSelector(".woocommerce-error, .wc-block-components-notice-banner, .wc-block-components-validation-error")).size() > 0,
            "Validation errors should appear"
        );
    }
}
