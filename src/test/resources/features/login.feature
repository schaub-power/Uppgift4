Feature: Login Test

  Scenario: Test Correct Login
    Given user opens browser
    When user goes to test site
    Then user logs in

  Scenario: Test No Last Name
    Given user opens browser
    When user goes to test site
    Then user logs in, no last name

  Scenario: Test Wrong Password
    Given user opens browser
    When user goes to test site
    Then user logs in, non matching passwords

  Scenario: Test Didn't Accept Terms
    Given user opens browser
    When user goes to test site
    Then user logs in, didn't accept terms