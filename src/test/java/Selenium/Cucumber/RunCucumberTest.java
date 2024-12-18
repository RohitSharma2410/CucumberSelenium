package Selenium.Cucumber;

import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import utilsClasses.MailerClass;

@CucumberOptions(features={"src/test/resources/Selenium/Cucumber"},
		glue={"Selenium.Cucumber","TestBase"},
		plugin= {"html:target/htmlreport.html","json:target/jsonreport.json"})
public class RunCucumberTest extends AbstractTestNGCucumberTests{
public static int totalThreads=-1;
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
	
}
