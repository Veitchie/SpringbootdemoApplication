Feature: Create a new actor.
  A new actor needs to be made

  Scenario: The actors name isn't John Doe.
    Given I create an actor and firstName is "John" and lastName is "Doe"
    When I get their firstName and lastName
    Then their firstName should be "John" and their lastName should be "Doe"

  Scenario: An actor is made without a first or last name
    Given I create an actor without a firstName or lastName
    When I get their firstName and lastName
    Then their firstName and lastName should be null