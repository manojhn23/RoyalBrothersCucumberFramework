Feature: Validate on Location selection functionality

  Background:
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When clicks on the location option

  Scenario Outline: Verify user can selects the city as location
    When enters the location as "<location name>"
    And clicks on the entered location
    Then verify the location of user chosen
    Examples:
      | location name     |
      | Bangalore Airport |
#      | Chennai           |
#      | Delhi             |
#      | Gurugram          |
#      | Hyderabad         |

  Scenario Outline: Verify user cannot selects the city as location
    When enters the location as "<location name>"
    Then verify the location of user chosen not getting
    Examples:
      | location name |
      | Mumbai        |
      | Pune          |
      | Lucknow       |
      | Vadodara      |
      | Coimbatore    |

  Scenario: Verify user can clears on location search text
    When enters the desired location as "city.name"
    And clicks on clear button
    Then verify user can get empty on search input field


