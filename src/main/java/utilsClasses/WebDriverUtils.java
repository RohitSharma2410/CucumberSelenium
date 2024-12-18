package utilsClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtils {

	

	public static WebElement returnElementAfterWaitCheck(WebDriver driver,String locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		By by=returnBy(locator);
		try {
			element = driver.findElement(by);
			return element;
		} catch (Exception e) {
			if (e.getClass() == NoSuchElementException.class) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				return driver.findElement(by);
			}
		}
		return element;
	}
	
	public static List<WebElement> returnElementsAfterWaitCheck(WebDriver driver,String locator) {
		List<WebElement> elements = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		By by=returnBy(locator);
		try {
			elements = driver.findElements(by);
			return elements;
		} catch (Exception e) {
			if (e.getClass() == NoSuchElementException.class) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				return driver.findElements(by);
			}
		}
		return elements;
	}
	
	private static By returnBy(String locator) {
		if(locator.split("@@@")[0].equalsIgnoreCase("xpath")) {
			return By.xpath(locator.split("@@@")[1]);
		}
		return null;
	}

	public static void clickOnElement(WebDriver driver,String locator) {
		try {
			returnElementAfterWaitCheck(driver,locator).click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", driver.findElement(returnBy(locator)));
		}

	}
	public static void focus(WebDriver driver,WebElement locator) {
	
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", locator);
		

	}

	public static WebElement findElementInFrames(WebDriver driver,By by) {
		List<WebElement> frames = driver.findElements(By.xpath("//frames"));
		WebElement element = null;
		for (WebElement fr : frames) {
			try {
				element = fr.findElement(by);
				return element;
			} catch (Exception e) {

			}


		}
		return element;

	}
	public static void storeScreenshot(WebDriver driver,String path) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	
	File file=ts.getScreenshotAs(OutputType.FILE);
	try {
		Files.copy(file, new 
				File(System.getProperty("user.dir")
						.concat(path).concat(".png")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	public static boolean waitUntill(WebDriver driver, ExpectedCondition<?> conditions) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.not(conditions));
	}
	
	
}
