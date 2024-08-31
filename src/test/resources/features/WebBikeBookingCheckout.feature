@web
Feature: Validate on bike booking checkout functionality

  Scenario: Verify user can checkout functionality
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    And user can view city-specific services
    When user click on login button
    Then verify user is on the login page
    When user enter valid phone number "login.phone" and password "login.password"
    And click on I'm not a robot checkbox
    And click on login with Password button
    And user select his desired city "city.name"
    And clicks on the entered location
    Then verify login is successful
    When user enters the details for ride "pickup.date", "pickup.time", "drop.off.date" and "drop.off.time"
    And clicks on search button
    Then verify user is on bike details page
    When user clicks on book of first bike
    Then verify user is on bike checkout page
    And verify user can get make payment option


