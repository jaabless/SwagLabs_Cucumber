Feature: Cart page functionality on Swag Labs

  Scenario: View added item in cart
    Given I am logged in and have added an item to cart
    When I go to the cart page
    Then I should see the added item in cart

  Scenario: Remove item from cart
    Given I am logged in and have added an item to cart
    When I go to the cart page
    And I remove the first item from cart
    Then the cart should be empty