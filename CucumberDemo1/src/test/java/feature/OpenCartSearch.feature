Feature: Search product functionality 

Scenario:  Validate the working of Search functionality with existing product
Given User on the Home page with login "false"
When clicking on the search by entering product "iMac" and compare product "false"
And Search the product by entering "NA" in the search criteria "false"
And Bydefault products view in the list and click on the Grid "false"
Then Search product "true" with two or more number "false"
And product display in the Grid view "false"

Scenario:  Validate the working of Search functionality with non existing product
Given User on the Home page with login "false"
When clicking on the search by entering product "Fitbit" and compare product "false"
And Search the product by entering "NA" in the search criteria "false"
And Bydefault products view in the list and click on the Grid "false"
Then Search product "false" with two or more number "false"
And product display in the Grid view "false"

Scenario: Validate the working of Search functionality without passing any product and validating Search criteria feature
Given User on the Home page with login "false"
When clicking on the search by entering product "NA" and compare product "false"
And Search the product by entering "iLife" in the search criteria "true"
And Bydefault products view in the list and click on the Grid "false"
Then Search product "false" with two or more number "false"
And product display in the Grid view "false"

Scenario:  Validate the working of Search functionality with existing product after login
Given User on the Home page with login "true"
When clicking on the search by entering product "iMac" and compare product "false"
And Search the product by entering "NA" in the search criteria "false"
And Bydefault products view in the list and click on the Grid "false"
Then Search product "true" with two or more number "false"
And product display in the Grid view "false"


Scenario:  Validate the working of Search functionality with existing multiple product
Given User on the Home page with login "false"
When clicking on the search by entering product "Mac" and compare product "false"
And Search the product by entering "NA" in the search criteria "false"
And Bydefault products view in the list and click on the Grid "false"
Then Search product "false" with two or more number "true"
And product display in the Grid view "false"

Scenario:  Validate the working of Search functionality By Adding product to compare
Given User on the Home page with login "false"
When clicking on the search by entering product "iMac" and compare product "true"
And Search the product by entering "NA" in the search criteria "false"
And Bydefault products view in the list and click on the Grid "false"
Then Search product "true" with two or more number "false"
And product display in the Grid view "false"

Scenario:  Validate the working of Search functionality Grid view
Given User on the Home page with login "false"
When clicking on the search by entering product "Mac" and compare product "true"
And Search the product by entering "NA" in the search criteria "false"
And Bydefault products view in the list and click on the Grid "true"
Then Search product "false" with two or more number "true"
And product display in the Grid view "true"

