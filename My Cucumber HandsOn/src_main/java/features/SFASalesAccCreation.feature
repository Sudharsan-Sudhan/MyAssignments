Feature: In the SalesForce Application user is trying to create an account under Sales tab

Scenario: Creating a New Account under Sales section from the SalesForce Application

Given Launch the Browser
And Load the salesforce URL with 'vinothkumar.sanmugaraj848@agentforce.com' and 'Sales@123'
And Click on toggle menu & Click view All & then click on Sales from App Launcher
And Click on Accounts tab
And Click on New button
When Enter 'Sudharsan' as account name 
And Select Ownership as Public
Then Click save and verify Account name as 'Sudharsan'
