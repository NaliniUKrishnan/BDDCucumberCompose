Feature:Cucumber Greeting Page Feature

@smoke
  Scenario: Show Cucumber greeting
    Given I open the app
    When I tap Greet Cucumber button
    Then I see Cucumber greeting

@regression
  Scenario Outline: Show custom greeting
    Given I open the app
    When the name "<name>" is entered in textfield
    And I tap the Done button
   Then I see "<greetingtext>" custom greeting

    Examples:
      | name   | greetingtext |
      | Nalini | Hi Nalini! |
      | N1a2l3i4n5i | Hi N1a2l3i4n5i! |