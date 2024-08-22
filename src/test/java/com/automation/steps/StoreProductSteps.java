package com.automation.steps;

import com.automation.pages.ui.StoreProductPage;
import com.automation.pages.web.WebStoreProductPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class StoreProductSteps {

    StoreProductPage storeProductPage;

    public StoreProductSteps(){
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            storeProductPage = new WebStoreProductPage();
        }
    }

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
        ReportManager.attachScreenshot();
        Assert.assertTrue(storeProductPage.isProductSortedFromPriceLowToHigh());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("verify that the prices of all listed products are displayed in descending order")
    public void verifyThatThePricesOfAllListedProductsAreDisplayedInDescendingOrder() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(storeProductPage.isProductSortedFromPriceHighToLow());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("verify user should see product names sorted alphabetically from A to Z")
    public void verifyUserShouldSeeProductNamesSortedAlphabeticallyFromAToZ() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(storeProductPage.isProductSortedFromAtoZ());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("verify user should see product names sorted alphabetically from Z to A")
    public void verifyUserShouldSeeProductNamesSortedAlphabeticallyFromZToA() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(storeProductPage.isProductSortedFromZtoA());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
