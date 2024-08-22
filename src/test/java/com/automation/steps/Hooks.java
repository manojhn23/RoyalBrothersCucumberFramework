package com.automation.steps;

import com.automation.utils.AndroidDriverManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.ReportManager;
import com.automation.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initReader();
        ReportManager.initReporter(scenario);
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            WebDriverManager.createDriver();
        } else {
            AndroidDriverManager.createDriver();
        }
    }

    @After
    public void cleanUp() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            WebDriverManager.getDriver().quit();
        } else {
            AndroidDriverManager.getDriver().quit();
        }
    }
}
