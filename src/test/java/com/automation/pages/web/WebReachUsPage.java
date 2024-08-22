package com.automation.pages.web;

import com.automation.pages.ui.ReachUsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebReachUsPage extends WebBasePage implements ReachUsPage {

    @FindBy(xpath = "//h1[text()='Reach Us']")
    WebElement reachUsPageHeader;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "phone")
    WebElement mobileInput;

    @FindBy(id = "message")
    WebElement commentInput;

    @FindBy(xpath = "//button[@name='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[contains(@class,'toast')]")
    WebElement errorMsg;

    @Override
    public boolean isReachUsPageDisplayed() {
        return reachUsPageHeader.isDisplayed();
    }

    @Override
    public void entersTheDetails(String name, String email, String mobile, String comment) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        mobileInput.sendKeys(mobile);
        commentInput.sendKeys(comment);
    }

    @Override
    public void entersTheDetails(String name, String email, String mobile) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        mobileInput.sendKeys(mobile);
    }

    @Override
    public void clicksSubmitBtn() {
        click(submitBtn);
    }

    @Override
    public boolean isErrorMsgDisplayed() {
        return errorMsg.isDisplayed();
    }

    @Override
    public String getErrorMsg() {
        return errorMsg.getText();
    }
}
