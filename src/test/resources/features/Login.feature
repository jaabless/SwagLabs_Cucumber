Feature: Login functionality on Swag Labs

  Scenario Outline: Login with different credentials (parametrized)
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click login button
    Then I should see "<expected>"

    Examples:
      | username        | password     | expected          |
      | standard_user   | secret_sauce | inventory page    |
      | invalid_user    | invalid_pass | error message     |
      | locked_out_user | secret_sauce | locked out error  |