package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage {

    @FindBy(css = ".list-menu.list-menu--inline")
    WebElement menuList;

    String categoryPath = "//ul[@class='list-menu list-menu--inline']//span[text()='%s']";

    public boolean isUserOnStorePage() {
        return menuList.isDisplayed();
    }

    public void selectProductCategory(String productCategory) {
        WebElement category = driver.findElement(By.xpath(String.format(categoryPath, productCategory)));
        category.click();
    }

}
