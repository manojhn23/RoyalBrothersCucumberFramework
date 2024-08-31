package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.steps",
        plugin = {"json:target/Web/cucumber.json", "html:target/Web/basic_web_report.html"},
        tags = "@web"
)
public class TestRunnerWeb {

}
