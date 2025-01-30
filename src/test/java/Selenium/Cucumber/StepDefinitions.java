package Selenium.Cucumber;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilsClasses.StringUtilsFunctions;

public class StepDefinitions {

	@When("data is like")
	public void data_is_like(List<Map<Object, Object>> data) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		data.forEach(t -> System.out.println(t));

	}
	

@When("I autheticate user with credentials")
public void i_autheticate_user_with_credentials() {
    // Write code here that turns the phrase above into concrete actions
	
	 HasAuthentication authentication=(HasAuthentication)TestBase.drivers.get();
	 authentication.register(()->new UsernameAndPassword("admin","admin"));
	 
    
}
@Then("following {string} should be available on page")
public void following_should_be_available_on_page(String string) {
    // Write code here that turns the phrase above into concrete actions
	TestBase.assertions.get().assertTrue(TestBase.getElement(string).isDisplayed());
   
}

	@Given("an example scenario")
	public void anExampleScenario() {
	}

	@When("all step definitions are implemented")
	public void allStepDefinitionsAreImplemented() {
	}

	@Then("the scenario passes")
	public void theScenarioPasses() {
	}

	@Given("I am on Login page")
	public void i_am_on_login_page() {

	}

@Then("Validate all of response for {string}")
public void validate_all_of(String string) throws MalformedURLException, IOException {
	List<WebElement>allElements=TestBase.getElements(string);

    // Write code here that turns the phrase above into concrete actions
	for(int i=0;i<allElements.size();i++) {
		String src=allElements.get(i)
				.getDomAttribute("src");
		System.out.println("src is "+src);
		HttpURLConnection conn =(HttpURLConnection) URI.create(TestBase.config.
				getProperty("appurl").toString().concat(src)).toURL().openConnection() ;
        conn.setRequestMethod("HEAD");
        conn.connect();
        System.out.println(conn.getResponseCode());
        TestBase.assertions.get().assertTrue(conn.getResponseCode()==200);
}
}
@Then("all links should populate all of link status")
public void all_links_should_populate_all_of_link_status() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("I dragAndDrop element {string} to element {string}")
public void dragAndDrop(String string,String string2) {
    // Write code here that turns the phrase above into concrete actions

   Actions actions=new Actions(TestBase.drivers.get());
   actions
   .dragAndDrop(TestBase.getElement(string), TestBase.getElement(string2)).build().perform();
}

@Then("element {string} should be draged to target successfully")
public void dragSuccess(String string) {
	
	TestBase.assertions.get().assertTrue(TestBase.getElements("DragElements").get(1).getLocation().getY()==TestBase.getElement(string).getLocation().getY());
	
}
@When("I right click on {string}")
public void i_right_click_on(String string) {
    // Write code here that turns the phrase above into concrete actions

   Actions actions=new Actions(TestBase.drivers.get());
   actions
   .contextClick(TestBase.getElement(string)).build().perform();
}
@Then("alert should be available on the page")
public void alert_should_be_available_on_the_page() {
    // Write code here that turns the phrase above into concrete actions
    try{TestBase.drivers.get().switchTo().alert().dismiss();
    }
    catch(NoAlertPresentException e) {
    	new SoftAssert().fail("Alert is not pop up");
    }
}


	@When("I click on {string}")
	public void i_click_on(String string) {
		// Write code here that turns the phrase above into concrete actions
		TestBase.getElement(string).click();

	}

	@When("I enter {string} in {string} field")
	public void i_enter_in_field(String string, String string2) {
		TestBase.getElement(string2).sendKeys(string);

	}

	@Then("User login should see {string}")
	public void user_login_should(String string) {
		TestBase.assertions.get().assertTrue(TestBase.getElement("dashboardsearchfield").isDisplayed());
		System.out.println("Checking initial pool");
	}

	@Given("I am on Dashboard page")
	public void i_am_on_dashboard_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I check transaction {string} on {string}")
	public void i_check_transaction_on(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		TestBase.getElementOnElement("allTransactionsStatus",
				TestBase.getElementWithUpdatedValue(string, "transaction", "string2"));
	}

	@Then("I check transaction {string} on {string} then status should be {string} and amount should be {int}")
	public void i_check_transaction_on_then_status_should_be_and_amount_should_be(String string, String string2,
			String string3, Integer int1) throws Exception {
		{
			// Write code here that turns the phrase above into concrete actions
			String valueOfStatus = TestBase.getElementOnElement("allTransactionsStatus",
					TestBase.getElementWithUpdatedValue(string2, "transaction", string)).getText();
			System.out.println(valueOfStatus);
			TestBase.assertions.get().assertTrue (valueOfStatus.equalsIgnoreCase(string3));
			int amountvalue = StringUtilsFunctions
					.returnOnlyNumeric(TestBase.getElementOnElement("alltransactionsamount",
							TestBase.getElementWithUpdatedValue(string2, "transaction", string)).getText());
			System.out.println(amountvalue);
			TestBase.assertions.get().assertTrue (amountvalue == int1);
		}

	}

}
