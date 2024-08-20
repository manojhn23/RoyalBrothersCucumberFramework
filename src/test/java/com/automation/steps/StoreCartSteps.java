package com.automation.steps;

import com.automation.pages.StoreCartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreCartSteps {

    StoreCartPage cartPage = new StoreCartPage();

    @Then("verify that the product is successfully added to the cart")
    public void verifyThatTheProductIsSuccessfullyAddedToTheCart() {
        Assert.assertTrue(cartPage.isProductAddedSuccessFully());
    }

    @When("user removes product from the cart {string}")
    public void userRemovesProductFromTheCart(String productName) {
        cartPage.removeProductFromCart(ConfigReader.getConfigValue(productName));
    }

    @Then("verify product is removed from the cart successfully")
    public void verifyProductIsRemovedFromTheCartSuccessfully() {
        Assert.assertTrue(cartPage.isProductRemovedSuccessFully());
    }

    @When("user click on check out button")
    public void userClickOnCheckOutButton() {
        cartPage.clickOnCheckOutButton();
    }
}
