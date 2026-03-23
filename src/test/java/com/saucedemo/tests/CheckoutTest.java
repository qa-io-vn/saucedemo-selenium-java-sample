package com.saucedemo.tests;

import com.saucedemo.pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Checkout")
@Feature("Checkout Flow")
public class CheckoutTest extends BaseTest {

    @Test(description = "Verify successful checkout flow")
    @Story("Checkout process")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        // 1. Login
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isTitleDisplayed(), "Inventory page title should be displayed");

        // 2. Add item to cart
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Should be on cart page");

        // 3. Verify item in cart and checkout
        Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack", "Item name in cart should be correct");
        cartPage.checkout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Should be on checkout step one page");

        // 4. Fill information
        checkoutStepOnePage.fillInformation("John", "Doe", "12345");
        checkoutStepOnePage.clickContinue();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"), "Should be on checkout step two page");

        // 5. Verify overview and finish
        Assert.assertEquals(checkoutStepTwoPage.getCartItemName(), "Sauce Labs Backpack", "Item name in overview should be correct");
        checkoutStepTwoPage.clickFinish();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete.html"), "Should be on checkout complete page");

        // 6. Verify complete
        Assert.assertTrue(checkoutCompletePage.isCompleteHeaderDisplayed(), "Complete header should be displayed");
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(), "Thank you for your order!", "Complete header text should be correct");
    }
}
