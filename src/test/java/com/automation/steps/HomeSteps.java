package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens website")
    public void user_opens_website() {

    }

    @When("user select his desired city")
    public void user_select_his_desired_city() {

    }

    @Then("verify user is on the home page")
    public void verify_user_is_on_the_home_page() {

    }

    @Then("user can view city-specific services")
    public void user_can_view_city_specific_services() {

    }

    @When("user click on login button")
    public void user_click_on_login_button() {

    }

    @Then("verify login is successful")
    public void verify_login_is_successful() {

    }

    @When("user enters the details for ride {string}, {string}, {string} and {string}")
    public void user_enters_the_details_for_ride_and(String pickupDate, String pickupTime, String dropOffDate, String dropOffTime) {

    }

    @When("clicks on search button")
    public void clicks_on_search_button() {

    }

    @When("clicks on the location option")
    public void clicksOnTheLocationOption() {

    }

    @When("enters the location as {string}")
    public void enters_the_location_as(String locationName) {

    }

    @When("clicks on the entered location")
    public void clicks_on_the_entered_location() {

    }

    @Then("verify the location of user chosen")
    public void verify_the_location_of_user_chosen() {

    }

    @Then("verify the location of user chosen not getting")
    public void verifyTheLocationOfUserChosenNotGetting() {

    }

    @And("clicks on clear button")
    public void clicksOnClearButton() {

    }

    @Then("verify user can get empty on search input field")
    public void verifyUserCanGetEmptyOnSearchInputField() {

    }


    @When("user selects the store option")
    public void user_selects_the_store_option() {

    }


}
