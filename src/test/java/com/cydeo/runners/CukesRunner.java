package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {  "html:target/cucumber-report.html",
                    "rerun:target/rerun.txt"
        },

        features = "src/test/resources/features",
        // Right click-->Copy Path/Reference-->Path From Content Root
        // feature : where we pass feature files path

        glue = "com/cydeo/step_definitions",
        // Right click-->Copy Path/Reference-->Path From Source Root
        // glue : where we pass step_definitions path

        dryRun = false,
        // if false: If we already implement and everything is already ready in step definitions.
        // executing the step definitions

        // if true: It won't be running our step definitions codes /  not executing the step definitions
        // It will be running the snippets.
        // It will be giving us snippets from feature files that we did not implement yet.


        tags = "@femaleScientists"
        // or / and / and not ==> "@Regression and not @librarian"

)
public class CukesRunner {
}