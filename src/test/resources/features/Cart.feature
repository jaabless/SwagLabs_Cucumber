Feature: Cart page functionality on Swag Labs

  Scenario Outline: View added item in cart
    Given I log in as username "<username>" and password "<password>"
    And I have added an item to cart
    When I go to the cart page
    Then I should see the added item in cart

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Remove item from cart
    Given I log in as username "<username>" and password "<password>"
    And I have added an item to cart
    When I go to the cart page
    And I remove the first item from cart
    Then the cart should be empty

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |