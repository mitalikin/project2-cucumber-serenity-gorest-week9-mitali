Feature: Testing different request on the user information

  Scenario: Check if the user information can be accessed by users
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200

  Scenario Outline: Create a new user & verify if the user is added
    When I create a new user by providing the information name"<name>" email "<email>" gender "<gender>" status "<status>"
    Then I verify that the user with "<name>" is created
    Examples:

      | name | email         | gender | status   |
      | abc  | abc@gmail.com | male   | active   |
      | xyz  | xyz@gmail.com | female | inactive |