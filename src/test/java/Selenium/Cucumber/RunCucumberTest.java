package Selenium.Cucumber;

import org.testng.*;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/resources/Selenium/Cucumber"},
		glue={"Selenium.Cucumber","TestBase"},
		plugin= {"pretty","html:target/htmlreport.html"})
public class RunCucumberTest extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
