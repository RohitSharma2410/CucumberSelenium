package Selenium.Cucumber;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilsClasses.EventFiringClass;
import utilsClasses.MailerClass;
import utilsClasses.PropertiesFIlesHelper;

public class TestBase {
	public static PropertiesFIlesHelper pageObjects=null;
	public static PropertiesFIlesHelper config=null;
	public static ThreadLocal<WebDriver> drivers=null;
	public static ThreadLocal<WebDriverWait> wait=null;
	public static ThreadLocal<JavascriptExecutor> js=null;

	@BeforeAll
	public static void before_or_after_all() {
		if(pageObjects==null) {
			pageObjects = new PropertiesFIlesHelper(
					System.getProperty("user.dir").
					concat("/src/main/resources/" +
					"pageObjects.properties"));
					

			config = new PropertiesFIlesHelper(
					System.getProperty("user.dir").
					concat("/src/main/resources/" + 
					"config.properties"));
					
			}
		drivers=new ThreadLocal<>();
		js=new ThreadLocal<>();
		wait=new ThreadLocal<>();
		
	}
	
	
	
@Before
	public void before_or_after(Scenario test) {
	
		switch (config.getProperty("browser").
				toString().toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			drivers.set(new ChromeDriver(options));
			break;
		case "firefox":
			drivers.set(new FirefoxDriver());
			break;
		}
		drivers.set(new EventFiringClass().getDriver(drivers.get()));
		drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		drivers.get().get(config.getProperty("appurl").toString());
		drivers.get().manage().window().maximize();
		js.set((JavascriptExecutor)drivers.get());
	 wait.set((new WebDriverWait(drivers.get(), Duration.ofSeconds(30))));
	}

@After
public void after(Scenario test) {
	
	if(test.isFailed()) {
		byte[] js=((TakesScreenshot)drivers.get()).getScreenshotAs(OutputType.BYTES);
		test.attach(js, "image/png", test.getName());
		

	}
	drivers.get().close();


}

@AfterAll
public static void afterall() {	
//MailerClass.prepareEmail();
}
	
public static WebElement getElement(By locator) {
	
	return drivers.get().findElement(locator);
}

public static WebElement getElement(String locator) {
	String locatortype=pageObjects.getProperty(locator).toString().split("@@@")[0];
	switch(locatortype) {
	case "xpath":
		
		return drivers.get().findElement(By.xpath
				(pageObjects.getProperty(locator).toString().split("@@@")[1]));
		
	 default:
		
		 return drivers.get().findElement(By.xpath
					(pageObjects.getProperty(locator).toString().split("@@@")[1]));
	}
	
}
public static WebElement getElementOnElement(String locator,WebElement element) {
	String locatortype=pageObjects.getProperty(locator).toString().split("@@@")[0];
	switch(locatortype) {
	case "xpath":
		return element.findElement(By.xpath
				(pageObjects.getProperty(locator).toString().split("@@@")[1]));
		
	 default:
System.out.println();
		 return element.findElement(By.xpath
					(pageObjects.getProperty(locator).toString().split("@@@")[1]));
	}
	
}


public static WebElement getElementWithUpdatedValue(String locator,String valueToReplace,String valueByReplace) {
	String locatortype=pageObjects.getProperty(locator).toString().split("@@@")[0];
	switch(locatortype) {
	case "xpath":
		if(valueToReplace!=null) {
			return drivers.get().findElement(By.xpath
					(pageObjects.getProperty(locator).toString().split("@@@")[1].replace(valueToReplace, valueByReplace)));
		}
		return drivers.get().findElement(By.xpath
				(pageObjects.getProperty(locator).toString().split("@@@")[1]));
		
	 default:
		 if(valueToReplace!=null) {
				return drivers.get().findElement(By.xpath
						(pageObjects.getProperty(locator).toString().split("@@@")[1].replace(valueToReplace, valueByReplace)));
			}
		 return drivers.get().findElement(By.xpath
					(pageObjects.getProperty(locator).toString().split("@@@")[1]));
	}
	
}
}
