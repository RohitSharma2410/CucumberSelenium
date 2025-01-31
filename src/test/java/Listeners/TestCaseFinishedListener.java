package Listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Selenium.Cucumber.TestBase;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestStepFinished;

public class TestCaseFinishedListener implements ConcurrentEventListener{


	@Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, 
        		event -> {
					try {
						handleTestCaseFinished(event);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
    }

    
	private void handleTestCaseFinished(TestCaseFinished finish) throws Exception {
 
    	if(TestBase.drivers.get().getWindowHandles().size()!=0) {
    		TestBase.drivers.get().quit();
    	}
        	
        	
        		
        
    }
}
	
	

