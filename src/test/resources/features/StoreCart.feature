Feature: validate add to cart

  Background:
    Given user is on website
    When user select his desired city "city.name"
    Then verify user is on the home page
    When user click on  hamburger menu
    And selects "Store by RB" from the menu
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
