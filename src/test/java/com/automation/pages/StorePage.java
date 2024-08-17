package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StorePage extends BasePage {

    @FindBy(css = ".list-menu.list-menu--inline")
    WebElement menuList;

    String categoryPath = "//ul[@class='list-menu list-menu--inline']//span[text()='%s']";

    String productsByNamePath = "//ul[@id='product-grid']/li//span[text()='%s']";

    @FindBy(xpath = "//div[@class='product-form__buttons']/button[text()='Add to cart']")
    WebElement addToCartProductPage;

    @FindBy(xpath = "//div[@class='mini-cart__header']/drawer-close-button")
    WebElement drawerCloseButton;

    @FindBy(xpath = "//details[@class='cart-drawer-container']//span[@class='cart-count-bubble']/span")
    WebElement cartCount;

    @FindBy(css = "#cart-icon-bubble>svg")
    WebElement cartIcon;

    @FindBy(xpath = "//a[@class='link product-title']")
    List<WebElement> cartProductTitles;

    public boolean isUserOnStorePage() {
        return menuList.isDisplayed();
    }

    public void selectProductCategory(String productCategory) {
        WebElement category = driver.findElement(By.xpath(String.format(categoryPath, productCategory)));
        category.click();
    }

    public void addProductsToTheCart(String product1, String product2) {
        WebElement add1 = driver.findElement(By.xpath(String.format(productsByNamePath, product1)));
        addToCart(add1);
        driver.navigate().back();
        WebElement add2 = driver.findElement(By.xpath(String.format(productsByNamePath, product2)));
        addToCart(add2);
    }

    public void addToCart(WebElement element) {
        click(element);
        click(addToCartProductPage);
        click(drawerCloseButton);
    }

    public boolean isProductAddedSuccessFully() {
        driver.navigate().back();
        WebElement category = driver.findElement(By.xpath(String.format(categoryPath, ConfigReader.getConfigValue("product.category"))));
        category.click();
        cartIcon.click();
        return cartProductTitles.size() == 2 &&
                cartProductTitles.get(1).getText().equals(ConfigReader.getConfigValue("product1.name")) &&
                cartProductTitles.get(0).getText().equals(ConfigReader.getConfigValue("product2.name"));
    }
}
