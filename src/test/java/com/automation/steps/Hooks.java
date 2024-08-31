package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initReader();
        ConfigReader.setConfigValue("application.type", System.getProperty("env"));
        ReportManager.initReporter(scenario);
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()){
            ReportManager.attachScreenshot();
        }
        DriverManager.getDriver().quit();
    }
}
