package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

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

    String pickupDateXpath = "//table[@id='pickup-date-desk_table']//div[@aria-label='%s']";
    String pickupTimeXpath = "//div[@id='pickup-time-desk_root']//li[@aria-label='%s']";

    String dropOffDateXpath = "//table[@id='dropoff-date-desk_table']//div[@aria-label='%s']";
    String dropOffTimeXpath = "//div[@id='dropoff-time-desk_root']//li[@aria-label='%s']";

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    WebElement searchBtn;

    @FindBy(id = "svg-menu-container")
    WebElement hamburgerMenu;

    @FindBy(xpath = "//li[@data-target='dropdown-user']")
    WebElement userMenu;

    String menuOptionPath = "//ul[@id='slide-out']/li/a[contains(text(),'%s')]";

    @FindBy(xpath = "//li[@class='logout-button']")
    WebElement logoutButton;

    public void openWebsite() {
        driver.navigate().to(ConfigReader.getConfigValue("base.url"));
    }

    public void selectCity(String cityName) {
        pause(3);
        searchCityInput.sendKeys(cityName);
        WebElement selectCity = driver.findElement(By.xpath(String.format(citySelectPath, cityName)));
        selectCity.click();
        if (isDisplayed(notificationNotNow)) {
            click(notificationNotNow);
        }
    }

    public boolean isUserOnHomePage() {
        return loginButton.isDisplayed();
    }

    public boolean verifyCitySelected() {
        return citySelected.getText().equals(ConfigReader.getConfigValue("city.name"));
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public boolean isLoginSuccessFul() {
        return userLoginName.getText().equals(ConfigReader.getConfigValue("user.name"));
    }

    public void clicksOnLocationOption() {
        click(locationOption);
    }

    public void entersLocationName(String locationName) {
        searchCityInput.sendKeys(locationName);
        ConfigReader.setConfigValue("search.location", locationName);
    }

    public void clicksOnEnteredLocation() {
        WebElement cityEle = driver.findElement(By.xpath(String.format(citySelectPath, ConfigReader.getConfigValue("search.location"))));
        cityEle.click();
    }

    public boolean isSelectedLocationDisplayed() {
        return citySelected.getText().equals(ConfigReader.getConfigValue("search.location"));
    }

    public boolean isSelectedLocationNotDisplayed() {
        WebElement cityEle = driver.findElement(By.xpath(String.format(citySelectPath, ConfigReader.getConfigValue("search.location"))));
        return isDisplayed(cityEle);
    }

    public void clicksClearOnLocationSearch() {
        clearBtn.click();
    }

    public boolean isInputFieldNull() {
        return searchCityInput.getAttribute("value").isEmpty();
    }

    public void entersDetailsForRide(String pickupDate, String pickupTime, String dropOffDate, String dropOffTime) {

//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//        executor.executeScript("arguments[0].scrollIntoView(true);",searchBtn);
        actions.moveToElement(searchBtn).build().perform();
        click(pickupDateInput);

        pause(1);
        WebElement pickupDateEle = driver.findElement(By.xpath(String.format(pickupDateXpath, pickupDate)));
        click(pickupDateEle);

        pause(1);
        WebElement pickupTimeEle = driver.findElement(By.xpath(String.format(pickupTimeXpath, pickupTime)));
        click(pickupTimeEle);

        pause(1);
        WebElement dropOffDateEle = driver.findElement(By.xpath(String.format(dropOffDateXpath, dropOffDate)));
        click(dropOffDateEle);

        pause(1);
        WebElement dropOffTimeEle = driver.findElement(By.xpath(String.format(dropOffTimeXpath, dropOffTime)));
        click(dropOffTimeEle);

    }

    public void clicksOnSearchBtn() {
        click(searchBtn);
    }

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void selectMenuOption(String menuOption) {
        WebElement option = driver.findElement(By.xpath(String.format(menuOptionPath, menuOption)));
        option.click();
    }

    public void clickOnProfile() {
        pause(2);
        actions.moveToElement(userMenu).build().perform();
        pause(2);
    }


    public void clickOnLogoutOption() {
        logoutButton.click();
    }

    public boolean isLogOutSuccessFull() {
        return loginButton.isDisplayed();
    }
}
