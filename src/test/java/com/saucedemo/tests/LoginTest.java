package com.saucedemo.tests;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login functionality")
public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login with standard user")
    @Story("Valid login")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulLoginWithStandardUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Inventory page title should be displayed");
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "Title should be 'Products'");
    }

    @Test(description = "Verify login error message for locked out user")
    @Story("Invalid login - Locked out user")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Should show locked out error message");
    }

    @Test(description = "Verify login with problem user")
    @Story("Valid login - Problem user")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("problem_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Inventory page title should be displayed");
    }

    @Test(description = "Verify login with performance glitch user")
    @Story("Valid login - Performance glitch user")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithPerformanceGlitchUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("performance_glitch_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Inventory page title should be displayed");
    }

    @Test(description = "Verify login with error user")
    @Story("Valid login - Error user")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithErrorUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("error_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Inventory page title should be displayed");
    }

    @Test(description = "Verify login with visual user")
    @Story("Valid login - Visual user")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithVisualUser() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("visual_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Inventory page title should be displayed");
    }

    @Test(description = "Verify login error for invalid username")
    @Story("Invalid login - Invalid username")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        loginPage.login("invalid_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Should show invalid credentials error message");
    }

    @Test(description = "Verify login error for invalid password")
    @Story("Invalid login - Invalid password")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Should show invalid credentials error message");
    }

    @Test(description = "Verify login error for empty username")
    @Story("Invalid login - Empty username")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Epic sadface: Username is required";

        loginPage.login("", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Should show username required error message");
    }

    @Test(description = "Verify login error for empty password")
    @Story("Invalid login - Empty password")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Epic sadface: Password is required";

        loginPage.login("standard_user", "");

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Should show password required error message");
    }

    @Test(description = "Verify login error when both fields are empty")
    @Story("Invalid login - Both fields empty")
    @Severity(SeverityLevel.MINOR)
    public void testLoginWithBothFieldsEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Epic sadface: Username is required";

        loginPage.login("", "");

        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage), "Should show username required error message");
    }

    @Test(description = "Verify user can logout successfully")
    @Story("Logout")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Should be logged in");

        inventoryPage.logout();
        
        // Add URL check to confirm redirection
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html") || driver.getCurrentUrl().equals("https://www.saucedemo.com/"), 
            "URL should be the login page after logout but was: " + driver.getCurrentUrl());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Should be redirected to login page after logout");
    }
}
