@web
Feature: Validate on Inter-City booking functionality

  Scenario: Verify user can get a request booking of travel
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
    When user selects "Inter-city travel" from the menu
    Then verify user is on Inter-city travel page
    When user enters the details for ride
      | intercity.pickup.date   |
      | intercity.pickup.time   |
      | intercity.drop.off.city |
      | intercity.drop.off.date |
      | intercity.drop.off.time |
    And clicks on search button on page
    Then verify user is on intercity bike details page
    When user clicks on request booking for first bike
    Then verify user can access confirm request button

