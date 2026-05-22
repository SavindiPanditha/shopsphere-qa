package com.shopsphere.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.utils.Config;

public class AdminLoginTests extends BaseTest {
    @Test
    public void adminLogin() {
        if (Config.ADMIN_USER.isBlank() || Config.ADMIN_PASS.isBlank()) {
            throw new SkipException("Admin credentials not provided via environment variables");
        }

        driver.get(Config.ADMIN_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
        driver.findElement(By.id("user_login")).sendKeys(Config.ADMIN_USER);
        driver.findElement(By.id("user_pass")).sendKeys(Config.ADMIN_PASS);
        driver.findElement(By.id("wp-submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpadminbar")));
    }
}
