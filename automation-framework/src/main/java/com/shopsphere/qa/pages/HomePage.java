package com.shopsphere.qa.pages;

import org.openqa.selenium.WebDriver;

import com.shopsphere.qa.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }
}
