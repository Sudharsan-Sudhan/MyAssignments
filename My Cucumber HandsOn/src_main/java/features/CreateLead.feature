Feature: CreateLead functionality of Leaftaps application

Scenario Outline: CreateLead with multiple data

Given Launch the browser
And Load the url
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When click on the login button
Then It should navigate to the next page 
When Click on the CRMSFA link
When Click on the Leads link
When Click on the CreateLead link
Given Enter the companyname as <companyName>
Given Enter the firstname as <firstName>
Given Enter the lastname as <lastName>
When Click on the CreateLead button
Then Lead should be created

Examples:
|companyName|firstName|lastName|
|TestLeaf|Vineeth|Rajendran|
|Qeagle|Hari|RS|