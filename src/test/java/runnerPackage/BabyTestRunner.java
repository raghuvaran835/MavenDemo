package runnerPackage;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/baby.feature"
				,glue="stepDefinition1"
				,dryRun=false
				,plugin={"html:target/cucumber-report.html/"}
		)

public class BabyTestRunner {
	

}
