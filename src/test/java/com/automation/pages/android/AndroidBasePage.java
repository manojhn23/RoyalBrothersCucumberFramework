package com.automation.pages.android;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public abstract class AndroidBasePage {

    AppiumDriver driver;

    public AndroidBasePage() {
        driver = (AppiumDriver) DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isPresent(WebElement element) {
        try {
            setImplicitWait(2);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public void setImplicitWait(long sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public void pause(long sec) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(sec)).build().perform();
    }

    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void scrollPage() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width / 2, height / 2))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), width / 2, 0))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void scrollPageDown() {
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), width / 2, height / 2))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), width / 2, height))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void scroll(WebElement element) {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x + width / 2, y + height / 2))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), x + width / 2, y))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public boolean isDisplayed(String xpath, String value) {
        try {
            setImplicitWait(2);
            WebElement ele = driver.findElement(By.xpath(String.format(xpath, value)));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    public boolean isDisplayed(String xpath) {
        try {
            setImplicitWait(2);
            WebElement ele = driver.findElement(By.xpath(xpath));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }
}
