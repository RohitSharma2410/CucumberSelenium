package Listeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Selenium.Cucumber.TestBase;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCaseStarted;

public class TestCaseStartedListener implements ConcurrentEventListener {

	

   

	@Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, 
        		event -> {
					try {
						handleTestCaseStarted(event);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
    }

    
	private void handleTestCaseStarted(TestCaseStarted testRun) throws Exception {

		
		TestBase.extentTest.set(TestBase.report.createTest(testRun.getTestCase().getName()));
		TestBase.extentTest.get().assignAuthor("Rohit Sharma");
		switch (TestBase.config.getProperty("browser").toString().toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
//			options.addArguments("--headless=new");
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
			TestBase.drivers.set(new ChromeDriver(options));
			break;
		case "firefox":
			FirefoxOptions foptions=new FirefoxOptions();
			foptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
			TestBase.drivers.set(new FirefoxDriver(foptions));
			break;
		}
		TestBase.drivers.set(new EventFiringClass().getDriver(TestBase.drivers.get()));
		TestBase.drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		TestBase.drivers.get().get(TestBase.config.getProperty("appurl").toString());
		TestBase.drivers.get().manage().window().maximize();
		TestBase.js.set((JavascriptExecutor) TestBase.drivers.get());
		TestBase.wait.set((new WebDriverWait(TestBase.drivers.get(), Duration.ofSeconds(30))));
        
    }

}