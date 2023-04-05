Feature: Sales Force Login Feature-
User Tries To Login
Background:
Given user should launch the browser and  navigate to the salesforce login page

@smoke
Scenario Outline: user tries to login with invalid credentials
When user enters the "<username>" in username field
And user enters the "<password>" in password field
And user clicks the submit button
Then your should able to see a error message
But user should not be navigate to the salesforce home page

Examples: 
				|username|password|
				|raghu|12345|
				|charan|charansg|
				|lokey|loki123|

@Regression
Scenario: user tries to login with valid credentials
When user enters the "raghuvaranvit" in username field
And user enters the	"raghu1234" in password field
And user clicks the submit button
Then user should be navigate to the salesforce home page
