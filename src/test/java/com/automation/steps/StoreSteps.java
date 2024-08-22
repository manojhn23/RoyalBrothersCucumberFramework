package com.automation.steps;

import com.automation.pages.web.WebStorePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreSteps {

    WebStorePage storePage = new WebStorePage();

    @Then("verify user is on store page")
    public void verify_user_is_on_store_page() {
        Assert.assertTrue(storePage.isUserOnStorePage());
    }

    @When("user selects the product {string}")
    public void user_selects_the_product(String productCategory) {
        storePage.selectProductCategory(ConfigReader.getConfigValue(productCategory));
    }

}
