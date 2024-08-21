package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BikeCheckoutPage extends BasePage {

    @FindBy(xpath = "//h5[text()='CHECKOUT']")
    WebElement checkoutHeader;

    @FindBy(xpath = "//a[contains(@class,'make_payment_button') and contains(@class,'right')]")
    WebElement makePaymentBtn;

    public boolean isMakePaymentOptionDisplayed() {
        return checkoutHeader.isDisplayed();
    }

    public boolean isBikeCheckoutPageDisplayed() {
        return makePaymentBtn.isDisplayed();
    }
}
