Feature: Checkout functionality

  Scenario Outline: Successful checkout with valid details
    Given The user logs in with username "<username>" and password "<password>"
    And User adds item to cart
    When The user proceeds to checkout
    And The user enters checkout information "John", "Doe", "12345"
    And The user finish the checkout process
    Then The user should see the confirmation message

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |


