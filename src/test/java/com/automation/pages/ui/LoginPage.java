package com.automation.pages.ui;

public interface LoginPage {

    boolean isUserOnLoginPage();

    default void enterPhoneAndPasswordDetails(String s1, String s2) {
    }

    default void clickImNotARobotCheckBox() {
    }

    default void clickOnLoginWithPassword() {
    }

    String errorMessage();

    default void enterCountryCode(String countryName, String code) {

    }

    default void enterPhoneNumber(String configValue) {

    }

    default void clickOnGetOtp() {

    }

    default boolean isUserOnOtpDetailsPage() {
        return false;
    }

    default void enterOtpAndClickOnSubmit() {
    }
}