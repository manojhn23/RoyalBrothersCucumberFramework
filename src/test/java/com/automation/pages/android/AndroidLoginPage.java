package com.automation.pages.android;

import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.EditText[@text='Enter Your Phone Number']")
    WebElement enterPhoneNumberInput;

    @FindBy(xpath = "//android.widget.TextView[@text='GET OTP']")
    WebElement getOtp;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement enterCountryNameInputField;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter Your Phone Number\"]/../android.view.ViewGroup[1]")
    WebElement selectCountryCode;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Please Provide Valid Phone\"]")
    WebElement errorMsg;

    String countryNamePath = "//android.widget.TextView[@text='%s']";
    String countryCodeXpath = "//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.TextView[@text=\"VERIFY DETAILS\"]")
    WebElement verifyDetails;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SUBMIT\"]")
    WebElement submitButton;

    @Override
    public boolean isUserOnLoginPage() {
        return enterPhoneNumberInput.isDisplayed() && getOtp.isDisplayed();
    }

    @Override
    public void enterCountryCode(String countryName, String countryCode) {
        selectCountryCode.click();
        pause(2);
        enterCountryNameInputField.sendKeys(countryName);
        WebElement name = driver.findElement(By.xpath(String.format(countryNamePath, countryName)));
        WebElement code = driver.findElement(By.xpath(String.format(countryCodeXpath, countryCode)));

        System.out.println(name.getText());
        System.out.println(code.getText());
        if (name.getText().equals(countryName) && code.getText().equals(countryCode)) {
            System.out.println(name.getText() + " " + code.getText());
            name.click();
        }
    }

    @Override
    public void enterPhoneNumber(String phoneNumber) {
        enterPhoneNumberInput.sendKeys(phoneNumber);
    }

    @Override
    public void clickOnGetOtp() {
        getOtp.click();
    }

    @Override
    public String errorMessage() {
        System.out.println(errorMsg.getText());
        return errorMsg.getText();
    }

    @Override
    public boolean isUserOnOtpDetailsPage() {
        return verifyDetails.isDisplayed();
    }

    @Override
    public void enterOtpAndClickOnSubmit() {
        pause(20);
        submitButton.click();
    }
}
