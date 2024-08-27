package com.automation.pages.ui;

public interface StoreProductPage {

    void addProductsToTheCart(String s1, String s2);

    void sortProductBy(String sortOption);

    boolean isProductSortedFromPriceLowToHigh();

     boolean isProductSortedFromPriceHighToLow();

     boolean isProductSortedFromAtoZ();

     boolean isProductSortedFromZtoA() ;

}
