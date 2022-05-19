

Feature: OrangeHRM Login
@priority:3 
Scenario: Home Page default login

Given User is on the Login Page

When User clicks on Login by entering username<userid> and password<passwords>

Then Login successful "true"
And Username is displayed "true"
Examples: 
      |userid | passwords | 
      | admin | admin123  |
      
@priority:2
Scenario: Home page login with invalid password

Given User is on the Login Page

When User clicks on Login by entering username<userid> and password<passwords>

Then Login successful "false"
And Username is displayed "false"
Examples: 
      |userid | passwords | 
      | admin | admin321  |
@priority:1
Scenario: Home page login with invalid credetials
Given User is on the Login Page

When User clicks on Login by entering username<userid> and password<passwords>

Then Login successful "false"
And Username is displayed "false"
Examples: 
      |userid | passwords | 
      |       |           |
      | defg  |  defg321  |
      | ghijk | ghijk456  |


