Feature: Validate Sort By functionality on store

  Background:
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    And selects "Store by RB" from the menu
    Then verify user is on store page

  Scenario: Verify user can get prices sorted from low to high
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Price, low to high"
    Then verify that the prices of all listed products are displayed in ascending order

  Scenario: Verify user can get prices sorted from high to low
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Price, high to low"
    Then verify that the prices of all listed products are displayed in descending order

  Scenario: Verify user can get prices sorted from a to z
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Alphabetically, A-Z"
    Then verify user should see product names sorted alphabetically from A to Z

  Scenario:  Verify user can get prices sorted from z to a
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "Alphabetically, Z-A"
    Then verify user should see product names sorted alphabetically from Z to A
