package com.automation.pages.web;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(id = "autocomplete-input")
    WebElement searchCityInput;

    String citySelectPath = "//a[contains(@data-city,'%s')]";

    @FindBy(xpath = "//a[contains(@class,'btn-login') and text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@id='one']//span[@data-current_city]")
    WebElement citySelected;

    @FindBy(xpath = "//li[@data-target='dropdown-user']/a[2]")
    WebElement userLoginName;

    @FindBy(id = "wzrk-cancel")
    WebElement notificationNotNow;

    @FindBy(id = "one")
    WebElement locationOption;

    @FindBy(xpath = "//i[contains(@class,'clear-all-btn')]")
    WebElement clearBtn;

    @FindBy(xpath = "//input[@id='pickup-date-desk']")
    WebElement pickupDateInput;

    @FindBy(id = "pickup-time-desk")
    WebElement pickupTimeInput;

    @FindBy(id = "dropoff-date-desk")
    WebElement dropOffDateInput;

    @FindBy(id = "dropoff-time-desk")
    WebElement dropOffTimeInput;

    String pickupDateXpath = "//table[@id='pickup-date-desk_table']//div[contains(@aria-label,'%s')]";
    String pickupTimeXpath = "//div[@id='pickup-time-desk_root']//li[contains(@aria-label,'%s')]";

    String dropOffDateXpath = "//table[@id='dropoff-date-desk_table']//div[contains(@aria-label,'%s')]";
    String dropOffTimeXpath = "//div[@id='dropoff-time-desk_root']//li[contains(@aria-label,'%s')]";

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    WebElement searchBtn;

    @FindBy(id = "svg-menu-container")
    WebElement hamburgerMenu;

    @FindBy(xpath = "//li[@data-target='dropdown-user']")
    WebElement userMenu;

    String menuOptionPath = "//ul[@id='slide-out']/li/a[contains(text(),'%s')]";

    @FindBy(xpath = "//li[@class='logout-button']")
    WebElement logoutButton;

    @FindBy(xpath = "//div[@class='modal-content']")
    WebElement citySelectionTab;

    @FindBy(xpath = "//table[@id='pickup-date-desk_table']/..//div[@title='Next month']")
    WebElement pickupNextMonthBtn;

    @FindBy(xpath = "//table[@id='dropoff-date-desk_table']/..//div[@title='Next month']")
    WebElement dropOffNextMonthBtn;

    @Override
    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("base.url"));
    }

    @Override
    public void selectCity(String cityName) {
        pause(3);
        searchCityInput.sendKeys(cityName);
        ConfigReader.setConfigValue("search.location", cityName);
    }

    @Override
    public boolean isUserOnHomePage() {
        return loginButton.isDisplayed();
    }

    @Override
    public boolean verifyCitySelected() {
        return citySelected.getText().equals(ConfigReader.getConfigValue("city.name"));
    }

    @Override
    public void clickOnLoginButton() {
        click(loginButton);
    }

    @Override
    public boolean isLoginSuccessFul() {
        return userLoginName.getText().equals(ConfigReader.getConfigValue("user.name"));
    }

    @Override
    public void clicksOnLocationOption() {
        click(locationOption);
    }

    @Override
    public void entersLocationName(String locationName) {
        searchCityInput.sendKeys(locationName);
        ConfigReader.setConfigValue("search.location", locationName);
    }

    @Override
    public void clicksOnEnteredLocation() {
        WebElement cityEle = driver.findElement(By.xpath(String.format(citySelectPath, ConfigReader.getConfigValue("search.location"))));
        click(cityEle);
        if (isDisplayed(notificationNotNow)) {
            click(notificationNotNow);
        }
    }

    @Override
    public boolean isSelectedLocationDisplayed() {
        return citySelected.getText().equals(ConfigReader.getConfigValue("search.location"));
    }

    @Override
    public boolean isSelectedLocationNotDisplayed() {
        return isDisplayed(citySelectPath, ConfigReader.getConfigValue("search.location"));
    }

    @Override
    public void clicksClearOnLocationSearch() {
        click(clearBtn);
    }

    @Override
    public boolean isInputFieldNull() {
        return searchCityInput.getAttribute("value").isEmpty();
    }

    @Override
    public void entersDetailsForRide(String pickupDate, String pickupTime, String dropOffDate, String dropOffTime) {
        moveToElement(searchBtn);
        pickupDate = ConfigReader.getConfigValue(pickupDate);
        pickupTime = ConfigReader.getConfigValue(pickupTime);
        dropOffDate = ConfigReader.getConfigValue(dropOffDate);
        dropOffTime = ConfigReader.getConfigValue(dropOffTime);

        if (pickupTime.indexOf("0") == 0) {
            pickupTime = pickupTime.substring(1);
        }
        if (dropOffTime.indexOf("0") == 0) {
            dropOffTime = dropOffTime.substring(1);
        }

        click(pickupDateInput);
        selectDate(pickupNextMonthBtn, pickupDateXpath, pickupDate);

        WebElement pickupTimeEle = driver.findElement(By.xpath(String.format(pickupTimeXpath, pickupTime)));
        waitTillClickable(pickupTimeEle);
        click(pickupTimeEle);

        selectDate(dropOffNextMonthBtn, dropOffDateXpath, dropOffDate);

        WebElement dropOffTimeEle = driver.findElement(By.xpath(String.format(dropOffTimeXpath, dropOffTime)));
        waitTillClickable(dropOffTimeEle);
        click(dropOffTimeEle);

    }

    @Override
    public void clicksOnSearchBtn() {
        click(searchBtn);
    }

    @Override
    public void clickOnHamburgerMenu() {
//
    }

    @Override
    public void selectMenuOption(String menuOption) {
        hamburgerMenu.click();
        WebElement option = driver.findElement(By.xpath(String.format(menuOptionPath, menuOption)));
        click(option);
    }

    @Override
    public void clickOnProfile() {
        pause(2);
        moveToElement(userMenu);
        pause(2);
    }


    @Override
    public void clickOnLogoutOption() {
        logoutButton.click();
    }

    @Override
    public boolean isLogOutSuccessFull() {
        return loginButton.isDisplayed();
    }

    @Override
    public boolean isCitySelectionDisplayed() {
        waitTillVisible(citySelectionTab);
        return citySelectionTab.isDisplayed();
    }

    @Override
    public String getLocationInputText() {
        return searchCityInput.getAttribute("value");
    }

}
