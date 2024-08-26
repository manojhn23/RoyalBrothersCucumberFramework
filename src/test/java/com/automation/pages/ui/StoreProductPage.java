package com.automation.pages.ui;

public interface StoreProductPage {

    void addProductsToTheCart(String s1, String s2);

    void sortProductBy(String sortOption);

    boolean isProductSortedFromPriceLowToHigh();

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
