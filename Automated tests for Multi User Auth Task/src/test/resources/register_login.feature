Feature: Register and Login AutomationExercise

  Scenario Outline: Register multiple users and login each of them
    Given I open the Automation Exercise website
    When I register a user with the following details:
      | name    | password | day | month | year | firstName | lastName | address     | state   | city    | zip     | mobile   |
      | <name>  | <password> | <day> | <month> | <year> | <firstName> | <lastName> | <address> | <state> | <city> | <zip> | <mobile> |
    Then login and verify the registered user with email

    Examples:
      | name  | password | day | month | year | firstName | lastName | address     | state   | city    | zip     | mobile   |
      | John  | pass123  | 1   | 1     | 1990 | John      | Doe      | 123 Main St | Texas   | Austin  | 123456  | 12345678 |
      | Alice | pass456  | 2   | 2     | 1985 | Alice     | Smith    | 456 Elm St  | Florida | Miami   | 654321  | 87654321 |
