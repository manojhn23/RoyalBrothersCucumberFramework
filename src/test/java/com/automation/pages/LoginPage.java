package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[text()='Login with Password']")
    WebElement loginWithPasswordButton;

    @FindBy(id = "phone_no")
    WebElement phoneNumber;

    @FindBy(id = "session_password")
    WebElement password;

    @FindBy(id = "whatsAppLoginCheckBox")
    WebElement whatsAppLoginCheck;

    @FindBy(xpath = "//span[@id='recaptcha-anchor']/div[1]")
    WebElement captchaCheckBox;

    public boolean isUserOnLoginPage() {
        return loginWithPasswordButton.isDisplayed();
    }

    public void enterPhoneAndPasswordDetails(String phone, String pass) {
        phoneNumber.sendKeys(phone);
        password.sendKeys(pass);
//        whatsAppLoginCheck.click();
    }

    public void clickImNotARobotCheckBox() {
        captchaCheckBox.click();
    }

    public void clickOnLoginWithPassword() {
        loginWithPasswordButton.click();
    }
}
