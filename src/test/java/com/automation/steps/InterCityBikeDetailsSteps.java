package com.automation.steps;

import com.automation.pages.web.InterCityBikeDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InterCityBikeDetailsSteps {

    InterCityBikeDetailsPage interCityBikeDetailsPage = new InterCityBikeDetailsPage();

    @Then("verify user is on intercity bike details page")
    public void verifyUserIsOnIntercityBikeDetailsPage() {
        Assert.assertTrue(interCityBikeDetailsPage.isBikeDetailsPageDisplayed());
    }

    @When("user clicks on request booking for first bike")
    public void userClicksOnRequestBookingForFirstBike() {
        interCityBikeDetailsPage.clicksOnRequestBookingBtn();
    }

    @Then("verify user can access confirm request button")
    public void verifyUserCanAccessConfirmRequestButton() {
        Assert.assertTrue(interCityBikeDetailsPage.isConfirmRequestBtnDisplayed());
    }
}
