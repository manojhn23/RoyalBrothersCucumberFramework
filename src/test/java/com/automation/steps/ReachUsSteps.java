package com.automation.steps;

import com.automation.pages.ui.ReachUsPage;
import com.automation.pages.web.WebReachUsPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ReachUsSteps {

    ReachUsPage reachUsPage;

    public ReachUsSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            reachUsPage = new WebReachUsPage();
        }
    }

    @Then("verify user is on reach us page")
    public void verifyUserIsOnReachUsPage() {
        Assert.assertTrue(reachUsPage.isReachUsPageDisplayed());
        CucumberReportManager.attachScreenshot();
    }

    @When("user enters the details as {string},{string},{string} and {string}")
    public void userEntersTheDetailsAsAnd(String name, String email, String mobile, String comment) {
        reachUsPage.entersTheDetails(name, email, mobile, comment);
    }

    @And("clicks on submit button")
    public void clicksOnSubmitButton() {
        reachUsPage.clicksSubmitBtn();
    }

    @Then("verify user can get a message {string}")
    public void verifyUserCanGetAMessage(String errorMsg) {
        Assert.assertTrue(reachUsPage.isErrorMsgDisplayed());
        Assert.assertEquals(reachUsPage.getErrorMsg(), ConfigReader.getConfigValue(errorMsg));
        CucumberReportManager.attachScreenshot();
    }

    @When("user enters the details as {string},{string} and {string}")
    public void userEntersTheDetailsAsAnd(String name, String email, String mobile) {
        reachUsPage.entersTheDetails(ConfigReader.getConfigValue(name), ConfigReader.getConfigValue(email), ConfigReader.getConfigValue(mobile));
    }
}
