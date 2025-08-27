package com.swaglabs.stepDefinitions;


import com.swaglabs.config.BaseTest;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartSteps {
    LoginPage loginPage = new LoginPage(BaseTest.getDriver());
    InventoryPage inventoryPage = new InventoryPage(BaseTest.getDriver());
    CartPage cartPage = new CartPage(BaseTest.getDriver());

    @Given("I am logged in and have added an item to cart")
    public void i_am_logged_in_and_have_added_an_item_to_cart() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals("1", inventoryPage.getCartBadgeCount());
    }

    @When("I go to the cart page")
    public void i_go_to_the_cart_page() {
        inventoryPage.goToCart();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/cart.html"));
    }

    @Then("I should see the added item in cart")
    public void i_should_see_the_added_item_in_cart() {
        Assert.assertEquals(1, cartPage.getCartItemCount());
    }

    @When("I remove the first item from cart")
    public void i_remove_the_first_item_from_cart() {
        cartPage.removeFirstItem();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        Assert.assertEquals(0, cartPage.getCartItemCount());
    }
}