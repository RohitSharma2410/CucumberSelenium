package utilsClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventFiringClass {
	
	private EventFiringDecorator<WebDriver> eventfiring=null;
	
	public EventFiringClass() {
		eventfiring=new EventFiringDecorator<WebDriver>(new WebEventsListener());
		
		
	}
	public synchronized WebDriver getDriver(WebDriver driver) {
		return eventfiring.decorate(driver);
	}
	

}
