package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @FindBy(id = "svg-menu-container")
    WebElement hamburgerMenu;

    String menuOptionPath = "//ul[@id='slide-out']/li/a[contains(text(),'%s')]";

    public void openWebsite() {
        driver.navigate().to(ConfigReader.getConfigValue("base.url"));
    }

    public void selectCity(String cityName) {
        pause(3);
        searchCityInput.sendKeys(cityName);
        WebElement selectCity = driver.findElement(By.xpath(String.format(citySelectPath, cityName)));
        selectCity.click();
    }

    public boolean isUserOnHomePage() {
        return loginButton.isDisplayed();
    }

    public boolean verifyCitySelected() {
        return citySelected.getText().equals(ConfigReader.getConfigValue("city.name"));
    }

    public void clickOnLoginButton() {
        notificationNotNow.click();
        loginButton.click();
    }

    public boolean isLoginSuccessFul() {
        return userLoginName.getText().equals(ConfigReader.getConfigValue("user.name"));
    }

    public void clicksOnLocationOption() {
        locationOption.click();
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
        return searchCityInput.getText().isEmpty();
    }

    public void clickOnHamburgerMenu() {
        notificationNotNow.click();
        hamburgerMenu.click();
    }

    public void selectMenuOption(String menuOption) {
        WebElement option = driver.findElement(By.xpath(String.format(menuOptionPath, menuOption)));
        option.click();
    }
}
