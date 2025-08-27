package com.swaglabs.stepDefinitions;

import com.swaglabs.config.BaseTest;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {
    LoginPage loginPage = new LoginPage(BaseTest.getDriver());
    InventoryPage inventoryPage = new InventoryPage(BaseTest.getDriver());
    CartPage cartPage = new CartPage(BaseTest.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(BaseTest.getDriver());

    @Given("The user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password){
        loginPage.enterCredentials(username, password);
        loginPage.clickLogin();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/inventory.html"));
    }

    @And("User adds item to cart")
    public void user_adds_item_to_cart(){
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals("1", inventoryPage.getCartBadgeCount());
    }

    @When("The user proceeds to checkout")
    public void i_proceed_to_checkout_from_the_cart() {
        inventoryPage.goToCart();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/cart.html"));
        cartPage.clickCheckout();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/checkout-step-one.html"));
    }

    @When("The user enters checkout information {string}, {string}, {string}")
    public void user_enter_checkout_details(String firstName, String lastName, String postalCode) {
        checkoutPage.enterCheckoutDetails(firstName, lastName, postalCode);
        checkoutPage.clickContinue();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/checkout-step-two.html"));
    }

    @When("The user finish the checkout process")
    public void i_finish_the_checkout_process() {
        checkoutPage.clickFinish();
    }

    @Then("The user should see the confirmation message")
    public void i_should_see_the_checkout_complete_message() {
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/checkout-complete.html"));
        Assert.assertEquals("Thank you for your order!", checkoutPage.getCompletionMessage());
    }
}