package com.automation.steps;

import com.automation.pages.android.AndroidStoreProductPage;
import com.automation.pages.ui.StoreProductPage;
import com.automation.pages.web.WebStoreProductPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class StoreProductSteps {

    StoreProductPage storeProductPage;

    public StoreProductSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            storeProductPage = new WebStoreProductPage();
        } else {
            storeProductPage = new AndroidStoreProductPage();
        }
    }

    @And("adds the product to the cart {string} and {string}")
    public void addsTheProductToTheCartAnd(String product1, String product2) {
        storeProductPage.addProductsToTheCart(ConfigReader.getConfigValue(product1), ConfigReader.getConfigValue(product2));
    }

    @And("the user selects the Sort by option and chooses {string}")
    public void theUserSelectsTheSortByOptionAndChooses(String sortByOption) {
        storeProductPage.sortProductBy(ConfigReader.getConfigValue(sortByOption));
    }

    @Then("verify that the prices of all listed products are displayed in ascending order")
    public void verifyThatThePricesOfAllListedProductsAreDisplayedInAscendingOrder() {
        Assert.assertTrue(storeProductPage.isProductSortedFromPriceLowToHigh());
        CucumberReportManager.attachScreenshot();
    }

    @Then("verify that the prices of all listed products are displayed in descending order")
    public void verifyThatThePricesOfAllListedProductsAreDisplayedInDescendingOrder() {
        Assert.assertTrue(storeProductPage.isProductSortedFromPriceHighToLow());
        CucumberReportManager.attachScreenshot();
    }

    @Then("verify user should see product names sorted alphabetically from A to Z")
    public void verifyUserShouldSeeProductNamesSortedAlphabeticallyFromAToZ() {
        Assert.assertTrue(storeProductPage.isProductSortedFromAtoZ());
        CucumberReportManager.attachScreenshot();
    }

    @Then("verify user should see product names sorted alphabetically from Z to A")
    public void verifyUserShouldSeeProductNamesSortedAlphabeticallyFromZToA() {
        Assert.assertTrue(storeProductPage.isProductSortedFromZtoA());
        CucumberReportManager.attachScreenshot();
    }

}
