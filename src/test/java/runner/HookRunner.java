package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features//Cucumberhooks.feature",
			glue= {"stepDefs"},
			dryRun=false,
			monochrome=true,
			stepNotifications=true,
			publish=true,
			plugin= {"pretty","html:target/Cucumberhooks.html"})

public class HookRunner {

}
