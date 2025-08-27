package com.swaglabs.pages;


import com.swaglabs.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public void removeFirstItem() {
        cartItems.get(0).findElement(org.openqa.selenium.By.cssSelector(".btn_secondary")).click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }
}
