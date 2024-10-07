Feature: Espresso Greeting Page Feature

  @smoke
  Scenario: Show Espresso greeting
    Given I open the app
    When I tap Greet Espresso button
    Then I see Espresso greeting in Espresso page

  @nalini
  Scenario: Go to Greet CucumberCompose Page
    Given I open the app
    When I tap Greet Espresso button
    And I tap Greet Cucumber button on Espresso page
    Then I am on Greet CucumberCompose Page