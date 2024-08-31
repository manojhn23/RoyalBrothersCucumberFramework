package com.automation.pages.android;

import com.automation.pages.ui.StoreCartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidStoreCartPage extends AndroidBasePage implements StoreCartPage {

    @FindBy(xpath = "//android.view.View[@resource-id='main-cart-items']/android.widget.ListView/android.view.View//android.view.View[@content-desc][2]")
    List<WebElement> listOfProductsAddedToCart;

    String removeProductPath = "//android.view.View[@resource-id='main-cart-items']//android.view.View[@content-desc='%s']/..//android.view.View[contains(@resource-id,'Remove')]";

    @FindBy(xpath = "//android.widget.Button[contains(@text,\"CHECK OUT\")]")
    WebElement checkOutButton;

    static double cartCheckOutPrice;

    @Override
    public boolean isProductAddedSuccessFully() {
        String cartFirstProduct = listOfProductsAddedToCart.get(0).getAttribute("content-desc");
        String cartSecondProduct = listOfProductsAddedToCart.get(1).getAttribute("content-desc");
        System.out.println(cartFirstProduct + " " + cartSecondProduct);
        return listOfProductsAddedToCart.size() == 2
                && cartFirstProduct.equals(ConfigReader.getConfigValue("product2.name"))
                && cartSecondProduct.equals(ConfigReader.getConfigValue("product1.name"))
                ;
    }

    @Override
    public void removeProductFromCart(String productName) {
        WebElement removeProduct = driver.findElement(By.xpath(String.format(removeProductPath, productName)));
        removeProduct.click();
    }

    @Override
    public boolean isProductRemovedSuccessFully() {
        pause(2);
        int productSize = listOfProductsAddedToCart.size();
        System.out.println(productSize);
        return productSize == 1;
    }

    @Override
    public void clickOnCheckOutButton() {
        cartCheckOutPrice = Double.parseDouble(checkOutButton.getText().split("RS. ")[1].replace(",", ""));
        System.out.println(cartCheckOutPrice);
        checkOutButton.click();
    }
}
