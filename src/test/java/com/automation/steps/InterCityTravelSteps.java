package com.automation.steps;

import com.automation.pages.web.InterCityTravelPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class InterCityTravelSteps {

    InterCityTravelPage interCityTravelPage = new InterCityTravelPage();

    @Then("verify user is on Inter-city travel page")
    public void verifyUserIsOnInterCityTravelPage() {
        Assert.assertTrue(interCityTravelPage.isInterCityTravelPageDisplayed());
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
