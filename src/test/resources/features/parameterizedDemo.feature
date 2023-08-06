Feature: Validating the APIs by passing data through Examples

  Scenario Outline: Verify if user can make POST call by using passing the data through Examples
    Given Making the POST request by using user names through Examples with "<name>"  "<isbn>" "<aisle>" "<author>"
    When    user makes a POST call
    Then    Status code should be 200

    Examples:
      | name                    | isbn   | aisle        | author |
      | Krishna Kamakshi Brahma | TestQA1 | QAAutomation1QA | Java   |
      | Krishna | TestQA2 | QAAutomation2QAAAA | Python   |
      | Brahma | TestQA3 | QAAutomation3 | Ruby   |