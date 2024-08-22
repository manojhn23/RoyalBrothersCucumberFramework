package com.automation.pages.ui;

public interface BikeDetailsPage {

    default boolean isBikeDetailsPageDisplayed() {
        return false;
    }

    default void clicksHighToLowOption() {
    }

    default boolean isPricesInHighToLow() {
        return false;
    }

    default void clicksLowToHighOption() {
    }

    default boolean isPricesInLowToHigh() {
        return false;
    }

    default void selectTheBikeModelFilter(String s) {
    }

    default boolean isSelectedBikeModelsShown() {
        return false;
    }

    default void selectTheBikeLocationFilter(String s) {
    }

    default boolean isSelectedBikeLocationShown() {
        return false;
    }

    default void selectBikeModelAndLocationFilter(String s1, String s2) {
    }

    default boolean isSelectedFilterApplied() {
        return false;
    }

    default void clicksBookBtnOfFirstBike() {
    }
}
