package com.automation.pages.ui;

public interface StoreCartPage {

    boolean isProductAddedSuccessFully();

    void removeProductFromCart(String productName);

    boolean isProductRemovedSuccessFully();

    default double calculateTotalAmount() {
        return 0;
    }

    void clickOnCheckOutButton();


}
