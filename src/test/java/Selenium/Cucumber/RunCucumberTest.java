package Selenium.Cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/Selenium/Cucumber" },
glue = { "Selenium.Cucumber","TestBase" })
public class RunCucumberTest extends AbstractTestNGCucumberTests {
	public static int totalThreads = -1;
StepDefinitions.staticMethod();
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	
}
