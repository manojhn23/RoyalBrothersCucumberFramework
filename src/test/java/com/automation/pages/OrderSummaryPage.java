package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends BasePage {

    @FindBy(xpath = "//button[@id='checkout-pay-button']")
    WebElement payNowButton;

    @FindBy(xpath = "//div[@aria-labelledby='MoneyLine-Heading0']/div[1]/div[2]/span")
    WebElement subTotal;

    @FindBy(xpath = "//div[@aria-labelledby='MoneyLine-Heading0']/div[2]/div[2]/span")
    WebElement shippingPrice;

    @FindBy(xpath = "//div[@aria-labelledby='MoneyLine-Heading0']/div[3]/div[2]//strong")
    WebElement totalPrice;

    public boolean isUserOnOrderSummaryPage() {
        return payNowButton.isDisplayed();
    }

    public boolean validateTotalAmount() {
        double totalAmount = Double.parseDouble(totalPrice.getText().split("₹")[1].replace(",", ""));
        System.out.println(totalAmount);
        System.out.println("--" + StoreCartPage.cartPageTotalAmount);
        return StoreCartPage.cartPageTotalAmount == totalAmount;
    }
}
