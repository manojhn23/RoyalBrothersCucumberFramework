package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePageAndroid extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    WebElement mayBeLaterOption;

    @FindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    WebElement loginSkipButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Select city to book your ride']")
    WebElement cityInputField;

    String cityPath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.TextView[@text='SEARCH']")
    WebElement searchButton;

    String selectLocationPath = "(//android.widget.TextView[@text])[1]";

    @FindBy(xpath = "//android.widget.TextView[@text='Oops! City not found...']")
    WebElement notFoundMessage;

    public void openApplication() {
        mayBeLaterOption.click();
        loginSkipButton.click();
    }

    public void selectCity(String cityName) {
        cityInputField.sendKeys(cityName);
        ConfigReader.setConfigValue("search.location", cityName);
    }

    public void entersLocationName(String locationName) {
        cityInputField.sendKeys(locationName);
        ConfigReader.setConfigValue("search.location", locationName);
    }

    public boolean isUserOnHomePage() {
        return searchButton.isDisplayed();
    }

    public boolean isSelectedLocationDisplayed() {
        WebElement locationText = driver.findElement(By.xpath(selectLocationPath));
        String selectedLocation = locationText.getText();
        return selectedLocation.equals(ConfigReader.getConfigValue("search.location").toUpperCase());
    }

    public void clicksOnLocationOption() {
        WebElement location = driver.findElement(By.xpath(selectLocationPath));
        location.click();
    }

    public boolean isSelectedLocationNotDisplayed() {
        return notFoundMessage.isDisplayed();
    }

    public void clicksOnEnteredLocation() {
        WebElement select = driver.findElement(By.xpath(String.format(cityPath, ConfigReader.getConfigValue("search.location").toUpperCase())));
        select.click();
    }
}
