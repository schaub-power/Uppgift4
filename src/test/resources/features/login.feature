Feature: Login Test

  Scenario: Test Wrong Username and Password
    Given user opens browser
    When user goes to test site
    Then user logs in, incorrect username and password

  Scenario: Test Wrong Password
    Given user opens browser
    When user goes to test site
    Then user logs in, incorrect password

  Scenario: Test Correct Login
    Given user opens browser
    When user goes to test site
    Then user logs in

  Scenario: Test No Inputs
    Given user opens browser
    When user goes to test site
    Then user continues without inputs