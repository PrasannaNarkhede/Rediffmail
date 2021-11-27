package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features=".//Features//First.feature",
                  glue="stepDefs",
                  dryRun =true, 
                  monochrome = true,
                  publish= true,
                  plugin = {"pretty","html:target/first.html"}) 


public class TestRunner {

}
