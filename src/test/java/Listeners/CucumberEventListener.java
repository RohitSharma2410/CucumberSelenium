package Listeners;

import Selenium.Cucumber.TestBase;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.Step;
import io.cucumber.plugin.event.TestStepStarted;

public class CucumberEventListener implements ConcurrentEventListener {

	

	    @Override
	    public void setEventPublisher(EventPublisher publisher) {
	        publisher.registerHandlerFor(TestStepStarted.class, 
	        		this::handleTestStepStarted);
	    }

	    private void handleTestStepStarted(TestStepStarted testStepStartedEvent) {
	    	
	        if (testStepStartedEvent.getTestStep() instanceof PickleStepTestStep) {
	            PickleStepTestStep currentStep = (PickleStepTestStep)
	            		testStepStartedEvent.getTestStep();
	           System.out.println("Test Step started "+currentStep.getStep().getText());
	        }
	    }
	
}