package com.automation.steps;

import com.automation.pages.android.AndroidOrderSummaryPage;
import com.automation.pages.ui.OrderSummaryPage;
import com.automation.pages.web.WebOrderSummaryPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OrderSummarySteps {

    OrderSummaryPage orderSummaryPage;

    public OrderSummarySteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            orderSummaryPage = new WebOrderSummaryPage();
        } else {
            orderSummaryPage = new AndroidOrderSummaryPage();
        }
    }

    @Then("verify user is on order summary page")
    public void verifyUserIsOnOrderSummaryPage() {
        Assert.assertTrue(orderSummaryPage.isUserOnOrderSummaryPage());
        ReportManager.attachScreenshot();
    }

    @And("verify order summary page should display the correct total payment amount")
    public void verifyOrderSummaryPageShouldDisplayTheCorrectTotalPaymentAmount() {
        Assert.assertTrue(orderSummaryPage.validateTotalAmount());
        ReportManager.attachScreenshot();
    }
}
