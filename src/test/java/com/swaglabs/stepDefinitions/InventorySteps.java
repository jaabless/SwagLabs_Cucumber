package com.swaglabs.stepDefinitions;


import com.swaglabs.config.BaseTest;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class InventorySteps {
    LoginPage loginPage = new LoginPage(BaseTest.getDriver());
    InventoryPage inventoryPage = new InventoryPage(BaseTest.getDriver());

//    @Given("I am logged in as standard user")
//    public void i_am_logged_in_as_standard_user() {
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("secret_sauce");
//        loginPage.clickLogin();
//        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/inventory.html"));
//    }

    @Given("I am logged in as username {string} and password {string}")
    public void i_am_logged_in_as(String username, String password) {
        loginPage.enterCredentials(username, password);
        loginPage.clickLogin();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/inventory.html"));
    }

    @Then("I should see the products list")
    public void i_should_see_the_products_list() {
        Assert.assertTrue(inventoryPage.getProductCount() > 0);
    }

    @When("I add the first item to cart")
    public void i_add_the_first_item_to_cart() {
        inventoryPage.addFirstItemToCart();
    }

    @Then("the cart badge should show {string}")
    public void the_cart_badge_should_show(String count) {
        Assert.assertEquals(count, inventoryPage.getCartBadgeCount());
    }
}
