Feature: Amazon search functionality
  Agile story: As a user, when I am on the Amazon search page
  I should be able to search whatever I want and see relevant information

  @evreka
  Scenario Outline: Search functionality in a Data Driven Testing Format
    Given user is on Amazon search page
    When user search "<searchKey>" and clicks enter
#    And Check that the "results" are listed
    And Click iPhone13 at the top of the list
    Then User should see brand in the result
    Then User should see model in the result
    Then User should see size in the result
    Then User should see color in the result
    Then User should see price in the result
    Then User should see stock in the result
    Examples:
      | searchKey     |
      | iPhone 11 128 |
      | iPhone 12 256 |
      | iPhone 13 512 |




    #        Evreka Software Test Engineer Evaluation Question
    #        UI Test Assignment
    #        We want you to perform a UI test on the site we share below. Afterwards, we expect
    #        you to take a screenshot of this test result and send an e-mail to
    #        dogukanmermutlu@evreka.co
    #        https://cantunsee.space
    #        Automation Test Assignment (via Selenium Automation Tool)
    #        We expect you to automate the following steps via Selenium Web Driver, regardless of
    #        checking for expected/actual results. We prefer Chrome as the browser, but the choice
    #        is yours.


    #        Notes: It may also be necessary to write code to accept the accept cookies warning.
    #            1. Go to 'https://www.amazon.com.tr/'
    #            2. Search iPhone13 512
    #            3. Check that the results are listed
    #            4. Click iPhone13 at the top of the list
    #            5. Log the following values for each size
    #                .Size information .Price .Color .Stock status
    #
    #            We expect an output similar to this screenshot.
    #
    #                iPhone 13 Size:512 GB
    #                Color:Yıldız Işığı Price:18.304,01TL
    #                Stock:Stokta sadece 1 adet kaldı.
    #                Process finihed with exit code 0
    #
    #        You can send the project to us as a zip. These should be included in the zipped project;
    #        ● Browser Driver,
    #        ● pom.xml,
    #        ● src (main, test),
    #        ● Target (generated-test-sources, test-classes)
