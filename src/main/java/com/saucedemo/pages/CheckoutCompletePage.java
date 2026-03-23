package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private final WebDriver driver;

    private final By completeHeader = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get complete header text")
    public String getCompleteHeaderText() {
        return driver.findElement(completeHeader).getText();
    }

    @Step("Is complete header displayed")
    public boolean isCompleteHeaderDisplayed() {
        return driver.findElement(completeHeader).isDisplayed();
    }
}
