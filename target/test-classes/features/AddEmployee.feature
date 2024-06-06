Feature: Adding employees using different techniques

  Background:
    When user enters valid username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks the on PIM option
    And user clicks on Add Employee option

  @AddEmployee
  Scenario: Adding an employee in HRMS system
#    Given user is navigated to HRMS application
    When user enters firstName, middleName and lastName
    And user click on the save button
    Then the employee will be added successfully

  @FeatureFileAdd
  Scenario: Adding an employee from feature file
    When user enters "Asghar", "M", "Nazir"
    And user click on the save button
    Then the employee will be added successfully

  @AddEmployeeList
  Scenario Outline: Adding employees using data driven testing
    When user enters "<firstName>", "<middleName>" and "<lastName>"
    And user click on the save button
    Then the employee will be added successfully
    Examples:
      | firstName | middleName | lastName |
      | Sohail    | MS         | Abbassi  |
      | Asghar    | MS         | Nazir    |

#  @WithDataTable
#  Scenario: Adding employees using the data tables
#    When user enters firstName, middleName and lastName from data table
#    And user click on the save button
#    Then the employee will be added successfully
#      | firstName  |  middleName  | lastName  |
#      | Sohail     |  MS          | Abbassi   |
#      | Asghar     |  MS          | Nazir     |
#      | Pratyush   |  MS          | singh     |
  @WithDataTable
  Scenario: Adding employees using the data tables
    When user enters firstname and middlename and lastname from data table and verify it
      | firstName  |  middleName  | lastName  |
      | Sohail     |  MS          | Abbassi   |
      | Asghar     |  MS          | Nazir     |
      | Pratyush   |  MS          | singh     |

  @ExcelData
  Scenario: Add employees using the excel data file
    When user enters employees details using the excel file and validate