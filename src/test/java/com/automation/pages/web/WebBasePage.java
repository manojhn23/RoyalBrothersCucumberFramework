package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WebBasePage {

    WebDriver driver;

    WebDriverWait wait;
    JavascriptExecutor executor;
    Actions actions;

    public WebBasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        executor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            executor.executeScript("arguments[0].click();", element);
        }
    }

    public void pause(int seconds) {
        actions.pause(Duration.ofSeconds(seconds)).build().perform();
    }

    public boolean isDisplayed(WebElement ele) {
        try {
            setImplicitWait(0);
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    public void setImplicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public boolean isDisplayed(String xpath, String value) {
        try {
            setImplicitWait(0);
            WebElement ele = driver.findElement(By.xpath(String.format(xpath, value)));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    public void moveToElement(WebElement ele) {
        actions.moveToElement(ele).build().perform();
    }

    public void waitTillClickable(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waitTillVisible(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


}
