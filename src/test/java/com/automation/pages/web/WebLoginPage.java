package com.automation.pages.web;

import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebLoginPage extends WebBasePage implements LoginPage {

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

    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    WebElement captchaChecked;

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
        driver.switchTo().frame(1);
        wait.until(ExpectedConditions.attributeToBe(captchaChecked, "aria-checked", "true"));
        driver.switchTo().defaultContent();
        click(loginWithPasswordButton);
    }

    public String errorMessage() {
        System.out.println(invalidDetailsErrorMessage.getText());
        return invalidDetailsErrorMessage.getText();
    }
}
