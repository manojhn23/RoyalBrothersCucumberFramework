package com.automation.steps;

import com.automation.utils.AndroidDriverManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebDriverManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initReader();
        if (ConfigReader.getConfigValue("test").equals("android")) {
            AndroidDriverManager.createDriver();
        } else {
            WebDriverManager.createDriver();
        }
        ReportManager.initReporter(scenario);
    }

    @After
    public void cleanUp() {
        if (ConfigReader.getConfigValue("test").equals("android")) {
            AndroidDriverManager.getDriver().quit();
        } else {
            WebDriverManager.getDriver().quit();
        }
    }
}
