package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(features=".//Features//Parameter.feature",
								glue="stepDefs",
								dryRun=false,
								monochrome=true,
								publish=true,
								plugin= {"pretty","html:target/parameter.html"})
public class ParameterRunner {
}
