package com.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/step_definitions",
        features = "src/test/recources/features",
        dryRun = false,
        tags = "@myaccount",
        publish = true,



        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }

)

public class CukesRunner {
}
