package com.automation.pages.android;

import com.automation.utils.AndroidDriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    AppiumDriver driver;

    public BasePage() {
        driver = AndroidDriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}
