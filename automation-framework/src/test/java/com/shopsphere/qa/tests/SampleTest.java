package com.shopsphere.qa.tests;

import com.shopsphere.qa.base.BaseTest;
import com.shopsphere.qa.pages.HomePage;
import com.shopsphere.qa.utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {
    @Test
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.open(Config.BASE_URL);
        Assert.assertFalse(driver.getTitle().isBlank(), "Page title should not be blank");
    }
}
