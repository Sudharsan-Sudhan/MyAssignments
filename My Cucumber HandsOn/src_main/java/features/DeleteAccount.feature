Feature: Delete Account functionality of Leaftaps application

Scenario Outline: To validate the Delete Account functionality under with Accounts Tab in LeafTaps Application

Given user clicks on the Accounts Tab
And user clicks on the Find Accounts under Shortcuts
And Enter the Account Name in the search as <Account Name>
And click on Find Accounts button
And click on the Account Name from search results as <Account Name> 
When click on Delete button
Then account deleted sucessfully 

Examples: 
|Account Name|
|Subramanian Balakrishnan|