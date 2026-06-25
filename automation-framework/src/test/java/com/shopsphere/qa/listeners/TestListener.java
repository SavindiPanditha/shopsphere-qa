package com.shopsphere.qa.listeners;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.shopsphere.qa.utils.DriverManager;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("START: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAIL: " + result.getName());
        WebDriver driver = DriverManager.getDriver();
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            try {
                Path dir = Paths.get("target", "surefire-reports", "screenshots");
                Files.createDirectories(dir);
                Path file = dir.resolve(result.getName() + ".png");
                Files.write(file, screenshot);
                System.out.println("Saved failure screenshot: " + file.toAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIP: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("SUITE START: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("SUITE END: " + context.getName());
    }
}
