package com.shopsphere.qa.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.shopsphere.qa.utils.Config;
import com.shopsphere.qa.utils.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1280,800");
        if (Config.isHeadless()) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        DriverManager.setDriver(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        DriverManager.clearDriver();
    }

    protected void addFirstProductToCart() {
        openFirstProduct();
        waitForAny(
                By.cssSelector("button.single_add_to_cart_button"),
                By.cssSelector("form.cart")
        );
        List<WebElement> addButtons = driver.findElements(By.cssSelector("button.single_add_to_cart_button"));
        if (addButtons.isEmpty()) {
            throw new SkipException("No add-to-cart button found on product page");
        }
        addButtons.get(0).click();
        waitForAny(
                By.cssSelector(".woocommerce-message"),
                By.cssSelector("a.added_to_cart"),
                By.cssSelector(".wc-block-components-notice-banner")
        );
    }

    protected void ensureLoggedOut() {
        driver.get(Config.ACCOUNT_URL);
        List<WebElement> logoutLinks = driver.findElements(By.cssSelector(".woocommerce-MyAccount-navigation-link--customer-logout a"));
        if (!logoutLinks.isEmpty()) {
            logoutLinks.get(0).click();
        }
    }

    protected void waitForProductsGrid() {
        waitForAny(
                By.cssSelector("ul.products"),
                By.cssSelector(".products"),
                By.cssSelector(".wc-block-grid__products"),
                By.cssSelector("li.product"),
                By.cssSelector(".wc-block-grid__product"),
            By.cssSelector(".woocommerce-result-count"),
            By.cssSelector(".woocommerce-products-header")
        );
    }

    protected void openFirstProduct() {
        driver.get(Config.SHOP_URL);
        waitForProductsGrid();
        List<WebElement> productCards = driver.findElements(By.cssSelector("li.product, .wc-block-grid__product"));
        for (WebElement card : productCards) {
            List<WebElement> anchors = card.findElements(By.cssSelector("a"));
            for (WebElement link : anchors) {
                String classes = link.getAttribute("class");
                String href = link.getAttribute("href");
                if ((classes != null && classes.contains("add_to_cart")) ||
                        (href != null && href.contains("add-to-cart"))) {
                    continue;
                }
                if (href != null && href.contains("/product/")) {
                    String before = driver.getCurrentUrl();
                    link.click();
                    wait.until(d -> !d.getCurrentUrl().equals(before));
                    waitForAny(
                            By.cssSelector("body.single-product"),
                            By.cssSelector(".product"),
                            By.cssSelector(".summary")
                    );
                    return;
                }
            }
        }
        List<WebElement> productLinks = driver.findElements(By.cssSelector("a[href*='/product/']"));
        if (!productLinks.isEmpty()) {
            String before = driver.getCurrentUrl();
            productLinks.get(0).click();
            wait.until(d -> !d.getCurrentUrl().equals(before));
            waitForAny(
                    By.cssSelector("body.single-product"),
                    By.cssSelector(".product"),
                    By.cssSelector(".summary")
            );
            return;
        }
        throw new SkipException("No product links found on shop page");
    }

    protected void waitForNotices() {
        waitForAny(
                By.cssSelector(".woocommerce-error"),
                By.cssSelector(".woocommerce-notices-wrapper"),
                By.cssSelector(".wc-block-components-notice-banner")
        );
    }

    protected void waitForAny(By... locators) {
        wait.until(driver -> {
            for (By locator : locators) {
                if (!driver.findElements(locator).isEmpty()) {
                    return true;
                }
            }
            return false;
        });
    }
}
