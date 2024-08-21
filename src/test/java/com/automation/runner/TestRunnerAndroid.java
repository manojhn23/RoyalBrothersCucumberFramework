package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/android",
        glue = "com.automation.steps.android",
        plugin = "json:target/android/cucumber.json"
)
public class TestRunnerAndroid {

}
