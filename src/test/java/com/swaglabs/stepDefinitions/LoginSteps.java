package com.swaglabs.stepDefinitions;


import com.swaglabs.config.BaseTest;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(BaseTest.getDriver());
    InventoryPage inventoryPage = new InventoryPage(BaseTest.getDriver());

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Page is already loaded via Hooks
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("saucedemo.com"));
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click login button")
    public void i_click_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should see {string}")
    public void i_should_see(String expected) {
        if (expected.equals("inventory page")) {
            Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("/inventory.html"));
            Assert.assertTrue(inventoryPage.getProductCount() > 0);
        } else if (expected.equals("error message")) {
            Assert.assertTrue(loginPage.getErrorMessage().contains("do not match"));
        } else if (expected.equals("locked out error")) {
            Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
        }
    }
}
