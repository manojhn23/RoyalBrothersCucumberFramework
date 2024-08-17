package com.automation.steps;

import com.automation.pages.BikeDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BikeDetailsSteps {

    BikeDetailsPage bikeDetailsPage = new BikeDetailsPage();

    @Then("verify user is on bike details page")
    public void verify_user_is_on_bike_details_page() {

    }

    @When("user clicks on price high to low")
    public void user_clicks_on_price_high_to_low() {

    }

    @Then("verify user can get prices in high to low")
    public void verify_user_can_get_prices_in_high_to_low() {

    }

    @When("user clicks on price low to high")
    public void user_clicks_on_price_low_to_high() {

    }

    @Then("verify user can get prices in low to high")
    public void verify_user_can_get_prices_in_low_to_high() {

    }

    @When("user selects the bike model {string}")
    public void user_selects_the_bike_model(String bikeModel) {

    }

    @Then("verify user can get all bikes as selected model")
    public void verify_user_can_get_all_bikes_as_selected_model() {

    }

    @When("user selects the bike location {string}")
    public void user_selects_the_bike_location(String bikeLocation) {

    }

    @Then("verify user can get all bikes as selected location")
    public void verify_user_can_get_all_bikes_as_selected_location() {

    }

    @When("user selects the bike model {string} and location {string}")
    public void user_selects_the_bike_model_and_location(String bikeModel, String bikeLocation) {

    }

    @Then("verify user can get all bikes as selected model and location")
    public void verify_user_can_get_all_bikes_as_selected_model_and_location() {

    }
}
