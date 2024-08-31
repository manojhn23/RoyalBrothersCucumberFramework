Feature: Validate on filter functionality on bike details

  Background:
    Given user is on website
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user enters the details for ride "pickup.date", "pickup.time", "drop.off.date" and "drop.off.time"
    And clicks on search button
    Then verify user is on bike details page

  Scenario: Verify user can get bike details as per bike model filter
    When user selects the bike model "bike.model"
    Then verify user can get all bikes as selected model

  Scenario: Verify user can get bike details as per bike location filter
    When user selects the bike location "bike.location"
    Then verify user can get all bikes as selected location

  Scenario: Verify user can get bike details as per bike model and location filter
    When user selects the bike model "bike.model" and location "bike.location"
    Then verify user can get all bikes as selected model and location