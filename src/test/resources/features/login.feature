@Regression @login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different
  accounts. And dashboard should be displayed.

  Accounts are: librarian, student, admin

  Background:  For the scenarios in the feature file, user is expected to be on login page
    Given user is on the library login page

  @librarian @employee
  Scenario: Login as librarian

    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @student @db
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

  @admin @employee
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard

#this is how we add comments in feature file



#  - Different ways of generate snippet:

#1- Run the RunnerClass and generate the snippet in console
#2- Hover over the unimplemented step --> Create step definition --> Select class where we want it
  # --> We can generate snippet for more steps:
  # - Hover over one line --> More actions --> Create all step definitions
#3- Put your cursor on the unimplemented line:
  # Windows: ALT + Enter --> Create step definition --> Select class where we want it
  # Mac: Option + Enter --> Create step definition --> Select class where we want it
