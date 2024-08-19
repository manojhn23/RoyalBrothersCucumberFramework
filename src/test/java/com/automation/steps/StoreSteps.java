package com.automation.steps;

import com.automation.pages.StorePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreSteps {

    StorePage storePage = new StorePage();

    @Then("verify user is on store page")
    public void verify_user_is_on_store_page() {
        Assert.assertTrue(storePage.isUserOnStorePage());
    }

    @When("user selects the product {string}")
    public void user_selects_the_product(String productCategory) {
        storePage.selectProductCategory(ConfigReader.getConfigValue(productCategory));
    }

}
