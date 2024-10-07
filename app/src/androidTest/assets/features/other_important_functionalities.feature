Feature: Other important BDD functionalities

#Tags in BDD help categorize and organize scenarios, making it easier to run specific tests based on context or requirements.
@Ui @login @ignore
  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the dashboard


#Data tables are useful for testing scenarios where the same steps need to be repeated with different inputs.- reusability
  @ignore
  Scenario: Add multiple users to the system
    Given the following users exist
      | name   | email              |
      | John   | john@example.com    |
      | Sarah  | sarah@example.com   |
      | Michael| michael@example.com |
    Then they should be added to the database


#Examples - It is helpful when testing a scenario with multiple data sets without duplicating the same steps- enhances test coverage
  @ignore
  Scenario Outline: Testing user login with multiple credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    Then the login attempt should be "<outcome>"

    Examples:
      | username    | password  | outcome      |
      | john_doe    | pass123   | successful   |
      | invalidUser | invalid   | unsuccessful |
      | jane_doe    | pass456   | successful   |

##Background-  reduce duplication when several scenarios share the same setup steps.
#"""Feature: User Dashboard
#
#  Background:
#    Given the user is logged into the system
#
#  Scenario: View account information
#    When the user navigates to the account page
#    Then the user's account details should be displayed
#
#  Scenario: View order history
#    When the user navigates to the order history page
#    Then the user's order history should be displayed"""

#Parametreized steps - allow scenarios to be more flexible by accepting different inputs directly within the step definition.
  @ignore
  Scenario: Search for a product
    Given the user searches for "laptop"
    Then the search results should display products related to "laptop"


# #Hooks - Simplifies repetitive setup and teardown steps. can also control teh execution order by using hooks with ordered steps
#
#    """@Before(order = 1)
#  public void setup() {
#  // Code to set up database or test environment
#  }
#    @Before(order = 2)
#public void loginUser() {
#    // Log in user before executing scenarios
#}
#
#    @After
#  public void teardown() {
#  // Code to clean up resources or reset states
#  }"""
#
##Cucumber also generates reports in formats like HTML, JSON, or JUnit XML
#
##Also can be integrated to Github actions to run our BDD tests in the CI/CD pipeline






