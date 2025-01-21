package Selenium.Cucumber;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilsClasses.StringUtilsFunctions;

public class StepDefinitions {

	@When("data is like")
	public void data_is_like(List<Map<Object,Object>> data) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		data.forEach(t->System.out.println(t));
		
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

	@When("I click on {string}")
	public void i_click_on(String string) {
		// Write code here that turns the phrase above into concrete actions
		TestBase.getElement(string).click();
		TestBase.wait.get().until(ExpectedConditions.visibilityOf(TestBase.getElement("dashboardsearchfield")));

	}

	@When("I enter {string} in {string} field")
	public void i_enter_in_field(String string, String string2) {
		TestBase.getElement(string2).sendKeys(string);

	}

	@Then("User login should see {string}")
	public void user_login_should(String string) {

		assert (TestBase.getElement("dashboardsearchfield").isDisplayed());
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
			assert (valueOfStatus.equalsIgnoreCase(string3));
			int amountvalue = StringUtilsFunctions
					.returnOnlyNumeric(TestBase.getElementOnElement("alltransactionsamount",
							TestBase.getElementWithUpdatedValue(string2, "transaction", string)).getText());
			System.out.println(amountvalue);
			assert (amountvalue == int1);
		}

	}

}

