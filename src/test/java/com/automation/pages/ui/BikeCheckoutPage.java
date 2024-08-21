package com.automation.pages.ui;

public interface BikeCheckoutPage {

    default boolean isMakePaymentOptionDisplayed(){
        return false;
    }

    default boolean isBikeCheckoutPageDisplayed(){
        return false;
    }
}
