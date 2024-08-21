package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BikeDetailsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'tarif-desc-body')]")
    WebElement bikeDetailsCard;

    @FindBy(id = "price_high_to_low")
    WebElement priceHighToLowOption;

    @FindBy(id = "price_low_to_high")
    WebElement priceLowToHighOption;

    @FindBy(id = "rental_amount")
    List<WebElement> bikePrices;

    @FindBy(xpath = "//input[contains(@class,'bike_model_input') and not(@name)]")
    WebElement bikeModelFilterInput;

    String bikeFilterOptionXpath = "//li[contains(., '%s')]//input";

    @FindBy(xpath = "//button[contains(@class,'apply-filter-desk')]")
    WebElement applyFilterBtn;

    @FindBy(xpath = "//h6[contains(@class,'bike_name')]")
    List<WebElement> bikeModelName;

    @FindBy(xpath = "//input[contains(@class,'location_input') and not(@name)]")
    WebElement bikeLocationFilterInput;

    String bikeLocationXpath = "//li[contains(@class,'fully_available selected') and contains(.,'%s')]/ancestor::div[contains(@class,'location_selection')]/input[@readonly]";

    @FindBy(xpath = "//button[contains(@class,'book_button')]")
    List<WebElement> bikeBookBtn;

    public boolean isBikeDetailsPageDisplayed() {
        return bikeDetailsCard.isDisplayed();
    }

    List<Double> priceBefore;

    public void clicksHighToLowOption() {
        priceBefore = new LinkedList<>();
        priceStringToDoubleConversion(priceBefore, bikePrices);
        click(priceHighToLowOption);
    }

    List<Double> priceAfter;

    public boolean isPricesInHighToLow() {
        priceAfter = new LinkedList<>();
        priceStringToDoubleConversion(priceAfter, bikePrices);
        priceBefore.sort(Collections.reverseOrder());
        return priceBefore.equals(priceAfter);
    }

    public void clicksLowToHighOption() {
        priceBefore = new LinkedList<>();
        priceStringToDoubleConversion(priceBefore, bikePrices);
        click(priceLowToHighOption);
    }

    public boolean isPricesInLowToHigh() {
        priceAfter = new LinkedList<>();
        priceStringToDoubleConversion(priceAfter, bikePrices);
        Collections.sort(priceBefore);
        return priceBefore.equals(priceAfter);
    }

    private void priceStringToDoubleConversion(List<Double> prices, List<WebElement> elements) {
        for (WebElement ele : elements) {
            prices.add(Double.parseDouble(ele.getText()));
        }
    }

    public void selectTheBikeModelFilter(String bikeModel) {
        bikeModelFilterInput.sendKeys(bikeModel);
        WebElement bikeModelOption = driver.findElement(By.xpath(String.format(bikeFilterOptionXpath, bikeModel)));
        click(bikeModelOption);
        click(applyFilterBtn);
    }

    public boolean isSelectedBikeModelsShown() {
        for (WebElement ele : bikeModelName) {
            if (!ele.getText().contains(ConfigReader.getConfigValue("bike.model"))) {
                return false;
            }
        }
        return true;
    }

    public void selectTheBikeLocationFilter(String bikeLocation) {
        bikeLocationFilterInput.sendKeys(bikeLocation);
        WebElement bikeLocationOption = driver.findElement(By.xpath(String.format(bikeFilterOptionXpath, bikeLocation)));
        click(bikeLocationOption);
        click(applyFilterBtn);
    }

    public boolean isSelectedBikeLocationShown() {
        pause(2);
        List<WebElement> bikeLocations = driver.findElements(By.xpath(String.format(bikeLocationXpath, ConfigReader.getConfigValue("bike.location"))));
        if (bikeLocations.isEmpty()) {
            return false;
        }
        for (WebElement ele : bikeLocations) {
            if (!ele.getAttribute("value").contains(ConfigReader.getConfigValue("bike.location"))) {
                return false;
            }
        }
        return true;
    }

    public void selectBikeModelAndLocationFilter(String bikeModel, String bikeLocation) {

        bikeModelFilterInput.sendKeys(bikeModel);
        WebElement bikeModelOption = driver.findElement(By.xpath(String.format(bikeFilterOptionXpath, bikeModel)));
        click(bikeModelOption);

        bikeLocationFilterInput.sendKeys(bikeLocation);
        WebElement bikeLocationOption = driver.findElement(By.xpath(String.format(bikeFilterOptionXpath, bikeLocation)));
        click(bikeLocationOption);

        click(applyFilterBtn);
    }

    public boolean isSelectedFilterApplied() {
        pause(2);
        for (WebElement ele : bikeModelName) {
            if (!ele.getText().contains(ConfigReader.getConfigValue("bike.model"))) {
                return false;
            }
        }
        List<WebElement> bikeLocations = driver.findElements(By.xpath(String.format(bikeLocationXpath, ConfigReader.getConfigValue("bike.location"))));
        if (bikeLocations.isEmpty()) {
            return false;
        }
        for (WebElement ele : bikeLocations) {
            if (!ele.getAttribute("value").contains(ConfigReader.getConfigValue("bike.location"))) {
                return false;
            }
        }
        return true;
    }

    public void clicksBookBtnOfFirstBike() {
        click(bikeBookBtn.get(0));
    }
}
