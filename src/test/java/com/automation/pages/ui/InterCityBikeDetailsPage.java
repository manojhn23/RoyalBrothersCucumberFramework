package com.automation.pages.ui;

public interface InterCityBikeDetailsPage {

    default boolean isBikeDetailsPageDisplayed() {
        return false;
    }

    default void clicksOnRequestBookingBtn() {
    }

    default boolean isConfirmRequestBtnDisplayed() {
        return false;
    }
}
