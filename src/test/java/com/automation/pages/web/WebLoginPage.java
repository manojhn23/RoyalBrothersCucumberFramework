package com.automation.pages.web;

import com.automation.pages.ui.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @Override
    public boolean isUserOnLoginPage() {
        return loginWithPasswordButton.isDisplayed();
    }

    @Override
    public void enterPhoneAndPasswordDetails(String phone, String pass) {
        phoneNumber.sendKeys(phone);
        password.sendKeys(pass);
    }

    @Override
    public void clickImNotARobotCheckBox() {
        driver.switchTo().frame(1);
        captchaCheckBox.click();
        driver.switchTo().defaultContent();
    }

    @Override
    public void clickOnLoginWithPassword() {
        pause(4);
        driver.switchTo().frame(1);
        System.out.println(captchaChecked.getAttribute("aria-checked"));
        wait.until(ExpectedConditions.attributeToBe(captchaChecked, "aria-checked", "true"));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(loginWithPasswordButton));
        click(loginWithPasswordButton);
    }

    @Override
    public String errorMessage() {
        System.out.println(invalidDetailsErrorMessage.getText());
        return invalidDetailsErrorMessage.getText();
    }
}
