Feature: Login 
 
 @data-driven
 Scenario: test Login 
 Given when i am on home page
 When i enter uname and pwd
 Then i am able to login
 
 @data-driven
 Scenario: The one where user picks different product through search functionality
 When Larry searches below products in the search box:
 |Head  |
 |Travel|
 |Laptop|
 Then product should be added in the cart if available
 
 @user-specific
 Scenario Outline: test Login 
 Given when i am on home page
 When i enter "<uname>" and "<pwd>"
 Then i am able to login
  Examples:
     |  uname  |     pwd     |
     | lalitha | Password123 |
     | ABC     | XYZ         |