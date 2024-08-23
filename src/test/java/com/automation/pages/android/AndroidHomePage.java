package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    String monthOptionPath = "//android.widget.TextView[@text='%s ']";

    String optionPath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
    WebElement nextMonthArrow;

    @FindBy(xpath = "//android.widget.ScrollView")
    WebElement timeSelectContainer;

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

        while (!(isDisplayed(monthOptionPath, pickDate.split(" ")[1]) && isDisplayed(optionPath, pickDate.split(" ")[2]))) {
            nextMonthArrow.click();
        }
        WebElement selectDate = driver.findElement(By.xpath(String.format(optionPath, pickDate.split(" ")[0])));
        selectDate.click();

        while (!isDisplayed(optionPath, pickTime)) {
            scroll(timeSelectContainer);
        }
        WebElement timeSet = driver.findElement(By.xpath(String.format(optionPath, pickTime)));
        timeSet.click();

        while (!isDisplayed(monthOptionPath, dropDate.split(" ")[1])) {
            nextMonthArrow.click();
        }
        WebElement selectDropDate = driver.findElement(By.xpath(String.format(optionPath, dropDate.split(" ")[0])));
        selectDropDate.click();

        while (!isDisplayed(optionPath, dropTime)) {
            scroll(timeSelectContainer);
        }
        WebElement dropTimeSet = driver.findElement(By.xpath(String.format(optionPath, dropTime)));
        dropTimeSet.click();

    }

    @Override
    public void clicksOnSearchBtn() {
        searchButton.click();
    }

}
