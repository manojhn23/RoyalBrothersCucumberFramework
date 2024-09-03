package com.automation.steps;

import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.LoginPage;
import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            loginPage = new WebLoginPage();
        } else {
            loginPage = new AndroidLoginPage();
        }
    }

    @Then("verify user is on the login page")
    public void verify_user_is_on_the_login_page() {
        Assert.assertTrue(loginPage.isUserOnLoginPage());
        ReportManager.attachScreenshot();
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
        loginPage.enterPhoneAndPasswordDetails(phoneNumber, password);
    }

    @Then("verify error message is displayed {string}")
    public void verifyErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(loginPage.errorMessage(), ConfigReader.getConfigValue(errorMessage));
        ReportManager.attachScreenshot();
    }

    @When("user selects the country {string} with code {string}")
    public void userSelectsTheCountryWithCode(String countryName, String code) {
        loginPage.enterCountryCode(countryName, code);
    }

    @And("user enter valid phone number {string}")
    public void userEnterValidPhoneNumber(String phoneNumber) {
        loginPage.enterPhoneNumber(ConfigReader.getConfigValue(phoneNumber));
    }

    @And("click on get otp option")
    public void clickOnGetOtpOption() {
        loginPage.clickOnGetOtp();
    }

    @And("user enter invalid phone number {string}")
    public void userEnterInvalidPhoneNumber(String invalidPhoneNumber) {
        loginPage.enterPhoneNumber(invalidPhoneNumber);
    }

    @Then("the user should be redirected to the OTP details page")
    public void theUserShouldBeRedirectedToTheOTPDetailsPage() {
        Assert.assertTrue(loginPage.isUserOnOtpDetailsPage());
        ReportManager.attachScreenshot();
    }

    @When("user enter otp and click on submit button")
    public void userEnterOtpAndClickOnSubmitButton() {
        loginPage.enterOtpAndClickOnSubmit();
    }


}
