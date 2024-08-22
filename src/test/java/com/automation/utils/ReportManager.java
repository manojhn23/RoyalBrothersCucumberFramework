package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportManager {

    static Scenario scenario;
    static TakesScreenshot ts;

    public static void initReporter(Scenario scenario) {
        ReportManager.scenario = scenario;
    }

    public static void attachScreenshot() {
        scenario.attach(takeScreenshot(), "image/png", "Screenshot");
    }

    private static byte[] takeScreenshot() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            ts = (TakesScreenshot) WebDriverManager.getDriver();
        } else {
            ts = AndroidDriverManager.getDriver();
        }
        return ts.getScreenshotAs(OutputType.BYTES);
    }
}
