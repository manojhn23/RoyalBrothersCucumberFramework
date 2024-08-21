package com.automation.steps.web;

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
        DriverManager.createDriver();
        ReportManager.initReporter(scenario);
    }

    @After
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }
}
