package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/java/feature/OpenCartSearch.feature",
	glue="stepDefinitions")
public class OpenCartSearchRunner extends AbstractTestNGCucumberTests  {}
