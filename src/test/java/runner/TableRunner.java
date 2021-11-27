package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".//Features//LoginDataTable.feature",
							glue="stepDefs",
							dryRun=false,
							monochrome=true,
							publish=true,
							plugin= {"pretty","html:target/LoginDataTable.html"})
public class TableRunner {

}