package com.automation.pages.ui;

public interface HomePage {

    default void openWebsite() {
    }

    default void selectCity(String cityName) {
    }

    boolean isUserOnHomePage();

    default boolean verifyCitySelected() {
        return false;
    }

    default void clickOnLoginButton() {
    }

    default void clicksOnLocationOption() {
    }

    default void entersLocationName(String s) {
    }

    default void clicksOnEnteredLocation() {
    }

    default boolean isSelectedLocationDisplayed() {
        return false;
    }

    default boolean isSelectedLocationNotDisplayed() {
        return false;
    }

    default void clicksClearOnLocationSearch() {
    }

    boolean isInputFieldNull();

    void entersDetailsForRide(String s1, String s2, String s3, String s4);

    void clicksOnSearchBtn();

    default void clickOnHamburgerMenu() {
    }

    void selectMenuOption(String menuOption);

    default void clickOnProfile() {
    }

    default void clickOnLogoutOption() {
    }

    default boolean isLogOutSuccessFull() {
        return false;
    }

    default boolean isCitySelectionDisplayed() {
        return false;
    }

    default boolean isLoginSuccessFul() {
        return false;
    }

    void openApplication();

    default String getLocationInputText() {
        return null;
    }
}