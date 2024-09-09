package com.automation.pages.web;

import com.automation.pages.ui.StoreProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebStoreProductPage extends WebBasePage implements StoreProductPage {

    String productsByNamePath = "//ul[@id='product-grid']/li//span[text()='%s']";

    @FindBy(xpath = "//div[@class='product-form__buttons']/button[text()='Add to cart']")
    WebElement addToCartProductPage;

    @FindBy(xpath = "//div[@class='mini-cart__header']/drawer-close-button")
    WebElement drawerCloseButton;

    @FindBy(xpath = "//div[@class='sorting']")
    WebElement sortByButton;

    String sortByOptionPath = "//span[text()='%s']/..";

    String priceListPath = "//div[@id='ProductGridContainer']//div[@class='price']//div[@class='price__regular']//bdi";

    String nameListPath = "//div[@id='ProductGridContainer']//a[@class='card-information__text h4']";

    @FindBy(xpath = "//a[@aria-label='Next ›']")
    WebElement nextButton;

    @FindBy(xpath = "//a[@aria-label='‹ Prev']")
    WebElement prevButton;

    @FindBy(xpath = "//ul[@class='pagination__list list-unstyled']/li")
    List<WebElement> noOfPages;

    List<Double> priceListBeforeSort;

    List<Double> priceListAfterSort;

    List<String> alphabeticListBeforeSort;

    List<String> alphabeticListAfterSort;

    @Override
    public void addProductsToTheCart(String product1, String product2) {
        WebElement add1 = driver.findElement(By.xpath(String.format(productsByNamePath, product1)));
        addToCart(add1);
        driver.navigate().back();
        WebElement add2 = driver.findElement(By.xpath(String.format(productsByNamePath, product2)));
        addToCart(add2);
    }

    private void addToCart(WebElement element) {
        click(element);
        click(addToCartProductPage);
    }

    @Override
    public void sortProductBy(String sortByOption) {
        if (sortByOption.contains("Price")) {
            priceListBeforeSort = getListOfPrices();
        }
        if (sortByOption.contains("Alphabetically")) {
            alphabeticListBeforeSort = getListOfProductNames();
        }
//        click(prevButton);
        sortByButton.click();
        pause(2);
        WebElement sortBy = driver.findElement(By.xpath(String.format(sortByOptionPath, sortByOption)));
        sortBy.click();
        pause(3);
    }


    private List<Double> getListOfPrices() {
        int count = noOfPages.size() - 1;
        List<Double> li = new ArrayList<>();
        List<WebElement> list;
        while (count > 0) {
            list = driver.findElements(By.xpath(priceListPath));
            for (WebElement element : list) {
                li.add(Double.parseDouble(element.getText().split("\\.")[1]));
            }
            if (isDisplayed(nextButton)) {
                click(nextButton);
            }
            count--;
        }
        return li;
    }

    private List<String> getListOfProductNames() {
        int count = noOfPages.size() - 1;
        List<String> li = new ArrayList<>();
        List<WebElement> list;
        while (count > 0) {
            list = driver.findElements(By.xpath(nameListPath));
            for (WebElement element : list) {
                li.add(element.getText());
            }
            if (isDisplayed(nextButton)) {
                click(nextButton);
            }
            count--;
        }
        return li;
    }

    @Override
    public boolean isProductSortedFromPriceLowToHigh() {
        priceListAfterSort = getListOfPrices();
        Collections.sort(priceListBeforeSort);
        System.out.println(priceListBeforeSort);
        System.out.println(priceListAfterSort);
        return priceListBeforeSort.equals(priceListAfterSort);
    }

    @Override
    public boolean isProductSortedFromPriceHighToLow() {
        priceListAfterSort = getListOfPrices();
        priceListBeforeSort.sort(Collections.reverseOrder());
        System.out.println(priceListBeforeSort);
        System.out.println(priceListAfterSort);
        return priceListBeforeSort.equals(priceListAfterSort);
    }

    @Override
    public boolean isProductSortedFromAtoZ() {
        alphabeticListAfterSort = getListOfProductNames();
        Collections.sort(alphabeticListBeforeSort);
        System.out.println(alphabeticListBeforeSort);
        System.out.println(alphabeticListAfterSort);
        return alphabeticListBeforeSort.equals(alphabeticListAfterSort);
    }

    @Override
    public boolean isProductSortedFromZtoA() {
        alphabeticListAfterSort = getListOfProductNames();
        alphabeticListBeforeSort.sort(Collections.reverseOrder());
        System.out.println(alphabeticListBeforeSort);
        System.out.println(alphabeticListAfterSort);
        return alphabeticListBeforeSort.equals(alphabeticListAfterSort);
    }
}
