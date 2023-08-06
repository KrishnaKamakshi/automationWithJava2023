Feature: Create Token for Auth Validation

  Scenario: Token should be generated based on the user information
    Given  API got valid username and password
    When   Validate if the end point is hit with valid username and password
    Then   Token should be generated and response should be shown