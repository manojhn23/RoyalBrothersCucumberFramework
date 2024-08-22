package com.automation.pages.ui;

import java.util.List;

public interface InterCityTravelPage {

    default boolean isInterCityTravelPageDisplayed() {
        return false;
    }

    default void entersDetailsForRide(List<String> list) {
    }

    default void clicksOnSearchButton() {
    }
}
