package com.automation.steps;

import com.automation.pages.ui.InterCityTravelPage;
import com.automation.pages.web.WebInterCityTravelPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class InterCityTravelSteps {

    InterCityTravelPage interCityTravelPage;

    public InterCityTravelSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            interCityTravelPage = new WebInterCityTravelPage();
        }
    }

    @Then("verify user is on Inter-city travel page")
    public void verifyUserIsOnInterCityTravelPage() {
        Assert.assertTrue(interCityTravelPage.isInterCityTravelPageDisplayed());
        CucumberReportManager.attachScreenshot();
    }

    @When("user enters the details for ride")
    public void userEntersTheDetailsForRide(List<String> rideDetails) {
        interCityTravelPage.entersDetailsForRide(rideDetails);
    }

    @And("clicks on search button on page")
    public void clicksOnSearchButtonOnPage() {
        interCityTravelPage.clicksOnSearchButton();
    }

}
