package com.automation.steps.web;

import com.automation.pages.web.OrderSummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OrderSummarySteps {

    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

    @Then("verify user is on order summary page")
    public void verifyUserIsOnOrderSummaryPage() {
        Assert.assertTrue(orderSummaryPage.isUserOnOrderSummaryPage());
    }

    @And("verify order summary page should display the correct total payment amount")
    public void verifyOrderSummaryPageShouldDisplayTheCorrectTotalPaymentAmount() {
        Assert.assertTrue(orderSummaryPage.validateTotalAmount());
    }
}
