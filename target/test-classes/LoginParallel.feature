@Login
Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario: Login Successful - Data Table
    Given I am in the login page of the Para Bank Application
    When I enter valid credentials
      | tautester | password |
    Then I should be taken to the Overview page