
Feature: VyTrack App login with different roles


#  Background:
#    Given user is on the login page
#
#  @wip
#  Scenario: login as driver
#    When user enters driver credentials
#    Then user should see driver navigation options
#      | Fleet      |
#      | Customers  |
#      | Activities |
#      | System     |
#
#
#  @wip
#  Scenario Outline: login as sales manage or store manager
#    When user enters "<role>" information
#    Then user should see manager navigation options
#      | Dashboards         |
#      | Fleet              |
#      | Customers          |
#      | Sales              |
#      | Activities         |
#      | Marketing          |
#      | Reports & Segments |
#      | System             |
#
#    Examples:
#    |role|
#    |Sales|
#    |Store|

@vyTrack
    Scenario: verify log in with multiple credentials
      When user is on the login page
      Then check  the credentials and write pass or fail