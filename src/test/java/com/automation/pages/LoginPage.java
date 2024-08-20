package com.automation.pages;

import org.openqa.selenium.By;
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

    @FindBy(id = "recaptcha-anchor")
    WebElement captchaCheckBox;

    @FindBy(id = "rc-imageselect")
    WebElement verifyCaptchaImage;

    @FindBy(xpath = "//div[@id='toast-container']/div")
    WebElement invalidDetailsErrorMessage;

    public boolean isUserOnLoginPage() {
        return loginWithPasswordButton.isDisplayed();
    }

    public void enterPhoneAndPasswordDetails(String phone, String pass) {
        phoneNumber.sendKeys(phone);
        password.sendKeys(pass);
    }

    public void clickImNotARobotCheckBox() {
        driver.switchTo().frame(1);
        captchaCheckBox.click();
        driver.switchTo().defaultContent();
    }

    public void clickOnLoginWithPassword() {
        pause(5);
        driver.switchTo().frame(4);
        if (isDisplayed(verifyCaptchaImage)) {
            pause(60);
        }
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(loginWithPasswordButton));
        click(loginWithPasswordButton);
    }

    public String errorMessage() {
        System.out.println(invalidDetailsErrorMessage.getText());
        return invalidDetailsErrorMessage.getText();
    }
}
