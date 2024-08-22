package com.automation.pages.ui;

public interface ReachUsPage {

    default boolean isReachUsPageDisplayed() {
        return false;
    }

    default void entersTheDetails(String s1, String s2, String s3, String s4) {}

    default void entersTheDetails(String s1, String s2, String s3) {}

    default void clicksSubmitBtn(){}

    default boolean isErrorMsgDisplayed(){
        return false;
    }

    default String getErrorMsg(){
        return null;
    }
}