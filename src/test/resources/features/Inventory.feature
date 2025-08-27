Feature: Inventory page functionality on Swag Labs

  Scenario Outline: View products on inventory page
    Given I am logged in as username "<username>" and password "<password>"
    Then I should see the products list

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Add item to cart from inventory
    Given I am logged in as username "<username>" and password "<password>"
    When I add the first item to cart
    Then the cart badge should show "1"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |