package com.automation.pages.android;

import com.automation.pages.ui.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidStorePage extends AndroidBasePage implements StorePage {

    @FindBy(xpath = "//android.view.View[@text='Cart']")
    WebElement cartIcon;

    @FindBy(xpath = "//android.view.View[@text=\"Menu\"]")
    WebElement hamburgerMenu;

    String productCategoryPath="//android.view.View[@text='%s']";

    @Override
    public boolean isUserOnStorePage() {
        return cartIcon.isDisplayed();
    }

    @Override
    public void selectProductCategory(String product) {
        hamburgerMenu.click();
        WebElement category=driver.findElement(By.xpath(String.format(productCategoryPath,product)));
        category.click();
        category.click();
    }
}
