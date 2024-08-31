package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage;

    public HomeSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            homePage = new WebHomePage();
        } else {
            homePage = new AndroidHomePage();
        }
    }

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
        ReportManager.attachScreenshot();
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @Then("user can view city-specific services")
    public void user_can_view_city_specific_services() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(homePage.verifyCitySelected());
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        homePage.clickOnLoginButton();
    }

    @Then("verify login is successful")
    public void verify_login_is_successful() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(homePage.isLoginSuccessFul());
    }

    @When("user enters the details for ride {string}, {string}, {string} and {string}")
    public void user_enters_the_details_for_ride_and(String pickupDate, String pickupTime, String dropOffDate, String dropOffTime) {
        homePage.entersDetailsForRide(pickupDate, pickupTime, dropOffDate, dropOffTime);
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
        ReportManager.attachScreenshot();
        Assert.assertTrue(homePage.isSelectedLocationDisplayed());
    }

    @Then("verify the location of user chosen not getting")
    public void verifyTheLocationOfUserChosenNotGetting() {
        ReportManager.attachScreenshot();
        Assert.assertFalse(homePage.isSelectedLocationNotDisplayed());
    }

    @And("clicks on clear button")
    public void clicksOnClearButton() {
        homePage.clicksClearOnLocationSearch();
    }

    @Then("verify user can get empty on search input field")
    public void verifyUserCanGetEmptyOnSearchInputField() {
        ReportManager.attachScreenshot();
        Assert.assertNull(homePage.getLocationInputText());
        Assert.assertTrue(homePage.isInputFieldNull());
    }

    @When("enters the desired location as {string}")
    public void entersTheDesiredLocationAs(String locationName) {
        homePage.entersLocationName(ConfigReader.getConfigValue(locationName));
    }

    @When("user click on  hamburger menu")
    public void userClickOnHamburgerMenu() {
        homePage.clickOnHamburgerMenu();
    }

    @When("user selects {string} from the menu")
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
        ReportManager.attachScreenshot();
        Assert.assertTrue(homePage.isLogOutSuccessFull());
    }

    @Then("verify user can get a city selection option")
    public void verifyUserCanGetACitySelectionOption() {
        ReportManager.attachScreenshot();
        Assert.assertTrue(homePage.isCitySelectionDisplayed());
    }

    @Given("user opens application")
    public void userOpensApplication() {
        homePage.openApplication();
    }


    @Given("the user opens the website or application")
    public void theUserOpensTheWebsiteOrApplication() {
        homePage.openApplication();
    }

    @When("user clicks on the menu option")
    public void userClicksOnTheMenuOption() {
        homePage.clickOnMenuOption();
    }

    @And("selects the login option from the menu")
    public void selectsTheLoginOptionFromTheMenu() {
        homePage.selectLoginOption();
    }

    @And("selects the logout option from the menu")
    public void selectsTheLogoutOptionFromTheMenu() {
        homePage.clickOnLogoutOption();
    }

    @Then("verify the user is logged out successfully")
    public void verifyTheUserIsLoggedOutSuccessfully() {
        Assert.assertTrue(homePage.isLogOutSuccessFull());
    }
}
