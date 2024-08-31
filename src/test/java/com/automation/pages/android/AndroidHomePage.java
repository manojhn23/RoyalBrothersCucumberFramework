package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

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

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/ok']")
    WebElement fullScreenOption;

    @FindBy(xpath = "//android.widget.EditText[@text]/../android.view.ViewGroup/android.view.ViewGroup")
    WebElement clearOption;

    @FindBy(xpath = "//android.widget.TextView[@text='Pickup']/../..//android.widget.TextView[@text=' Date ']")
    WebElement pickUpDate;

    String monthOptionPath = "//android.widget.TextView[contains(@text,'%s')]";

    String optionPath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
    WebElement nextMonthArrow;

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement timeSelectContainer;

    @FindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.ImageView")
    List<WebElement> listOfMenuOptions;

    @Override
    public void openApplication() {
        mayBeLaterOption.click();
        if (isPresent(fullScreenOption)) {
            fullScreenOption.click();
        }
        loginSkipButton.click();
    }

    @Override
    public void selectCity(String cityName) {
        cityInputField.sendKeys(cityName);
        ConfigReader.setConfigValue("search.location", cityName);
    }

    @Override
    public void entersLocationName(String locationName) {
        cityInputField.sendKeys(locationName);
        ConfigReader.setConfigValue("search.location", locationName);
    }

    @Override
    public boolean isUserOnHomePage() {
        return searchButton.isDisplayed();
    }

    @Override
    public boolean isSelectedLocationDisplayed() {
        WebElement locationText = driver.findElement(By.xpath(selectLocationPath));
        String selectedLocation = locationText.getText();
        return selectedLocation.equals(ConfigReader.getConfigValue("search.location"));
    }

    @Override
    public void clicksOnLocationOption() {
        WebElement location = driver.findElement(By.xpath(selectLocationPath));
        location.click();
    }

    @Override
    public boolean isSelectedLocationNotDisplayed() {
        return !notFoundMessage.isDisplayed();
    }

    @Override
    public void clicksOnEnteredLocation() {
        WebElement select = driver.findElement(By.xpath(String.format(cityPath, ConfigReader.getConfigValue("search.location").toUpperCase())));
        select.click();
    }

    @Override
    public void clicksClearOnLocationSearch() {
        clearOption.click();
    }

    @Override
    public boolean isInputFieldNull() {
        return cityInputField.getAttribute("text").equals("Select city to book your ride");
    }

    @Override
    public void entersDetailsForRide(String pickDate, String pickTime, String dropDate, String dropTime) {
        pickUpDate.click();

        pickDate = ConfigReader.getConfigValue(pickDate).replace(",", "");
        pickTime = ConfigReader.getConfigValue(pickTime);
        dropDate = ConfigReader.getConfigValue(dropDate).replace(",", "");
        dropTime = ConfigReader.getConfigValue(dropTime);

        selectDateAndTime(pickDate, pickTime);
        selectDateAndTime(dropDate, dropTime);

    }

    @Override
    public void clicksOnSearchBtn() {
        searchButton.click();
    }

    @Override
    public void selectMenuOption(String menuOption) {
        if (menuOption.equals("Store by RB")) {
            listOfMenuOptions.get(1).click();
        }
    }

    private void selectDateAndTime(String date, String time) {
        while (!(isDisplayed(monthOptionPath, date.split(" ")[1]) && isDisplayed(optionPath, date.split(" ")[2]))) {
            nextMonthArrow.click();
        }
        WebElement selectDate = driver.findElement(By.xpath(String.format(optionPath, date.split(" ")[0])));
        selectDate.click();

        while (!isDisplayed(optionPath, time)) {
            scroll(timeSelectContainer);
        }
        WebElement timeSet = driver.findElement(By.xpath(String.format(optionPath, time)));
        timeSet.click();
    }

}
