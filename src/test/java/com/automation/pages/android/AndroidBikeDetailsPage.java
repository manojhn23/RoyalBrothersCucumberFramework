package com.automation.pages.android;

import com.automation.pages.ui.BikeDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidBikeDetailsPage extends AndroidBasePage implements BikeDetailsPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Search by Model']")
    WebElement searchByModel;

    @FindBy(xpath = "//android.widget.TextView[@text='BOOK NOW']")
    WebElement bookNowButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Select Pickup Location']")
    WebElement pickUpLocation;

    @FindBy(xpath = "//android.widget.TextView[@text='AVAILABLE']/../android.view.ViewGroup")
    List<WebElement> availableFirstPickUpLocations;

    @Override
    public boolean isBikeDetailsPageDisplayed() {
        return searchByModel.isDisplayed();
    }

    @Override
    public void clicksBookBtnOfFirstBike() {
        while (!isPresent(bookNowButton)) {
            scrollPage();
        }
        pickUpLocation.click();
        availableFirstPickUpLocations.get(0).click();
        bookNowButton.click();
    }
}
