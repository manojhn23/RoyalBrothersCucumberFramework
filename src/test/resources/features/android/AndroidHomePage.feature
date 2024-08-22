Feature: navigate to home page

  Scenario: verify user is able to navigate to home page
    Given user opens application
    When user select his desired city "app.city.name"
    And clicks on the entered location
    Then verify user is on the home page
