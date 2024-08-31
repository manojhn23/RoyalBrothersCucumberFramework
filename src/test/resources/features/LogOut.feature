@web
Feature: Validate user can logout successfully

  Background:
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user click on login button
    Then verify user is on the login page
    When user enter valid phone number "login.phone" and password "login.password"
    And click on I'm not a robot checkbox
    And click on login with Password button
    And user select his desired city "city.name"
    And clicks on the entered location
    Then verify login is successful

  Scenario: verify user successfully logs out
    When user click on profile
    And the user selects the Logout option from the profile menu
    And user select his desired city "city.name"
    And clicks on the entered location
    Then verify successful user logout


