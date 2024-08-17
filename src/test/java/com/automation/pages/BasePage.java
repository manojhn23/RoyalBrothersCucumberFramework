package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;

    WebDriverWait wait;
    JavascriptExecutor executor;

    public BasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        executor.executeScript("arguments[0].click();", element);
    }

    public void pause(int seconds) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(seconds)).build().perform();
    }

}
