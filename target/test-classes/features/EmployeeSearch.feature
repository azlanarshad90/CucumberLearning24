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

  @regression @SearchByFullName
  Scenario: Search employee by Full Name
    When user enters valid employee's full name "Sepid ms Amizemi"
    And user clicks on search button
    Then user see the employee information

  @regression @SearchbyPartialName
  Scenario: Search employee by Partial Name
    When user enters a valid employee's partial name "Sepid"
    And user clicks on search button
    Then user see the employee information

  @regression @SearchbyDifferentCapitalization
  Scenario: Search employee by either Full Name or Partial Name with different capitalization
    When user enters a valid employee's name with different capitalization "sEPiD"
    And user clicks on search button
    Then user see the employee information

  @regression @SearchInvalidName
  Scenario: Search for an invalid/non-existing employee name
    When user enters an invalid or non-existing employee name "Admin"
    And user clicks on search button
    Then user see the message 'No Records Found'

  @regression @SearchInvalidID
  Scenario: Search for an invalid/non-existing employee ID
    When user enters an invalid or non-existing employee ID "120"
    And user clicks on search button
    Then user see the message 'No Records Found'