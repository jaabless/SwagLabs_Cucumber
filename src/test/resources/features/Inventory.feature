Feature: Inventory page functionality on Swag Labs

  Scenario: View products on inventory page
    Given I am logged in as standard user
    Then I should see the products list

  Scenario: Add item to cart from inventory
    Given I am logged in as standard user
    When I add the first item to cart
    Then the cart badge should show "1"