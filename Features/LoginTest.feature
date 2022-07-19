@login
Feature: Sample practice application
  Background: user navigates to xpath practice page
  	Given launch the application
  	When landed in homepage
  	

  Scenario Outline: Fill the details with xpath locators 
  	Given practice menu is avaiable in category menu
  	When navigate to xpath practice page  
    Then enter firstname "<firstName>" and lastname "<lastName>"
    And Enter email "<email>" and password "<password>"
  
  Examples:
    | firstName | lastName | email | password |
    | test1 | practice1| test1@test.com | testpassword1 |
    | test2	| practice2| test2@test.com | testpassword2 |
    