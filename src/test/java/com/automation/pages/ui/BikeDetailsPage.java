package com.automation.pages.ui;

public interface BikeDetailsPage {

    boolean isBikeDetailsPageDisplayed();

    void clicksHighToLowOption();

    boolean isPricesInHighToLow();

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

    abstract void clicksBookBtnOfFirstBike() ;
}
