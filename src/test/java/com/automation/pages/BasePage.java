package com.automation.pages;

import com.automation.utils.DriverManager;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void pause(int seconds) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(seconds)).build().perform();
    }

    public boolean isDisplayed(WebElement ele){
        try {
            return ele.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
