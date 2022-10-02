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
        // true: It won't be running our step definitions codes.
        // It will be running the snippets.
        // It will be giving us snippets from feature files that we did not implement yet.
        // false: If we already implement and everything is already ready in step definitions.

        tags = "@Regression"
        // or / and / and not ==> "@Regression and not @librarian"

)
public class CukesRunner {
}