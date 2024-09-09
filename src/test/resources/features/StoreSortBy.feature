@web @android
Feature: Validate on sort by functionality on store

  Background:
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user selects "menu.store.option" from the menu
    Then verify user is on store page

  Scenario: Verify user can get prices sorted from low to high
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "product.sort.price.low.high"
    Then verify that the prices of all listed products are displayed in ascending order

  Scenario: Verify user can get prices sorted from high to low
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "product.sort.price.high.low"
    Then verify that the prices of all listed products are displayed in descending order

  Scenario: Verify user can get prices sorted from a to z
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "product.sort.name.a.z"
    Then verify user should see product names sorted alphabetically from A to Z

  Scenario:  Verify user can get prices sorted from z to a
    When user selects the product "product.category"
    And the user selects the Sort by option and chooses "product.sort.name.z.a"
    Then verify user should see product names sorted alphabetically from Z to A
