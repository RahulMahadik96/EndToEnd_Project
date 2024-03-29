package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/feature/Login.feature",
	glue="stepDefinitions",
	stepNotifications = true)
public class TestRunner {}
