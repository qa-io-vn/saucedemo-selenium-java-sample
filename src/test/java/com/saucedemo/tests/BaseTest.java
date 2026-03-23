package com.saucedemo.tests;

import com.saucedemo.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(DriverManager.getUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverManager.quitDriver();
    }
}
