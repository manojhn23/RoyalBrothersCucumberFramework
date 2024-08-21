package com.automation.pages.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    WebElement mayBeLaterOption;

    public void openApplication() {
        mayBeLaterOption.click();
    }
}
