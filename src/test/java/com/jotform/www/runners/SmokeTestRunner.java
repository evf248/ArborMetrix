package com.jotform.www.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"com.jotform.www.steps"},
        tags = {"@studentRegForm"}
//        dryRun = true
)
public class SmokeTestRunner {}
