package com.shopsphere.qa.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver, Duration timeout) {
        this.wait = new WebDriverWait(driver, timeout);
    }

    public void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
