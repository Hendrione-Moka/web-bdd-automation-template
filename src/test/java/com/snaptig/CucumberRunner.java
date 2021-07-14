package com.snaptig;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    publish = true,
    stepNotifications = true,
    glue = {"com.snaptig"},
    plugin = {"json:build/cucumber.json", "pretty", "html:build/result.html"},
    features = "src/test/resources/features",
    tags = "@AddQuote1 and @smoke1")
public class CucumberRunner {

}
