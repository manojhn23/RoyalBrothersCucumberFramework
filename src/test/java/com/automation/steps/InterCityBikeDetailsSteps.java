package com.automation.steps;

import com.automation.pages.ui.InterCityBikeDetailsPage;
import com.automation.pages.web.WebInterCityBikeDetailsPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InterCityBikeDetailsSteps {

    InterCityBikeDetailsPage interCityBikeDetailsPage;

    public InterCityBikeDetailsSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            interCityBikeDetailsPage = new WebInterCityBikeDetailsPage();
        }
    }

    @Then("verify user is on intercity bike details page")
    public void verifyUserIsOnIntercityBikeDetailsPage() {
        Assert.assertTrue(interCityBikeDetailsPage.isBikeDetailsPageDisplayed());
        ReportManager.attachScreenshot();
    }

    @When("user clicks on request booking for first bike")
    public void userClicksOnRequestBookingForFirstBike() {
        interCityBikeDetailsPage.clicksOnRequestBookingBtn();
    }

    @Then("verify user can access confirm request button")
    public void verifyUserCanAccessConfirmRequestButton() {
        Assert.assertTrue(interCityBikeDetailsPage.isConfirmRequestBtnDisplayed());
        ReportManager.attachScreenshot();
    }

}
