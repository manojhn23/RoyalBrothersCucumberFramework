Feature: Validate on sort by functionality on bike credentials

  Background:
    Given user is on website
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user enters the details for ride "pickup.date", "pickup.time", "drop.off.date" and "drop.off.time"
    And clicks on search button
    Then verify user is on bike details page

  Scenario: Verify user can get all prices from high to low
    When user clicks on price high to low
    Then verify user can get prices in high to low

  Scenario: Verify user can get all prices from low to high
    When user clicks on price low to high
    Then verify user can get prices in low to high

