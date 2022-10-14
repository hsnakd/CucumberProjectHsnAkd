@webTableLogin
Feature: User should be able to login using correct credentials

  Background: user is on the login page
    Given user is on the login page of web table app


  Scenario:   user is on the login page
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders


  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders


  Scenario Outline: user is on the login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks to login button
    Then  user should see url contains orders
    Examples:
      | username | password |
      | Test | Tester |


  Scenario: User should be able to see all 12 months in months dropdown
    When user enters below credentials
      | username     | Test   |
      | password     | Tester |
    Then user should see url contains orders






