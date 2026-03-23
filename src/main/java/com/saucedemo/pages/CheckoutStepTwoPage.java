package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage {
    private final WebDriver driver;

    private final By finishButton = By.id("finish");
    private final By cartItemName = By.className("inventory_item_name");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get cart item name")
    public String getCartItemName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemName)).getText();
    }

    @Step("Click finish button")
    public void clickFinish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }
}
