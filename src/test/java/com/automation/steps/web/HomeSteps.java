package com.automation.steps.web;

import com.automation.pages.web.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user is on website")
    public void user_is_on_website() {
        homePage.openWebsite();
    }

    @When("user select his desired city {string}")
    public void userSelectHisDesiredCity(String cityName) {
        homePage.selectCity(ConfigReader.getConfigValue(cityName));
    }

    @Then("verify user is on the home page")
    public void verify_user_is_on_the_home_page() {
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @Then("user can view city-specific services")
    public void user_can_view_city_specific_services() {
        Assert.assertTrue(homePage.verifyCitySelected());
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        homePage.clickOnLoginButton();
    }

    @Then("verify login is successful")
    public void verify_login_is_successful() {
        Assert.assertTrue(homePage.isLoginSuccessFul());
    }

    @When("user enters the details for ride {string}, {string}, {string} and {string}")
    public void user_enters_the_details_for_ride_and(String pickupDate, String pickupTime, String dropOffDate, String dropOffTime) {
        homePage.entersDetailsForRide(ConfigReader.getConfigValue(pickupDate), ConfigReader.getConfigValue(pickupTime),
                ConfigReader.getConfigValue(dropOffDate), ConfigReader.getConfigValue(dropOffTime));
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        homePage.clicksOnSearchBtn();
    }

    @When("clicks on the location option")
    public void clicksOnTheLocationOption() {
        homePage.clicksOnLocationOption();
    }

    @When("enters the location as {string}")
    public void enters_the_location_as(String locationName) {
        homePage.entersLocationName(locationName);
    }

    @When("clicks on the entered location")
    public void clicks_on_the_entered_location() {
        homePage.clicksOnEnteredLocation();
    }

    @Then("verify the location of user chosen")
    public void verify_the_location_of_user_chosen() {
        Assert.assertTrue(homePage.isSelectedLocationDisplayed());
    }

    @Then("verify the location of user chosen not getting")
    public void verifyTheLocationOfUserChosenNotGetting() {
        Assert.assertFalse(homePage.isSelectedLocationNotDisplayed());
    }

    @And("clicks on clear button")
    public void clicksOnClearButton() {
        homePage.clicksClearOnLocationSearch();
    }

    @Then("verify user can get empty on search input field")
    public void verifyUserCanGetEmptyOnSearchInputField() {
        Assert.assertTrue(homePage.isInputFieldNull());
    }


    @When("user selects the store option")
    public void user_selects_the_store_option() {

    }

    @When("enters the desired location as {string}")
    public void entersTheDesiredLocationAs(String locationName) {
        homePage.entersLocationName(ConfigReader.getConfigValue(locationName));
    }

    @When("user click on  hamburger menu")
    public void userClickOnHamburgerMenu() {
        homePage.clickOnHamburgerMenu();
    }

    @And("selects {string} from the menu")
    public void selectsFromTheMenu(String menuOption) {
        homePage.selectMenuOption(menuOption);
    }

    @When("user click on profile")
    public void userClickOnProfile() {
        homePage.clickOnProfile();
    }

    @And("the user selects the Logout option from the profile menu")
    public void theUserSelectsTheLogoutOptionFromTheProfileMenu() {
        homePage.clickOnLogoutOption();
    }

    @Then("verify successful user logout")
    public void verifySuccessfulUserLogout() {
        Assert.assertTrue(homePage.isLogOutSuccessFull());
    }

}
