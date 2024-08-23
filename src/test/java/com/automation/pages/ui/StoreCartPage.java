package com.automation.pages.ui;

public interface StoreCartPage {

    abstract boolean isProductAddedSuccessFully() ;

    abstract void removeProductFromCart(String productName) ;

    abstract boolean isProductRemovedSuccessFully();

    default double calculateTotalAmount() {
        return 0;
    }

    abstract void clickOnCheckOutButton();


}
