package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
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


}
