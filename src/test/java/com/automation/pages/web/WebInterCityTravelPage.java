package com.automation.pages.web;

import com.automation.pages.ui.InterCityTravelPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebInterCityTravelPage extends WebBasePage implements InterCityTravelPage {

    @FindBy(id = "inter_city_search")
    WebElement searchForm;

    @FindBy(id = "pickup-date")
    WebElement pickupDateInput;

    @FindBy(id = "pickup-time")
    WebElement pickupTimeInput;

    @FindBy(xpath = "(//h6[text()='Dropoff City']/following-sibling::div//input)[1]")
    WebElement dropOffCityDropdown;

    @FindBy(id = "dropoff-date")
    WebElement dropOffDateInput;

    @FindBy(id = "dropoff-time")
    WebElement dropOffTimeInput;

    @FindBy(xpath = "(//button[text()='Search'])[2]")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@id='pickup-date_root']//div[@title='Next month']")
    WebElement pickupNextMonthBtn;

    @FindBy(xpath = "//div[@id='dropoff-date_root']//div[@title='Next month']")
    WebElement dropOffNextMonthBtn;

    String pickupDateXpath = "//table[@id='pickup-date_table']//div[@aria-label='%s']";
    String pickupTimeXpath = "//input[@id='pickup-time']/following-sibling::div//li[@aria-label='%s']";

    String dropOffCityXpath = "//h6[text()='Dropoff City']/following-sibling::div//li[contains(@id,'select-options')]/span[text()='%s']";
    String dropOffDateXpath = "//table[@id='dropoff-date_table']//div[@aria-label='%s']";
    String dropOffTimeXpath = "//input[@id='dropoff-time']/following-sibling::div//li[@aria-label='%s']";

    @Override
    public boolean isInterCityTravelPageDisplayed() {
        return searchForm.isDisplayed();
    }

    @Override
    public void entersDetailsForRide(List<String> rideDetails) {

        click(pickupDateInput);
        selectDate(pickupNextMonthBtn, pickupDateXpath, rideDetails.get(0));

        click(pickupTimeInput);
        WebElement pickupTime = driver.findElement(By.xpath(String.format(pickupTimeXpath, ConfigReader.getConfigValue(rideDetails.get(1)))));
        click(pickupTime);

        click(dropOffCityDropdown);
        WebElement dropOffCity = driver.findElement(By.xpath(String.format(dropOffCityXpath, ConfigReader.getConfigValue(rideDetails.get(2)))));
        click(dropOffCity);

        click(dropOffDateInput);
        selectDate(dropOffNextMonthBtn, dropOffDateXpath, rideDetails.get(3));

        click(dropOffTimeInput);
        WebElement dropOffTime = driver.findElement(By.xpath(String.format(dropOffTimeXpath, ConfigReader.getConfigValue(rideDetails.get(4)))));
        click(dropOffTime);
    }

    @Override
    public void clicksOnSearchButton() {
        click(searchBtn);
    }

    private void selectDate(WebElement nextBtn, String xpath, String value) {
        WebElement element;
        try {
            setImplicitWait(2);
            element = driver.findElement(By.xpath(String.format(xpath, ConfigReader.getConfigValue(value))));
            click(element);
        } catch (Exception e) {
            click(nextBtn);
            selectDate(nextBtn, xpath, value);
        } finally {
            setImplicitWait(60);
        }
    }
}
