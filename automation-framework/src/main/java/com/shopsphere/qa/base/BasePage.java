package com.shopsphere.qa.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
