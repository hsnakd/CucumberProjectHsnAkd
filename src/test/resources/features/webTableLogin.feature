Feature: User should be able to login using correct credentials

  Scenario:   user is on the login page
    Given             user is on the login page of web table app
    When              user enters username "Test"
    And               user enters password "Tester"
    And               user clicks to login button
    Then              user should see url contains orders

  @wip
  Scenario: Positive login scenario
    Given user is on the login page of web table app
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders


  Scenario Outline:   user is on the login page
    Given             user is on the login page of web table app
    When              user enters username "<username>"
    And               user enters password "<password>"
    And               user clicks to login button
    Then              user should see url contains orders
    Examples:
      | username | password |
      | Test | Tester |







