package Selenium.Cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/Selenium/Cucumber" }, glue = { "Selenium.Cucumber",
		"Selenium.Cucumber.TestBase" },tags= "@Hookup",plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" })
public class RunCucumberTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
