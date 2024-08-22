package com.automation.pages.ui;

public interface StorePage {

    default boolean isUserOnStorePage() {
        return false;
    }

    default void selectProductCategory(String s) {
    }

}
