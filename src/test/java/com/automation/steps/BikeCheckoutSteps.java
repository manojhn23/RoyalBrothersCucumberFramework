package com.automation.steps;

import com.automation.pages.ui.BikeCheckoutPage;
import com.automation.pages.web.WebBikeCheckoutPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class BikeCheckoutSteps {
    BikeCheckoutPage bikeCheckoutPage;

    public BikeCheckoutSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            bikeCheckoutPage = new WebBikeCheckoutPage();
        }
    }

    @Then("verify user can get make payment option")
    public void verifyUserCanGetMakePaymentOption() {
        Assert.assertTrue(bikeCheckoutPage.isMakePaymentOptionDisplayed());
        CucumberReportManager.attachScreenshot();
    }

    @Then("verify user is on bike checkout page")
    public void verifyUserIsOnBikeCheckoutPage() {
        Assert.assertTrue(bikeCheckoutPage.isBikeCheckoutPageDisplayed());
        CucumberReportManager.attachScreenshot();
    }
}
