package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Then("verify user is on the login page")
    public void verify_user_is_on_the_login_page() {
        Assert.assertTrue(loginPage.isUserOnLoginPage());
    }

    @When("user enter valid phone number {string} and password {string}")
    public void user_enter_valid_phone_number_and_password(String phoneNo, String password) {
        loginPage.enterPhoneAndPasswordDetails(ConfigReader.getConfigValue(phoneNo), ConfigReader.getConfigValue(password));
    }

    @When("click on I'm not a robot checkbox")
    public void click_on_i_m_not_a_robot_checkbox() {
        loginPage.clickImNotARobotCheckBox();
    }

    @When("click on login with Password button")
    public void click_on_login_with_password_button() {
        loginPage.clickOnLoginWithPassword();
    }

    @When("user enter invalid phone number {string} and password {string}")
    public void userEnterInvalidPhoneNumberAndPassword(String phoneNumber, String password) {
    }

    @Then("verify error message is displayed {string}")
    public void verifyErrorMessageIsDisplayed(String errorMessage) {
    }
}
