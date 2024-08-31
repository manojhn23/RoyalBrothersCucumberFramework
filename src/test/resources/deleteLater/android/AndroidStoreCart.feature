Feature: Validate user can get cart functionalities successfully

  Background:
    Given user opens application
    When user select his desired city "app.city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When selects "Store by RB" from the menu
    Then verify user is on store page

  Scenario: verify user is able to add products to the cart
    When user selects the product "product.category"
    And adds the product to the cart "product1.name" and "product2.name"
    Then verify that the product is successfully added to the cart

  Scenario: verify user is able to remove products from the cart
    When user selects the product "product.category"
    And adds the product to the cart "product1.name" and "product2.name"
    Then verify that the product is successfully added to the cart
    When user removes product from the cart "product1.name"
    Then verify product is removed from the cart successfully

  Scenario: verify that the user is redirected to the order summary page with the correct payment amount
    When user selects the product "product.category"
    And adds the product to the cart "product1.name" and "product2.name"
    Then verify that the product is successfully added to the cart
    When user click on check out button
    Then verify user is on order summary page
    And verify order summary page should display the correct total payment amount
