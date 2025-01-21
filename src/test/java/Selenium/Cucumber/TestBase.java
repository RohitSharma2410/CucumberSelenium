package Selenium.Cucumber;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig.ExtentSparkReporterConfigBuilder;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewConfigurer;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilsClasses.EventFiringClass;
import utilsClasses.PropertiesFIlesHelper;

public class TestBase {
	public static PropertiesFIlesHelper pageObjects = null;
	public static PropertiesFIlesHelper config = null;
	public static ThreadLocal<WebDriver> drivers = null;
	public static ThreadLocal<WebDriverWait> wait = null;
	public static ThreadLocal<JavascriptExecutor> js = null;
	public static ThreadLocal<ExtentTest> extentTest = null;
	public static ExtentReports report = null;

	@BeforeAll
	public static void before_or_after_all() throws IOException {
		if (pageObjects == null) {
			pageObjects = new PropertiesFIlesHelper(
					System.getProperty("user.dir").concat("/src/main/resources/" 
			+ "pageObjects.properties"));

			config = new PropertiesFIlesHelper(
					System.getProperty("user.dir").concat("/src/main/resources/" 
			+ "config.properties"));

		}
		drivers = new ThreadLocal<>();
		js = new ThreadLocal<>();
		wait = new ThreadLocal<>();
		extentTest = new ThreadLocal<>();
		report = new ExtentReports();

		ExtentSparkReporter rs = new ExtentSparkReporter(
				"/Users/rohitsharma" + "/eclipse-workspace/CucumberSelenium/target/SparkReport.html");
		
		
		rs.loadXMLConfig(new File("/Users/rohitsharma/eclipse-workspace"
				+ "/CucumberSelenium/src/main/resources/extent.xml"));
		report.attachReporter(rs);
	}

	@Before
	public void before_or_after(Scenario test) {
		extentTest.set(report.createTest(test.getName()));
		extentTest.get().assignAuthor("Rohit Sharma");
		switch (config.getProperty("browser").toString().toLowerCase()) {
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
		js.set((JavascriptExecutor) drivers.get());
		wait.set((new WebDriverWait(drivers.get(), Duration.ofSeconds(30))));
	}

	@After
	public void after(Scenario test) throws IOException {

		if (test.isFailed()) {
			byte[] js = ((TakesScreenshot) drivers.get()).getScreenshotAs(OutputType.BYTES);
			test.attach(js, "image/png", test.getName());

			TakesScreenshot ts = (TakesScreenshot) drivers.get();
			File file = new File("/screenshots/test.png");
			FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), file);
			extentTest.get().addScreenCaptureFromPath(file.getAbsolutePath());

		}
		drivers.get().close();

	}

	@AfterAll
	public static void afterall() {
//MailerClass.prepareEmail();
		report.flush();
	}

	public static WebElement getElement(By locator) {

		return drivers.get().findElement(locator);
	}

	public static WebElement getElement(String locator) {
		String locatortype = pageObjects.getProperty(locator).toString().split("@@@")[0];
		switch (locatortype) {
		case "xpath":

			return drivers.get().findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]));

		default:

			return drivers.get().findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]));
		}

	}

	public static WebElement getElementOnElement(String locator, WebElement element) {
		String locatortype = pageObjects.getProperty(locator).toString().split("@@@")[0];
		switch (locatortype) {
		case "xpath":
			return element.findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]));

		default:
			System.out.println("change from master");
			return element.findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]));
		}

	}

	public static WebElement getElementWithUpdatedValue(String locator, String valueToReplace, String valueByReplace) {
		String locatortype = pageObjects.getProperty(locator).toString().split("@@@")[0];
		switch (locatortype) {
		case "xpath":
			if (valueToReplace != null) {
				return drivers.get().findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]
						.replace(valueToReplace, valueByReplace)));
			}
			return drivers.get().findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]));

		default:
			if (valueToReplace != null) {
				return drivers.get().findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]
						.replace(valueToReplace, valueByReplace)));
			}
			return drivers.get().findElement(By.xpath(pageObjects.getProperty(locator).toString().split("@@@")[1]));
		}

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sdfdsfxcsfdsfdfsfxcsdfs.com");
		System.out.println(driver.getPageSource());
		driver.get("https://practice.expandtesting.com");
		System.out.println(driver.getPageSource());
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("(//*[@id=\"examples\"]//a)[2]"))).build().perform();
		driver.findElement(By.xpath("(//*[@id=\"examples\"]//a)[2]")).click();
		actions.moveToElement(driver.findElement(By.xpath("//input[@id=\"username\"]"))).build().perform();

		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("practice");
		actions.moveToElement(driver.findElement(By.xpath("//input[@id=\"password\"]"))).build().perform();

		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("SuperSecretPassword!");
		actions.moveToElement(driver.findElement(By.xpath("//button[@type=\"submit\"]"))).build().perform();

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		// Thread.sleep(5000);
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie co : cookies) {
			System.out.println("Cookie is " + co.getName());
		}
		driver.close();
		driver = new ChromeDriver();
		actions = new Actions(driver);
		driver.get("https://practice.expandtesting.com");
		for (Cookie c : cookies) {
			driver.manage().addCookie(c);
		}
		actions.moveToElement(driver.findElement(By.xpath("(//*[@id=\"examples\"]//a)[2]"))).build().perform();

		driver.findElement(By.xpath("(//*[@id=\"examples\"]//a)[2]")).click();
		actions.moveToElement(driver.findElement(By.xpath("//button[@type=\"submit\"]"))).build().perform();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	}

}
