package com.automation.pages.ui;

public interface LoginPage {

    abstract boolean isUserOnLoginPage();

    default void enterPhoneAndPasswordDetails(String s1, String s2) {
    }

    default void clickImNotARobotCheckBox() {
    }

    default void clickOnLoginWithPassword() {
    }

    default String errorMessage() {
        return null;
    }
}