package com.automation.pages.android;

import com.automation.pages.ui.OrderSummaryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidOrderSummaryPage extends AndroidBasePage implements OrderSummaryPage {

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"email\"]")
    WebElement contactDetails;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"checkout-pay-button\"]")
    WebElement checkOutPayButton;

    @FindBy(xpath = "//android.view.View[@text='Total']/../android.view.View[contains(@text,'₹')]")
    WebElement totalPayAmount;

    @Override
    public boolean isUserOnOrderSummaryPage() {
        while (!isPresent(checkOutPayButton)) {
            scrollPage();
        }
        return checkOutPayButton.isDisplayed();
    }

    @Override
    public boolean validateTotalAmount() {
        double payAmount = Double.parseDouble(totalPayAmount.getText().split("₹")[1].replace(",", ""));
        System.out.println(payAmount);
        System.out.println(AndroidStoreCartPage.cartCheckOutPrice);
        return payAmount == AndroidStoreCartPage.cartCheckOutPrice;
    }
}
