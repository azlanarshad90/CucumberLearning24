Feature: Scenarios related to employee membership details

  @regression @ESSLogin
  Scenario: Login as an ESS user
    When user enters valid ESS user login details
    And user clicks on login button
    Then user is successfully logged in