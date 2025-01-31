package Selenium.Cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/Selenium/Cucumber" }, glue = { "Selenium.Cucumber",
		"Selenium.Cucumber.TestBase" },tags= "@Hookup",plugin = {  "json:target/cucumber-reports/Cucumber.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"Listeners.CucumberEventListener","Listeners.TestStepFinishedListener",
				"Listeners.TestCaseFinishedListener"})
public class RunCucumberTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
