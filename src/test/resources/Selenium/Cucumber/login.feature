Feature: An example

  Scenario Outline: The example
    Given I am on Login page
    When I enter <username> in "loginusername" field
    And I enter <password> in "loginpassword" field
    And I click on "loginsigninbutton"
    Then User login should see "dashboardsearchfield"
	Examples:
		||username||password||
		||"rohit"||"rohit"||
		||""||""||