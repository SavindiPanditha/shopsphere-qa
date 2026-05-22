package com.shopsphere.qa.tests;

import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class LoginTests extends BaseTest {
    @Test
    public void registerNewCustomer() {
        ensureLoggedOut();
        driver.get(Config.ACCOUNT_URL);

        List<WebElement> emailInputs = driver.findElements(By.cssSelector("#reg_email, input[name='email']"));
        List<WebElement> passInputs = driver.findElements(By.cssSelector("#reg_password, input[name='password']"));
        if (emailInputs.isEmpty() || passInputs.isEmpty()) {
            throw new SkipException("Registration form not available");
        }

        String email = "user" + Instant.now().toEpochMilli() + "@example.com";
        emailInputs.get(0).sendKeys(email);
        passInputs.get(0).sendKeys("Test@12345");
        driver.findElement(By.cssSelector("button[name='register']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-MyAccount-content")));
        Assert.assertTrue(driver.getPageSource().contains("Hello"), "Account greeting should be visible");
    }
}
