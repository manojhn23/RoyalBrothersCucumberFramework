package com.automation.pages.web;

import com.automation.pages.ui.BikeCheckoutPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebBikeCheckoutPage extends WebBasePage implements BikeCheckoutPage {

    @FindBy(xpath = "//h5[text()='CHECKOUT']")
    WebElement checkoutHeader;

    @FindBy(xpath = "//a[contains(@class,'make_payment_button') and contains(@class,'right')]")
    WebElement makePaymentBtn;

    @Override
    public boolean isMakePaymentOptionDisplayed() {
        return checkoutHeader.isDisplayed();
    }

    @Override
    public boolean isBikeCheckoutPageDisplayed() {
        return makePaymentBtn.isDisplayed();
    }
}
