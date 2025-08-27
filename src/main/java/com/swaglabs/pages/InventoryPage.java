package com.swaglabs.pages;

import com.swaglabs.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public int getProductCount() {
        return inventoryItems.size();
    }

    public void addFirstItemToCart() {
        inventoryItems.get(0).findElement(org.openqa.selenium.By.cssSelector(".btn_inventory")).click();
    }

    public String getCartBadgeCount() {
        return cartBadge.isDisplayed() ? cartBadge.getText() : "0";
    }

    public void goToCart() {
        cartLink.click();
    }
}
