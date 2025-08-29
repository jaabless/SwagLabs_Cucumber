Feature: Checkout functionality

  Scenario Outline: Successful checkout with valid details
    Given The user logs in with username "standard_user" and password "secret_sauce"
    And User adds item to cart
    When The user proceeds to checkout
    And The user enters checkout information "<firstName>", "<lastName>", "<postalCode>"
    And The user finish the checkout process
    Then The user should see the confirmation message

    Examples:
      | firstName        | lastName     | postalCode         |
      | Joe   | Doe | 12345   |
        | Jane  | Smith | 67890   |





