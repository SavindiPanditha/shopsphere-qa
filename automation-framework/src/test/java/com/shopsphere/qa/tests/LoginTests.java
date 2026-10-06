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
    public void loginWithValidCredentials() {
        if (Config.TEST_USER.isBlank() || Config.TEST_PASS.isBlank()) {
            throw new SkipException("Test customer credentials not provided via environment variables");
        }

        ensureLoggedOut();
        driver.get(Config.ACCOUNT_URL);

        List<WebElement> loginUser = driver.findElements(By.cssSelector("#username, input[name='username'], input[name='email']"));
        List<WebElement> loginPass = driver.findElements(By.cssSelector("#password, input[name='password']"));
        if (loginUser.isEmpty() || loginPass.isEmpty()) {
            throw new SkipException("Login form not available");
        }

        loginUser.get(0).sendKeys(Config.TEST_USER);
        loginPass.get(0).sendKeys(Config.TEST_PASS);
        driver.findElement(By.cssSelector("button[name='login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-MyAccount-content")));
        Assert.assertTrue(driver.getPageSource().contains("Hello"), "Account greeting should be visible after login");
    }

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
