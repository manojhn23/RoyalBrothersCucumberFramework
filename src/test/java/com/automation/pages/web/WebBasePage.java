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
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        executor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            executor.executeScript("arguments[0].click();", element);
        }
    }

    protected void pause(int seconds) {
        actions.pause(Duration.ofSeconds(seconds)).build().perform();
    }

    protected boolean isDisplayed(WebElement ele) {
        try {
            setImplicitWait(0);
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    protected void setImplicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    protected boolean isDisplayed(String xpath, String value) {
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

    protected void moveToElement(WebElement ele) {
        actions.moveToElement(ele).build().perform();
    }

    protected void waitTillClickable(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    protected void waitTillVisible(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    protected void selectDate(WebElement nextBtn, String xpath, String value) {
        WebElement element;
        try {
            setImplicitWait(2);
            element = driver.findElement(By.xpath(String.format(xpath, value)));
            click(element);
        } catch (Exception e) {
            click(nextBtn);
            selectDate(nextBtn, xpath, value);
        } finally {
            setImplicitWait(60);
        }
    }

}
