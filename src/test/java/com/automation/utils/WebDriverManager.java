package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class WebDriverManager {

    static WebDriver driver;

    public static void createDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
