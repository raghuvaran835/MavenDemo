package runnerPackage;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/ajio.feature"
				,glue="stepDefinition"
				,dryRun=false
				,plugin={"html:target/cucumber-report.html/"}
				//,monochrome = true--->this for color
		)
public class TestRunner {

}
