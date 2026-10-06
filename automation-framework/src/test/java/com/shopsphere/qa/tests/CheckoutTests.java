package com.shopsphere.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class CheckoutTests extends BaseTest {
    @Test
    public void successfulGuestCheckout() {
        addFirstProductToCart();
        driver.get(Config.CHECKOUT_URL);

        waitForAny(
            By.cssSelector("form.checkout"),
            By.cssSelector(".woocommerce-checkout"),
            By.cssSelector(".wc-block-checkout")
        );

        List<WebElement> countryFields = driver.findElements(By.cssSelector(
            "#shipping-country, #billing_country, select[name='shipping_country'], select[name='billing_country']"
        ));
        if (!countryFields.isEmpty()) {
            new Select(countryFields.get(0)).selectByVisibleText("Sri Lanka");
        }

        By emailSelector = By.cssSelector(
            "#email, #billing_email, input[name='billing_email'], input[name='email']"
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailSelector));
        driver.findElement(emailSelector).sendKeys("guest.checkout@example.com");
        driver.findElement(By.cssSelector(
            "#shipping-first_name, #billing_first_name, input[name='shipping_first_name'], input[name='billing_first_name']"
        )).sendKeys("Guest");
        driver.findElement(By.cssSelector(
            "#shipping-last_name, #billing_last_name, input[name='shipping_last_name'], input[name='billing_last_name']"
        )).sendKeys("Customer");
        driver.findElement(By.cssSelector(
            "#shipping-address_1, #billing_address_1, input[name='shipping_address_1'], input[name='billing_address_1']"
        )).sendKeys("123 Test Street");
        driver.findElement(By.cssSelector(
            "#shipping-city, #billing_city, input[name='shipping_city'], input[name='billing_city']"
        )).sendKeys("Colombo");
        driver.findElement(By.cssSelector(
            "#shipping-postcode, #billing_postcode, input[name='shipping_postcode'], input[name='billing_postcode']"
        )).sendKeys("10100");

        waitForAny(
            By.cssSelector("#payment, .wc-block-checkout__payment-method"),
            By.cssSelector("input[value='cod'], #payment_method_cod, #radio-control-wc-payment-method-options-cod")
        );
        List<WebElement> cashOnDelivery = driver.findElements(By.cssSelector(
            "input[value='cod'], #payment_method_cod, #radio-control-wc-payment-method-options-cod"
        ));
        if (!cashOnDelivery.isEmpty() && !cashOnDelivery.get(0).isSelected()) {
            cashOnDelivery.get(0).click();
        }

        By placeOrderSelector = By.cssSelector(
            "#place_order, button[name='woocommerce_checkout_place_order'], .wc-block-components-checkout-place-order-button"
        );
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderSelector)).click();

        By confirmationSelector = By.cssSelector(
            ".woocommerce-order, .woocommerce-thankyou-order-received, .wc-block-components-order-confirmation"
        );
        By confirmationTextSelector = By.xpath(
            "//*[contains(translate(normalize-space(), 'THANKYOUORDERRECEIVED', 'thankyouorderreceived'), 'thank you') "
                + "or contains(translate(normalize-space(), 'THANKYOUORDERRECEIVED', 'thankyouorderreceived'), 'order received')]"
        );
        wait.until(driver -> driver.findElements(confirmationSelector).stream().anyMatch(WebElement::isDisplayed)
            || driver.findElements(confirmationTextSelector).stream().anyMatch(WebElement::isDisplayed));
        Assert.assertTrue(
            driver.findElement(By.tagName("body")).getText().toLowerCase().contains("thank you")
                || driver.findElement(By.tagName("body")).getText().toLowerCase().contains("order received"),
            "Order confirmation message should be visible"
        );
        List<WebElement> orderNumberElements = driver.findElements(By.cssSelector(
            ".woocommerce-order-overview__order strong, .woocommerce-order-overview li strong, .order-number, .wc-block-components-order-confirmation__order-number"
        ));
        orderNumberElements.addAll(driver.findElements(By.xpath(
            "//*[contains(translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'order number') "
                + "or contains(translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'order #')]"
        )));
        String confirmationBody = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(
            orderNumberElements.stream().anyMatch(element -> element.getText().matches(".*\\d+.*"))
                || confirmationBody.matches("(?s).*Order\\s*#\\s*:\\s*\\d+.*")
                || confirmationBody.matches("(?s).*Order\\s+number\\s*:?\\s*\\d+.*"),
            "Order number should be displayed"
        );
    }

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
