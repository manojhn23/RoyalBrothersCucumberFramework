package com.automation.steps;

import com.automation.pages.BikeCheckoutPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class BikeCheckoutSteps {
    BikeCheckoutPage bikeCheckoutPage = new BikeCheckoutPage();

    @Then("verify user can get make payment option")
    public void verifyUserCanGetMakePaymentOption() {
        Assert.assertTrue(bikeCheckoutPage.isMakePaymentOptionDisplayed());
    }

    @Then("verify user is on bike checkout page")
    public void verifyUserIsOnBikeCheckoutPage() {
        Assert.assertTrue(bikeCheckoutPage.isBikeCheckoutPageDisplayed());
    }
}
