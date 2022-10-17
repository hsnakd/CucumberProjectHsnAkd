
Feature: VyTrack App login with different roles

@vyTrack2
    Scenario: verify log in with multiple credentials
      When user is on the second login page
      Then check  the credentials and write pass or fail