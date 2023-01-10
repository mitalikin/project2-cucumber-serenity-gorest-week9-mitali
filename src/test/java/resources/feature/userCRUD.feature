Feature: User Information
  As a user I want to Test User Information

  Scenario Outline: CRUD Test
    Given user application is running
    When I create a new user by providing the information name"<name>" email "<email>" gender "<gender>" status "<status>"
    Then I verify that the user with "<name>" is created
    And I update the user with information name"<name>"email"<email>"gender"<gender>"status"<status>"
    And The user with name"<name>" is updated successfully
    And I delete the user that created with name"<name>"
    Then The user deleted successfully from application

    Examples:
      | name | email            | gender | status    |
      | abc  | test12@gmail.com | male   | available |