package com.automation.pages.ui;

public interface StoreProductPage {

    default void addProductsToTheCart(String s1, String s2) {
    }

    default void sortProductBy(String s) {
    }

    default boolean isProductSortedFromPriceLowToHigh() {
        return false;
    }

    default boolean isProductSortedFromPriceHighToLow() {
        return false;
    }

    default boolean isProductSortedFromAtoZ() {
        return false;
    }

    default boolean isProductSortedFromZtoA() {
        return false;
    }

}
