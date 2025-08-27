package com.swaglabs.pages;


import com.swaglabs.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    public void enterUsername(String username) {
//        usernameInput.clear();
//        usernameInput.sendKeys(username);
//    }
//
//    public void enterPassword(String password) {
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//    }

    public void enterCredentials(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.isDisplayed() ? errorMessage.getText() : "";
    }
}
