package com.automation.pages.android;

import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.EditText[@text='Enter Your Phone Number']")
    WebElement enterPhoneNumber;

    @FindBy(xpath = "//android.widget.TextView[@text='GET OTP']")
    WebElement getOtp;

    @Override
    public boolean isUserOnLoginPage() {
        return enterPhoneNumber.isDisplayed() && getOtp.isDisplayed();
    }
}
