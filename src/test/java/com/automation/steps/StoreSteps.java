package com.automation.steps;

import com.automation.pages.android.AndroidStorePage;
import com.automation.pages.ui.StorePage;
import com.automation.pages.web.WebStorePage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreSteps {

    StorePage storePage;

    public StoreSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            storePage = new WebStorePage();
        } else {
            storePage = new AndroidStorePage();
        }
    }

    @Then("verify user is on store page")
    public void verify_user_is_on_store_page() {
        Assert.assertTrue(storePage.isUserOnStorePage());
        ReportManager.attachScreenshot();
    }

    @When("user selects the product {string}")
    public void user_selects_the_product(String productCategory) {
        storePage.selectProductCategory(ConfigReader.getConfigValue(productCategory));
    }

}
