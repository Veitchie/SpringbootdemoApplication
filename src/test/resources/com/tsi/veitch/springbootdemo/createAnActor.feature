Feature: Create a new actor.
  A new actor needs to be made

  Scenario: The actors name isn't John Doe.
    Given firstName is "Jane" and lastName is "Doe"
    When I ask whether their firstName is John and their lastName is Doe
    Then I should be told "no"