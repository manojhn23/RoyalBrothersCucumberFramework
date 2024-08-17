Feature: Validate Sort By functionality on store

  Background:
    Given user opens website
    When user select his desired city
    Then verify user is on the home page
    When user selects the store option
    Then verify user is on store page
    When user selects the product "product.name"
    Then verify user is product page of "product.name"

  Scenario: Verify user can get prices from low to high
    When user selects the sort by option as low to high
    Then verify user get all prices from low to high

  Scenario: Verify user can get prices from high to low
    When user selects the sort by option as high to low
    Then verify user get all prices from high to low

  Scenario: Verify user can get product names from a to z
    When user selects the sort by option as a to z
    Then verify user get all names from a to z

  Scenario: Verify user can get product names from z to a
    When user selects the sort by option as z to a
    Then verify user get all names from z to a
