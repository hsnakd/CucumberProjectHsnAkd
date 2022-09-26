package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber-report.html",
        features = "src/test/resources/features", // Right click-->Copy Path/Reference-->Path From Content Root
        glue = "com/cydeo/step_definitions",      // Right click-->Copy Path/Reference-->Path From Source Root
        dryRun = false,
        tags = "@employee and not @librarian"     // or / and / and not

)
public class CukesRunner {
}