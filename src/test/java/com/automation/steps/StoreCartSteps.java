package com.automation.steps;

import com.automation.pages.android.AndroidStoreCartPage;
import com.automation.pages.ui.StoreCartPage;
import com.automation.pages.web.WebStoreCartPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreCartSteps {

    StoreCartPage cartPage;

    public StoreCartSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            cartPage = new WebStoreCartPage();
        } else {
            cartPage = new AndroidStoreCartPage();
        }
    }

    @Then("verify that the product is successfully added to the cart")
    public void verifyThatTheProductIsSuccessfullyAddedToTheCart() {
        Assert.assertTrue(cartPage.isProductAddedSuccessFully());
        ReportManager.attachScreenshot();
    }

    @When("user removes product from the cart {string}")
    public void userRemovesProductFromTheCart(String productName) {
        cartPage.removeProductFromCart(ConfigReader.getConfigValue(productName));
    }

    @Then("verify product is removed from the cart successfully")
    public void verifyProductIsRemovedFromTheCartSuccessfully() {
        Assert.assertTrue(cartPage.isProductRemovedSuccessFully());
        ReportManager.attachScreenshot();
    }

    @When("user click on check out button")
    public void userClickOnCheckOutButton() {
        cartPage.clickOnCheckOutButton();
    }
}
