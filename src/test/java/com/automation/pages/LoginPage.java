package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[text()='Login with Password']")
    WebElement loginWithPasswordButton;

    @FindBy(id = "phone_no")
    WebElement phoneNumber;

    @FindBy(id = "session_password")
    WebElement password;

    @FindBy(id = "whatsAppLoginCheckBox")
    WebElement whatsAppLoginCheck;

    @FindBy(id = "recaptcha-anchor")
    WebElement captchaCheckBox;

    @FindBy(id = "rc-imageselect")
    WebElement verifyCaptchaImage;

    public boolean isUserOnLoginPage() {
        return loginWithPasswordButton.isDisplayed();
    }

    public void enterPhoneAndPasswordDetails(String phone, String pass) {
        phoneNumber.sendKeys(phone);
        password.sendKeys(pass);
//        whatsAppLoginCheck.click();
    }

    public void clickImNotARobotCheckBox() {
        driver.switchTo().frame(1);
        captchaCheckBox.click();
        driver.switchTo().defaultContent();
    }

    public void clickOnLoginWithPassword() {
//        pause(3);
//        if (verifyCaptchaImage.isDisplayed()) {
//            pause(60);
//        }
        pause(10);
        wait.until(ExpectedConditions.elementToBeClickable(loginWithPasswordButton));
        click(loginWithPasswordButton);
    }
}
