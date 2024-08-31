@web
Feature: Validate on login functionality with valid and invalid credentials

  Background:
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    And user can view city-specific services
    When user click on login button
    Then verify user is on the login page

  Scenario: Successful login with valid credentials
    When user enter valid phone number "login.phone" and password "login.password"
    And click on I'm not a robot checkbox
    And click on login with Password button
    And user select his desired city "city.name"
    And clicks on the entered location
    Then verify login is successful

  Scenario Outline: Unsuccessful login with invalid credentials
    When user enter invalid phone number "<invalid.phone>" and password "<invalid.password>"
    And click on I'm not a robot checkbox
    And click on login with Password button
    Then verify error message is displayed "error.message"

    Examples:
      | invalid.phone | invalid.password |
      | 1234567890    | test123          |
      | 0987654321    | Login345         |
      | 8976345678    | test@123         |
      | 9876456738    | login@896        |


