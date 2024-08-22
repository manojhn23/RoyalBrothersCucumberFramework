package com.automation.pages.web;


import com.automation.pages.ui.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebStorePage extends WebBasePage implements StorePage {

    @FindBy(css = ".list-menu.list-menu--inline")
    WebElement menuList;

    String categoryPath = "//ul[@class='list-menu list-menu--inline']//span[text()='%s']";

    @Override
    public boolean isUserOnStorePage() {
        return menuList.isDisplayed();
    }

    @Override
    public void selectProductCategory(String productCategory) {
        WebElement category = driver.findElement(By.xpath(String.format(categoryPath, productCategory)));
        category.click();
    }

}
