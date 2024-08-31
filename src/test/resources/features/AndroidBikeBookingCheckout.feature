@android
Feature: Validate on bike booking functionality

  Scenario: Verify user can book a bike
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user enters the details for ride "pickup.date", "pickup.time", "drop.off.date" and "drop.off.time"
    And clicks on search button
    Then verify user is on bike details page
    When user clicks on book of first bike
    Then verify user is on the login page
