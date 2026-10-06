package com.shopsphere.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class CartTests extends BaseTest {
    @Test
    public void removeProductFromCart() {
        addFirstProductToCart();
        driver.get(Config.CART_URL);

        By cartItemSelector = By.cssSelector("tr.cart_item, .wc-block-cart-items__row");
        waitForAny(
            By.cssSelector("form.woocommerce-cart-form"),
            By.cssSelector(".cart"),
            By.cssSelector(".wc-block-cart"),
            By.cssSelector(".cart_totals")
        );
        wait.until(driver -> !driver.findElements(cartItemSelector).isEmpty());
        Assert.assertFalse(
            driver.findElements(cartItemSelector).isEmpty(),
            "Cart item should be present before removal"
        );

        By removeSelector = By.cssSelector(
            "a.remove, button.wc-block-cart-item__remove-link, button[aria-label^='Remove'][aria-label*='cart']"
        );
        wait.until(driver -> !driver.findElements(removeSelector).isEmpty());
        wait.until(ExpectedConditions.elementToBeClickable(removeSelector)).click();

        wait.until(driver -> driver.findElements(cartItemSelector).isEmpty());
        By emptyCartSelector = By.cssSelector(
            "p.cart-empty, .wc-block-cart__empty-cart, .wc-block-cart__empty-cart__title"
        );
        By emptyCartTextSelector = By.xpath("//*[contains(normalize-space(), 'Your cart is currently empty')]");
        waitForAny(emptyCartSelector, emptyCartTextSelector);
        Assert.assertTrue(
            driver.findElements(cartItemSelector).isEmpty(),
            "Cart item should no longer be present after removal"
        );
        Assert.assertTrue(
            !driver.findElements(emptyCartSelector).isEmpty()
                || !driver.findElements(emptyCartTextSelector).isEmpty(),
            "Empty cart state should be visible after removal"
        );
    }

    @Test
    public void updateCartQuantity() {
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

        By quantitySelector = By.cssSelector(
            "input.qty, input[name^='cart'][name$='[qty]'], input.wc-block-components-quantity-selector__input"
        );
        wait.until(driver -> !driver.findElements(quantitySelector).isEmpty());
        List<WebElement> quantityInputs = driver.findElements(quantitySelector);
        if (quantityInputs.isEmpty()) {
            throw new SkipException("Cart quantity input not available");
        }

        List<WebElement> updateButtons = driver.findElements(
            By.cssSelector("button[name='update_cart'], input[name='update_cart']")
        );
        if (!updateButtons.isEmpty()) {
            quantityInputs.get(0).clear();
            quantityInputs.get(0).sendKeys("2");
            updateButtons.get(0).click();
        } else {
            List<WebElement> plusButtons = driver.findElements(
                By.cssSelector("button.wc-block-components-quantity-selector__button--plus")
            );
            if (!plusButtons.isEmpty()) {
                plusButtons.get(0).click();
            } else {
                quantityInputs.get(0).clear();
                quantityInputs.get(0).sendKeys("2");
                quantityInputs.get(0).sendKeys(Keys.TAB);
            }
        }

        waitForAny(
            By.cssSelector("form.woocommerce-cart-form"),
            By.cssSelector(".wc-block-cart"),
            By.cssSelector(".woocommerce-message"),
            By.cssSelector(".wc-block-components-notice-banner")
        );
        wait.until(driver -> driver.findElements(quantitySelector).stream()
            .anyMatch(input -> "2".equals(input.getAttribute("value"))));
        Assert.assertEquals(
            driver.findElements(quantitySelector).get(0).getAttribute("value"),
            "2",
            "Cart quantity should be updated to 2"
        );
    }

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
