package com.nbc.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/nbc/step_definitions",
        dryRun= false,
        tags =  "@vytrackLogin",
        publish = true // generating a report with public link

)
public class CukesRunner {

}
