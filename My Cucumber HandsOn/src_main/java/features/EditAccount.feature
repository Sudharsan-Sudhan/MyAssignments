Feature: Edit Account functionality of Leaftaps application

Scenario Outline: To validate the Edit Account functionality under with Accounts Tab in LeafTaps Application

Given user clicks on the Accounts Tab
And user clicks on the Find Accounts under Shortcuts
And Enter the Account Name in the search as <Account Name>
And click on Find Accounts button
And click on the Account Name from search results as <Account Name> 
And click on Edit button
And user enters the <New Account Name> in the Account Name Field
When user clicks on Save button
Then Account created sucessfully in View account page & the user is able to see the account as <Account Name>

Examples: 
|Account Name|New Account Name|
|Sudharsan Subramanian|Subramanian Balakrishnan|