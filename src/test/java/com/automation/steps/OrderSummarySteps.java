package com.automation.steps;

import com.automation.pages.ui.OrderSummaryPage;
import com.automation.pages.web.WebOrderSummaryPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OrderSummarySteps {

   OrderSummaryPage orderSummaryPage;

   public OrderSummarySteps(){
       if (ConfigReader.getConfigValue("application.type").equals("web")) {
           orderSummaryPage = new WebOrderSummaryPage();
       }
   }

    @Then("verify user is on order summary page")
    public void verifyUserIsOnOrderSummaryPage() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(orderSummaryPage.isUserOnOrderSummaryPage());
    }

    @And("verify order summary page should display the correct total payment amount")
    public void verifyOrderSummaryPageShouldDisplayTheCorrectTotalPaymentAmount() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(orderSummaryPage.validateTotalAmount());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
