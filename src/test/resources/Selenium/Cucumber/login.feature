
Feature: Login

  Scenario Outline: Login with <username> and <password>
    Given I am on Login page
    When I enter <username> in "loginusername" field
     When data is like
    |3|rakesh|
    |5.8|5|
    And I enter <password> in "loginpassword" field
    And I click on "loginsigninbutton"
    Then User login should see "dashboardsearchfield"
   
    
	Examples:
		||username||password||
		||"rohit"||"rohit"||
	
