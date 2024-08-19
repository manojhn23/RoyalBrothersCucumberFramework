package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StoreCartPage extends BasePage {

    @FindBy(xpath = "//details[@class='cart-drawer-container']//span[@class='cart-count-bubble']/span")
    WebElement cartCount;

    @FindBy(css = "#cart-icon-bubble>svg")
    WebElement cartIcon;

    @FindBy(xpath = "//a[@class='link product-title']")
    List<WebElement> cartProductTitles;

    String removeProductPath = "//a[contains(@aria-label,'%s')]";

    String categoryPath = "//ul[@class='list-menu list-menu--inline']//span[text()='%s']";

    public boolean isProductAddedSuccessFully() {
        driver.navigate().back();
        WebElement category = driver.findElement(By.xpath(String.format(categoryPath, ConfigReader.getConfigValue("product.category"))));
        category.click();
        cartIcon.click();
        return cartProductTitles.size() == 2 &&
                cartProductTitles.get(1).getText().equals(ConfigReader.getConfigValue("product1.name")) &&
                cartProductTitles.get(0).getText().equals(ConfigReader.getConfigValue("product2.name"));
    }

    public void removeProductFromCart(String productName) {
        WebElement removeProduct = driver.findElement(By.xpath(String.format(removeProductPath, productName)));
        removeProduct.click();
    }

    public boolean isProductRemovedSuccessFully() {
        pause(3);
        return cartProductTitles.size() == 1;
    }
}
