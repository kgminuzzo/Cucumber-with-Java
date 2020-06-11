@Login
Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

#  Scenario: Login Successful - Simple Scenario
#    Given I am in the login page of the Para Bank Application
#    When I enter valid credentials
#    Then I should be taken to the Overview page


  Scenario Outline: Login Successful - Scenario Outline
    Given I am in the login page
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the Overview page
    Examples:
      | username   | password | userFullName   |
   #   | autotester | password | Karina Minuzzo |
      | tautester  | password | sdasda sdsa    |

  Scenario: Login Successful - Data Table
    Given I am in the login page of the Para Bank Application
    When I enter valid credentials
      | tautester | password |
    Then I should be taken to the Overview page


