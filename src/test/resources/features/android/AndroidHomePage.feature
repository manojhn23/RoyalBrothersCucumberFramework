Feature: navigate to home page

  Background:
    Given the user opens the website or application

  @android
  Scenario: verify user is able to navigate to home page
    When user select his desired city "app.city.name"
    And clicks on the entered location
    Then verify user is on the home page
