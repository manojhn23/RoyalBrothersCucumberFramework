Feature: navigate to home page

  Scenario: verify user is able to navigate to home page
    Given user opens application
    When user select city "app.city.name"
    Then verify user is on home page