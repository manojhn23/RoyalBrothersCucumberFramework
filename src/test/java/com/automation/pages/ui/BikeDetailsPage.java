package com.automation.pages.ui;

public interface BikeDetailsPage {

    boolean isBikeDetailsPageDisplayed();

    void clicksHighToLowOption();

    boolean isPricesInHighToLow();

    void clicksLowToHighOption();

    boolean isPricesInLowToHigh();

    void selectTheBikeModelFilter(String s);

    boolean isSelectedBikeModelsShown();

    void selectTheBikeLocationFilter(String s);

    boolean isSelectedBikeLocationShown();

    void selectBikeModelAndLocationFilter(String s1, String s2);

    boolean isSelectedFilterApplied();

    void clicksBookBtnOfFirstBike() ;
}
