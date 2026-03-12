Feature: Login functionality

  Scenario: Valid login
    Given User launches the application
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks on login button
    Then User should be redirected to inventory page