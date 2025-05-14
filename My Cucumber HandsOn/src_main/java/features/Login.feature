Feature: Login functionality of LeafTaps application

Scenario: Login with Valid Credential

Given Launch the browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When click on the login button
Then It should navigate to the next page 


Scenario: Login with invalid Credential

Given Launch the browser
And Load the url
And Enter the username as 'Demo'
And Enter the password as 'crm'
When click on the login button
But It should not navigate to the next page and it will remains in the same page 