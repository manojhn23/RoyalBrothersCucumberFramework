package com.automation.pages.android;

import com.automation.pages.ui.StoreProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AndroidStoreProductPage extends AndroidBasePage implements StoreProductPage {

    String productNamePath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@text='ADD TO CART']")
    WebElement addToCartButton;

    @FindBy(xpath = "//android.view.View[@resource-id='cart']/android.widget.TextView[1]")
    WebElement backFromCartButton;

    String navigateProductPagePath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.view.View[@text=\"FILTER AND SORT\"]")
    WebElement filterAndSortButton;

    @FindBy(xpath = "//android.view.View[contains(@resource-id,\"SortBy\")]")
    WebElement sortByDropDown;

    String sortByXpath = "//android.widget.CheckedTextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@text=\"APPLY\"]")
    WebElement applyButton;

    @FindBy(xpath = "//android.view.View[@text=\"Regular price\"]/../android.view.View[2]/android.widget.TextView[2]")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Next ›\"]")
    WebElement nextButton;

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

    @Override
    public void sortProductBy(String option) {
        filterAndSortButton.click();
        sortByDropDown.click();

        WebElement sortByOption = driver.findElement(By.xpath(String.format(sortByXpath, option)));
        sortByOption.click();

        applyButton.click();
    }

    @Override
    public boolean isProductSortedFromPriceLowToHigh() {
        List<Double> before = new ArrayList<>();
        while (!isPresent(nextButton)) {
            for (WebElement element : listOfPrices) {
                before.add(Double.parseDouble(element.getText()));
            }
            System.out.println(before);
            scrollPage();
        }
        System.out.println(before);
        nextButton.click();
        return true;
    }


}
