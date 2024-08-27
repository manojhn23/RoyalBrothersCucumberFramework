package com.automation.pages.android;

import com.automation.pages.ui.StoreProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class AndroidStoreProductPage extends AndroidBasePage implements StoreProductPage {

    String productNamePath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@text='ADD TO CART']")
    WebElement addToCartButton;

    @FindBy(xpath = "//android.view.View[@resource-id='cart']/android.widget.TextView[1]")
    WebElement backFromCartButton;

    String navigateProductPagePath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.view.View[@text='FILTER AND SORT']")
    WebElement filterAndSortButton;

    @FindBy(xpath = "(//android.view.View[@text=\"Sort by\"])[2]")
    WebElement sortByDropDown;

    String sortByXpath = "//android.widget.CheckedTextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@text='APPLY']")
    WebElement applyButton;

    @FindBy(xpath = "//android.view.View[@text='Regular price']/../android.view.View[2]/android.widget.TextView[2]")
    List<WebElement> listOfPrices;

    @FindBy(xpath = "//android.widget.ListView[@resource-id='product-grid']/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView")
    List<WebElement> listOfNames;

    @FindBy(xpath = "//android.widget.TextView[@text='Next ›']")
    WebElement nextButton;

    @FindBy(xpath = "//android.widget.TextView[@text='‹ Prev']")
    WebElement previousOption;

    @FindBy(xpath = "//android.view.View[@text='FOLLOW US']")
    WebElement followUsOption;

    String pricePath = "//android.widget.TextView[@text='%s']/../../android.widget.ListView/android.view.View[2]/android.widget.TextView[2]";

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
        List<Double> appSortedList = listOfStoreProductPrices();
        List<Double> expectedList = new ArrayList<>(appSortedList);
        Collections.sort(expectedList);
        System.out.println(appSortedList);
        System.out.println(appSortedList.size());
        return appSortedList.equals(expectedList);
    }

    @Override
    public boolean isProductSortedFromPriceHighToLow() {
        List<Double> appSortedList = listOfStoreProductPrices();
        List<Double> expectedList = new ArrayList<>(appSortedList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        return appSortedList.equals(expectedList);
    }

    @Override
    public boolean isProductSortedFromAtoZ() {
        List<String> appAlphabeticalList = listOfStoreProductAlphabetically();
        List<String> expectedList = new ArrayList<>(appAlphabeticalList);
        Collections.sort(expectedList);
        System.out.println(appAlphabeticalList);
        System.out.println(appAlphabeticalList.size());
        return true;
    }

    @Override
    public boolean isProductSortedFromZtoA() {
        List<String> appAlphabeticalList = listOfStoreProductAlphabetically();
        List<String> expectedList = new ArrayList<>(appAlphabeticalList);
        Collections.sort(expectedList);
        Collections.reverse(expectedList);
        System.out.println(appAlphabeticalList);
        System.out.println(expectedList);
        return appAlphabeticalList.equals(expectedList);
    }


    public List<Double> listOfStoreProductPrices() {
        Map<String, Double> mp = new LinkedHashMap<>();
        while (!(isPresent(nextButton) && isPresent(followUsOption))) {
            for (int i = 0; i < listOfPrices.size() && i < listOfNames.size(); i++) {
                String name = listOfNames.get(i).getText();
                if (isDisplayed(pricePath, name)) {
                    Double price = Double.parseDouble(driver.findElement(By.xpath(String.format(pricePath, name))).getText());
                    mp.put(name, price);
                }
                System.out.println(mp);
            }
            scrollPage();
        }
        nextButton.click();
        while (!(isPresent(previousOption) && isPresent(followUsOption))) {
            for (int i = 0; i < listOfPrices.size() && i < listOfNames.size(); i++) {
                mp.put(listOfNames.get(i).getText(), Double.parseDouble(listOfPrices.get(i).getText()));
                System.out.println(mp);
            }
            scrollPage();
        }
        return mp.values()
                .stream()
                .toList();
    }

    public List<String> listOfStoreProductAlphabetically() {
        Set<String> products = new LinkedHashSet<>();
        while (!(isPresent(nextButton) && isPresent(followUsOption))) {
            for (WebElement listOfName : listOfNames) {
                products.add(listOfName.getText());
                System.out.println(products);
            }
            scrollPage();
        }
        nextButton.click();
        while (!(isPresent(previousOption) && isPresent(followUsOption))) {
            for (WebElement listOfName : listOfNames) {
                products.add(listOfName.getText());
                System.out.println(products);
            }
            scrollPage();
        }
        products.remove("CHOOSE OPTIONS");
        return products.stream().toList();
    }


}
