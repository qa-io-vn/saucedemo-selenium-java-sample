package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {

    private final WebDriver driver;

    // Locators
    private final By title = By.className("title");
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get inventory page title")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Check if title is displayed")
    public boolean isTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    @Step("Logout from application")
    public void logout() {
        driver.findElement(burgerMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
