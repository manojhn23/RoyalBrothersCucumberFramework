package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterCityBikeDetailsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'search-card')]/form")
    WebElement bikeDetailsCard;

    @FindBy(xpath = "//button[text()='Request Booking'][1]")
    WebElement requestBookingBtn;

    @FindBy(xpath = "//form[@id='inter_city_booking_confirm']//button")
    WebElement confirmRequestBtn;

    public boolean isBikeDetailsPageDisplayed() {
        return bikeDetailsCard.isDisplayed();
    }

    public void clicksOnRequestBookingBtn() {
        click(requestBookingBtn);
    }

    public boolean isConfirmRequestBtnDisplayed() {
        return confirmRequestBtn.isDisplayed();
    }
}
