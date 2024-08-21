package com.automation.pages.web;

import com.automation.pages.ui.InterCityBikeDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebInterCityBikeDetailsPage extends WebBasePage implements InterCityBikeDetailsPage {

    @FindBy(xpath = "//div[contains(@class,'search-card')]/form")
    WebElement bikeDetailsCard;

    @FindBy(xpath = "//button[text()='Request Booking'][1]")
    WebElement requestBookingBtn;

    @FindBy(xpath = "//form[@id='inter_city_booking_confirm']//button")
    WebElement confirmRequestBtn;

    @Override
    public boolean isBikeDetailsPageDisplayed() {
        return bikeDetailsCard.isDisplayed();
    }

    @Override
    public void clicksOnRequestBookingBtn() {
        click(requestBookingBtn);
    }

    @Override
    public boolean isConfirmRequestBtnDisplayed() {
        return confirmRequestBtn.isDisplayed();
    }
}
