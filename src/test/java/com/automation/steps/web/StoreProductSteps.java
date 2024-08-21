package com.automation.steps.web;

import com.automation.pages.web.StoreProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class StoreProductSteps {

    StoreProductPage storeProductPage = new StoreProductPage();

    @And("adds the product to the cart {string} and {string}")
    public void addsTheProductToTheCartAnd(String product1, String product2) {
        storeProductPage.addProductsToTheCart(ConfigReader.getConfigValue(product1), ConfigReader.getConfigValue(product2));
    }

    @And("the user selects the Sort by option and chooses {string}")
    public void theUserSelectsTheSortByOptionAndChooses(String sortByOption) {
        storeProductPage.sortProductBy(sortByOption);
    }

    @Then("verify that the prices of all listed products are displayed in ascending order")
    public void verifyThatThePricesOfAllListedProductsAreDisplayedInAscendingOrder() {
        Assert.assertTrue(storeProductPage.isProductSortedFromPriceLowToHigh());
    }

    @Then("verify that the prices of all listed products are displayed in descending order")
    public void verifyThatThePricesOfAllListedProductsAreDisplayedInDescendingOrder() {
        Assert.assertTrue(storeProductPage.isProductSortedFromPriceHighToLow());
    }

    @Then("verify user should see product names sorted alphabetically from A to Z")
    public void verifyUserShouldSeeProductNamesSortedAlphabeticallyFromAToZ() {
        Assert.assertTrue(storeProductPage.isProductSortedFromAtoZ());
    }

    @Then("verify user should see product names sorted alphabetically from Z to A")
    public void verifyUserShouldSeeProductNamesSortedAlphabeticallyFromZToA() {
        Assert.assertTrue(storeProductPage.isProductSortedFromZtoA());
    }
}
