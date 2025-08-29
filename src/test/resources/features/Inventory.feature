Feature: Inventory page functionality on Swag Labs

  Scenario: View products on inventory page
    Given The user logs in with username "standard_user" and password "secret_sauce"
    Then I should see the products list


  Scenario: Add item to cart from inventory
    Given The user logs in with username "standard_user" and password "secret_sauce"
    When I add the first item to cart
    Then the cart badge should show "1"