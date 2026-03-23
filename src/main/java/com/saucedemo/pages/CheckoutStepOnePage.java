package com.saucedemo.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepOnePage {
    private final WebDriver driver;

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill in information")
    public void fillInformation(String firstName, String lastName, String postalCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement firstNameElement = wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        
        WebElement lastNameElement = wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
        
        WebElement postalCodeElement = wait.until(ExpectedConditions.elementToBeClickable(postalCodeField));
        postalCodeElement.clear();
        postalCodeElement.sendKeys(postalCode);
    }

    @Step("Click continue button")
    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}
