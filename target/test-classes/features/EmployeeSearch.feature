Feature: Employee search related scenarios
  Background:
#    Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks the on PIM option
#    And user clicks on Employee List option

  @regression @SearchByID
  Scenario: Search employee by ID
    When user enters valid employee ID
    And user clicks on search button
    Then user see the employee information

  @smoke @SearchByName
  Scenario: Search employee by Name
    When user enters valid employee name
    And user clicks on search button
    Then user see the employee information