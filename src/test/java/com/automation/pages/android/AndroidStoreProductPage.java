package com.automation.pages.android;

import com.automation.pages.ui.StoreProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidStoreProductPage extends AndroidBasePage implements StoreProductPage {

    String productNamePath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@text='ADD TO CART']")
    WebElement addToCartButton;

    @FindBy(xpath = "//android.view.View[@resource-id='cart']/android.widget.TextView[1]")
    WebElement backFromCartButton;

    String navigateProductPagePath = "//android.widget.TextView[@text='%s']";

    @Override
    public void addProductsToTheCart(String product1, String product2) {
        addProduct(product1);
        backFromCartButton.click();
        while (!isDisplayed(navigateProductPagePath, ConfigReader.getConfigValue("product.category").toUpperCase())) {
            System.out.println();
            scrollPageDown();
        }
        WebElement navigateBack = driver.findElement(By.xpath(String.format(navigateProductPagePath, ConfigReader.getConfigValue("product.category").toUpperCase())));
        navigateBack.click();
        addProduct(product2);
    }

    private void addProduct(String product1) {
        while (!isDisplayed(productNamePath, product1)) {
            scrollPage();
        }
        WebElement product = driver.findElement(By.xpath(String.format(productNamePath, product1)));
        product.click();

        while (!isPresent(addToCartButton)) {
            scrollPage();
        }
        addToCartButton.click();
    }
}
