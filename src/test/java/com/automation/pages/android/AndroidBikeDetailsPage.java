package com.automation.pages.android;

import com.automation.pages.ui.BikeDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.LinkedList;
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

    @FindBy(xpath = "//android.widget.TextView[@text='FILTER & SORT']/following-sibling::android.view.ViewGroup")
    WebElement cancelBtn;

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

    @Override
    public boolean isBikeDetailsPageDisplayed() {
        return searchByModel.isDisplayed();
    }

    @Override
    public void clicksHighToLowOption() {
        filterAndSortByBtn.click();
        highToLowSortOption.click();
        applyBtn.click();
//        cancelBtn.click();
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

    List<Double> before = new LinkedList<>();
    List<Double> after = new LinkedList<>();
    @Override
    public boolean isPricesInHighToLow() {
        getPriceFromCard();
        before.sort(Collections.reverseOrder());
        System.out.println(before);
        System.out.println(after);
        return before.equals(after);
    }

    private void getPriceFromCard(){
        int i=1;
        List<Double> prices = new LinkedList<>();
        String currentTitle = bikeCardTitle.getText();
        String prevTitle = "";
        int tabHeight = appliedFilterSortTab.getLocation().getY()+ appliedFilterSortTab.getSize().getHeight();
        while (!prevTitle.equals(currentTitle)){
            bikeDetailCard = driver.findElement(By.xpath("//android.widget.ImageView/preceding-sibling::android.widget.TextView/../.."));
            System.out.println("Before scroll "+i);
            System.out.println(currentTitle);
            System.out.println(prevTitle);
            int x = bikeDetailCard.getLocation().getX();
            int y = bikeDetailCard.getLocation().getY();
            int width = bikeDetailCard.getSize().getWidth();
            int height = bikeDetailCard.getSize().getHeight();

            String price = bikeCardPrice.getText().replace("₹","").trim();
            prices.add(Double.parseDouble(price));
            scrollOrSwipe(x+width/2, y+height, x+width/2, tabHeight);

            prevTitle = currentTitle;
            try{
                bikeCardTitle = driver.findElement(By.xpath("//android.widget.ImageView/preceding-sibling::android.widget.TextView"));
                bikeCardPrice = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'₹')]"));
            } catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }

            currentTitle = bikeCardTitle.getText();

            System.out.println("After scroll "+i++);
            System.out.println(currentTitle);
            System.out.println(prevTitle);
            if (isPresent(similarModelText)){
                break;
            }
        }
        before = prices;
        after = prices;
    }
}
