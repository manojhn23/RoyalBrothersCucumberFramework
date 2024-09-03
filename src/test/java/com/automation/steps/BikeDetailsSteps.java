package com.automation.steps;

import com.automation.pages.android.AndroidBikeDetailsPage;
import com.automation.pages.ui.BikeDetailsPage;
import com.automation.pages.web.WebBikeDetailsPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BikeDetailsSteps {

    BikeDetailsPage bikeDetailsPage;

    public BikeDetailsSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            bikeDetailsPage = new WebBikeDetailsPage();
        } else {
            bikeDetailsPage = new AndroidBikeDetailsPage();
        }
    }

    @Then("verify user is on bike details page")
    public void verify_user_is_on_bike_details_page() {
        Assert.assertTrue(bikeDetailsPage.isBikeDetailsPageDisplayed());
        ReportManager.attachScreenshot();
    }

    @When("user clicks on price high to low")
    public void user_clicks_on_price_high_to_low() {
        bikeDetailsPage.clicksHighToLowOption();
    }

    @Then("verify user can get prices in high to low")
    public void verify_user_can_get_prices_in_high_to_low() {
        Assert.assertTrue(bikeDetailsPage.isPricesInHighToLow());
        ReportManager.attachScreenshot();
    }

    @When("user clicks on price low to high")
    public void user_clicks_on_price_low_to_high() {
        bikeDetailsPage.clicksLowToHighOption();
    }

    @Then("verify user can get prices in low to high")
    public void verify_user_can_get_prices_in_low_to_high() {
        Assert.assertTrue(bikeDetailsPage.isPricesInLowToHigh());
        ReportManager.attachScreenshot();
    }

    @When("user selects the bike model {string}")
    public void user_selects_the_bike_model(String bikeModel) {
        bikeDetailsPage.selectTheBikeModelFilter(ConfigReader.getConfigValue(bikeModel));
    }

    @Then("verify user can get all bikes as selected model")
    public void verify_user_can_get_all_bikes_as_selected_model() {
        Assert.assertTrue(bikeDetailsPage.isSelectedBikeModelsShown());
        ReportManager.attachScreenshot();
    }

    @When("user selects the bike location {string}")
    public void user_selects_the_bike_location(String bikeLocation) {
        bikeDetailsPage.selectTheBikeLocationFilter(ConfigReader.getConfigValue(bikeLocation));
    }

    @Then("verify user can get all bikes as selected location")
    public void verify_user_can_get_all_bikes_as_selected_location() {
        Assert.assertTrue(bikeDetailsPage.isSelectedBikeLocationShown());
        ReportManager.attachScreenshot();
    }

    @When("user selects the bike model {string} and location {string}")
    public void user_selects_the_bike_model_and_location(String bikeModel, String bikeLocation) {
        bikeDetailsPage.selectBikeModelAndLocationFilter(ConfigReader.getConfigValue(bikeModel), ConfigReader.getConfigValue(bikeLocation));
    }

    @Then("verify user can get all bikes as selected model and location")
    public void verify_user_can_get_all_bikes_as_selected_model_and_location() {
        Assert.assertTrue(bikeDetailsPage.isSelectedFilterApplied());
        ReportManager.attachScreenshot();
    }

    @When("user clicks on book of first bike")
    public void userClicksOnBookOfFirstBike() {
        bikeDetailsPage.clicksBookBtnOfFirstBike();
    }


}
