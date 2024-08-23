Feature: Validate on bike booking checkout functionality

  Scenario: Verify user can checkout functionality
    Given user opens application
    When user select his desired city "app.city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user enters the details for ride "app.pickup.date", "app.pickup.time", "app.drop.off.date" and "app.drop.off.time"
    And clicks on search button
#    Then verify user is on bike details page
#    When user clicks on book of first bike
#    Then verify user is on bike checkout page
#    And verify user can get make payment option
