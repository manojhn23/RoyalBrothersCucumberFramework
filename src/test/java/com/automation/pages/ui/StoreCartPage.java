package com.automation.pages.ui;

public interface StoreCartPage {

    default boolean isProductAddedSuccessFully(){
        return false;
    }

    default void removeProductFromCart(String s){}

    default boolean isProductRemovedSuccessFully(){
        return false;
    }

    default double calculateTotalAmount(){
        return 0;
    }

    default void clickOnCheckOutButton(){}


}
