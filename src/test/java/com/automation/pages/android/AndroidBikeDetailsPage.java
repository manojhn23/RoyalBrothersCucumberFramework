package com.automation.pages.android;

import com.automation.pages.ui.BikeDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AndroidBikeDetailsPage extends AndroidBasePage implements BikeDetailsPage {

    String pickupLocationXpath = "//android.widget.TextView[@text='Select Pickup Location']";
    String locationDropdownXpath = "(//android.widget.TextView[contains(@text,'AVAIL')]/following-sibling::android.view.ViewGroup//android.widget.TextView)[1]";
    String closeBtnWithFollowSib = "//android.widget.TextView[contains(@text,'LOCATION')]/preceding-sibling::android.view.ViewGroup";
    String closeBtnWithPrecedingSib = "//android.widget.TextView[contains(@text,'LOCATION')]/following-sibling::android.view.ViewGroup";
    String bikeDetailCardXpath = "//android.widget.ImageView/preceding-sibling::android.widget.TextView/../..";
    String bikeCardTitleXpath = "//android.widget.ImageView/preceding-sibling::android.widget.TextView";
    String bikeCardPriceXpath = "//android.widget.TextView[contains(@text,'₹')]";

    @FindBy(xpath = "//android.widget.TextView[@text='Search by Model']")
    WebElement searchByModel;

    @FindBy(xpath = "//android.widget.TextView[@text='BOOK NOW']")
    WebElement bookNowButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Select Pickup Location']")
    WebElement pickUpLocation;

    @FindBy(xpath = "//android.widget.TextView[@text='AVAILABLE']/../android.view.ViewGroup")
    List<WebElement> availableFirstPickUpLocations;

    @FindBy(xpath = "//android.widget.TextView[@text='Search by Model']/../following-sibling::android.view.ViewGroup/android.view.ViewGroup")
    WebElement filterAndSortByBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Low to High']")
    WebElement lowToHighSortOption;

    @FindBy(xpath = "//android.widget.TextView[@text='High to Low']")
    WebElement highToLowSortOption;

    @FindBy(xpath = "//android.widget.TextView[@text='APPLY']")
    WebElement applyBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Model']")
    WebElement modelOption;

    @FindBy(xpath = "//android.widget.EditText[@text='Search for bike models']")
    WebElement modelSearchInput;

    String bikeModelOptionXpath = "(//android.widget.TextView[contains(@text,'%s')]/ancestor::android.widget.ScrollView//android.view.ViewGroup)[6]";

    @FindBy(xpath = "//android.widget.TextView[@text='Location']")
    WebElement locationOption;

    String locationOptionXpath = "//android.widget.TextView[contains(@text,'%s')]/preceding-sibling::android.view.ViewGroup";

//    @FindBy(xpath = "//android.widget.TextView[@text='FILTER & SORT']/following-sibling::android.view.ViewGroup")
//    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.ImageView/preceding-sibling::android.widget.TextView")
    WebElement bikeCardTitle;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'₹')]")
    WebElement bikeCardPrice;

    @FindBy(xpath = "//android.widget.ImageView/preceding-sibling::android.widget.TextView/../..")
    WebElement bikeDetailCard;

    @FindBy(xpath = "//android.widget.ScrollView/preceding-sibling::android.view.ViewGroup")
    WebElement appliedFilterSortTab;

    @FindBy(xpath = "//android.widget.TextView[@text=' Similiar Models ']")
    WebElement similarModelText;

    @FindBy(xpath = "//android.widget.TextView[@text='SOLD OUT']")
    WebElement soldOutBtn;

    @FindBy(xpath = "(//android.widget.TextView[contains(@text,'AVAIL')]/following-sibling::android.view.ViewGroup//android.widget.TextView)[1]")
    WebElement locationFromDropdown;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'LOCATION')]/preceding-sibling::android.view.ViewGroup")
    WebElement dropDownCloseBtn;

    @FindBy(xpath = "//android.widget.ImageView/../preceding-sibling::android.widget.TextView/..")
    WebElement disabledCard;

    @Override
    public boolean isBikeDetailsPageDisplayed() {
        return searchByModel.isDisplayed();
    }

    @Override
    public void clicksHighToLowOption() {
        filterAndSortByBtn.click();
        highToLowSortOption.click();
        applyBtn.click();
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

    List<Double> beforePrice = new ArrayList<>();
    List<Double> afterPrice = new ArrayList<>();

    @Override
    public boolean isPricesInHighToLow() {
        getPriceFromCard();
        beforePrice.sort(Collections.reverseOrder());
        System.out.println(beforePrice);
        System.out.println(afterPrice);
        return beforePrice.equals(afterPrice);
    }

    @Override
    public void clicksLowToHighOption() {
        filterAndSortByBtn.click();
        lowToHighSortOption.click();
        applyBtn.click();
    }

    @Override
    public boolean isPricesInLowToHigh() {
        getPriceFromCard();
        Collections.sort(beforePrice);
        System.out.println(beforePrice);
        System.out.println(afterPrice);
        return beforePrice.equals(afterPrice);
    }

    @Override
    public void selectTheBikeModelFilter(String bikeModel) {
        filterAndSortByBtn.click();
        modelOption.click();
        modelSearchInput.sendKeys(bikeModel);

        WebElement bikeModelOption = driver.findElement(By.xpath(String.format(bikeModelOptionXpath, bikeModel)));
        bikeModelOption.click();
        applyBtn.click();
    }

    List<String> titles = new ArrayList<>();
    List<String> locations = new ArrayList<>();

    @Override
    public boolean isSelectedBikeModelsShown() {
        getTitleFromCard();
        for (String title : titles) {
            if (!title.contains(ConfigReader.getConfigValue("bike.model"))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void selectTheBikeLocationFilter(String bikeLocation) {
        filterAndSortByBtn.click();
        locationOption.click();
        WebElement locationOption = driver.findElement(By.xpath(String.format(locationOptionXpath, bikeLocation)));
        locationOption.click();
        applyBtn.click();
    }

    @Override
    public boolean isSelectedBikeLocationShown() {
        getLocationFromCard();
        for (String location : locations) {
            if (!location.contains(ConfigReader.getConfigValue("bike.location"))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void selectBikeModelAndLocationFilter(String bikeModel, String bikeLocation) {
        filterAndSortByBtn.click();
        modelOption.click();
        modelSearchInput.sendKeys(bikeModel);
        WebElement bikeModelOption = driver.findElement(By.xpath(String.format(bikeModelOptionXpath, bikeModel)));
        bikeModelOption.click();

        locationOption.click();
        WebElement locationOption = driver.findElement(By.xpath(String.format(locationOptionXpath, bikeLocation)));
        locationOption.click();
        applyBtn.click();
    }

    @Override
    public boolean isSelectedFilterApplied() {
        getLocationAndModelFromCard();
        for (int i = 0; i < titles.size(); i++) {
            if (!locations.get(i).contains(ConfigReader.getConfigValue("bike.location")) || !titles.get(i).contains(ConfigReader.getConfigValue("bike.model"))) {
                return false;
            }
        }
        return true;
    }


    private void getPriceFromCard() {
        List<Double> prices = new ArrayList<>();
        String currentTitle = bikeCardTitle.getText();
        String prevTitle = "";
        int tabHeight = appliedFilterSortTab.getLocation().getY() + appliedFilterSortTab.getSize().getHeight();
        while (!prevTitle.equals(currentTitle)) {
            bikeDetailCard = driver.findElement(By.xpath(bikeDetailCardXpath));
            String price = bikeCardPrice.getText().replace("₹", "").trim();
            prices.add(Double.parseDouble(price));
            scrollBikeDetailCard(tabHeight);
            prevTitle = currentTitle;
            if (isPresent(similarModelText) || isPresent(soldOutBtn)) {
                break;
            }
            bikeCardTitle = driver.findElement(By.xpath(bikeCardTitleXpath));
            bikeCardPrice = driver.findElement(By.xpath(bikeCardPriceXpath));
            currentTitle = bikeCardTitle.getText();
        }
        beforePrice = prices;
        afterPrice = prices;
    }

    private void getTitleFromCard() {
        List<String> titles = new ArrayList<>();
        String currentTitle = bikeCardTitle.getText();
        String prevTitle = "";
        int tabHeight = appliedFilterSortTab.getLocation().getY() + appliedFilterSortTab.getSize().getHeight();
        while (!prevTitle.equals(currentTitle)) {
            bikeDetailCard = driver.findElement(By.xpath(bikeDetailCardXpath));
            titles.add(currentTitle);
            scrollBikeDetailCard(tabHeight);
            prevTitle = currentTitle;
            if (isPresent(similarModelText) || isPresent(soldOutBtn)) {
                break;
            }
            bikeCardTitle = driver.findElement(By.xpath(bikeCardTitleXpath));
            currentTitle = bikeCardTitle.getText();
        }
        this.titles = titles;
    }


    private void getLocationFromCard() {
        List<String> locations = new ArrayList<>();
        String currentTitle = bikeCardTitle.getText();
        String prevTitle = "";
        int tabHeight = appliedFilterSortTab.getLocation().getY() + appliedFilterSortTab.getSize().getHeight();
        while (!prevTitle.equals(currentTitle)) {
            pickUpLocation = driver.findElement(By.xpath(pickupLocationXpath));
            pickUpLocation.click();
            locationFromDropdown = driver.findElement(By.xpath(locationDropdownXpath));
            String location = locationFromDropdown.getText();
            locations.add(location);
            if (isDisplayed(closeBtnWithPrecedingSib)) {
                dropDownCloseBtn = driver.findElement(By.xpath(closeBtnWithPrecedingSib));
            } else if (isDisplayed(closeBtnWithFollowSib)) {
                dropDownCloseBtn = driver.findElement(By.xpath(closeBtnWithFollowSib));
            }
            dropDownCloseBtn.click();
            if (isPresent(disabledCard)) {
                break;
            }
            if (isDisplayed(bikeDetailCardXpath)) {
                bikeDetailCard = driver.findElement(By.xpath(bikeDetailCardXpath));
            }
            scrollBikeDetailCard(tabHeight);
            prevTitle = currentTitle;
            if (isPresent(similarModelText) || isPresent(soldOutBtn)) {
                break;
            }
            bikeDetailCard = driver.findElement(By.xpath(bikeDetailCardXpath));
            bikeCardTitle = driver.findElement(By.xpath(bikeCardTitleXpath));
            currentTitle = bikeCardTitle.getText();
        }
        this.locations = locations;
    }


    private void getLocationAndModelFromCard() {
        List<String> locations = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        String currentTitle = bikeCardTitle.getText();
        String prevTitle = "";
        int tabHeight = appliedFilterSortTab.getLocation().getY() + appliedFilterSortTab.getSize().getHeight();
        while (!prevTitle.equals(currentTitle)) {
            pickUpLocation = driver.findElement(By.xpath(pickupLocationXpath));
            pickUpLocation.click();
            locationFromDropdown = driver.findElement(By.xpath(locationDropdownXpath));
            String location = locationFromDropdown.getText();
            locations.add(location);
            if (isDisplayed(closeBtnWithFollowSib)) {
                dropDownCloseBtn = driver.findElement(By.xpath(closeBtnWithFollowSib));
            } else if (isDisplayed(closeBtnWithPrecedingSib)) {
                dropDownCloseBtn = driver.findElement(By.xpath(closeBtnWithPrecedingSib));
            }
            dropDownCloseBtn.click();
            titles.add(currentTitle);
            if (isPresent(disabledCard)) {
                break;
            }
            if (isDisplayed(bikeDetailCardXpath)) {
                bikeDetailCard = driver.findElement(By.xpath(bikeDetailCardXpath));
            }
            scrollBikeDetailCard(tabHeight);
            prevTitle = currentTitle;
            if (isPresent(similarModelText) || isPresent(soldOutBtn)) {
                break;
            }
            bikeDetailCard = driver.findElement(By.xpath(bikeDetailCardXpath));
            bikeCardTitle = driver.findElement(By.xpath(bikeCardTitleXpath));
            currentTitle = bikeCardTitle.getText();
        }
        this.locations = locations;
        this.titles = titles;
    }

    private void scrollBikeDetailCard(int tabHeight) {
        int x = bikeDetailCard.getLocation().getX();
        int y = bikeDetailCard.getLocation().getY();
        int width = bikeDetailCard.getSize().getWidth();
        int height = bikeDetailCard.getSize().getHeight();

        scrollOrSwipe(x + width / 2, y + height, x + width / 2, tabHeight);
    }

}
