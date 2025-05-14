Feature: Create Account functionality of Leaftaps application

Scenario Outline: To validate the Create Account functionality under with Accounts Tab in LeafTaps Application

Given user clicks on the Accounts Tab
And user clicks on the Create Accounts under Shortcuts
And user enters the <Account Name> in the Account Name Field
When user clicks on Create Account button
Then Account created sucessfully in View account page & the user is able to see the account as <Account Name>

Examples: 
|Account Name|
|Sudharsan Subramanian|