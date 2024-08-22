package com.automation.pages.ui;

public interface OrderSummaryPage {

    default boolean isUserOnOrderSummaryPage() {
        return false;
    }

    default boolean validateTotalAmount() {
        return false;
    }
}
