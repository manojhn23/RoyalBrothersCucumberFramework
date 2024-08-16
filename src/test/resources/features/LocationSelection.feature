Feature: Validate on Location selection functionality

  Background:
    Given user opens website
    Then verify user is on homepage
    When clicks on the location option

  Scenario Outline: Verify user can selects the city as location
    When enters the location as "<location name>"
    And clicks on the entered location
    Then verify the location of user chosen
    Examples:
      | location name     |
      | Agra              |
      | Ahmedabad         |
      | Alleppey          |
      | Bangalore         |
      | Bangalore Airport |
      | Belagavi          |
      | Bhubaneswar       |
      | Calicut           |
      | Chandigarh        |
      | Chennai           |
      | Chikmagalur       |
      | Cochin            |
      | Coorg             |
      | Delhi             |
      | Gandhinagar       |
      | Guntur            |
      | Gurugram          |
      | Guwahati          |
      | Hubli-Dharwad     |
      | Hyderabad         |
      | Indore            |
      | Jaipur            |
      | Jaisalmer         |
      | Jodhpur           |
      | Kolkata           |
      | Manali            |
      | Mangalore         |
      | Mysore            |
      | Pondicherry       |
      | Puri              |
      | Ranchi            |
      | Surat             |
      | Tirupati          |
      | Trivandrum        |
      | Udaipur           |
      | Udupi - manipal   |
      | Vijayawada        |
      | Vizag             |
      | Wayanad           |


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
      | Amritsar      |
      | Haridwar      |
      | Bhopal        |
      | Srinagar      |
      | Shimla        |

  Scenario: Verify user can clears on location search text
    When enters the location as "location.name"
    And clicks on clear button
    Then verify user can get empty on search input field


