Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information

  Scenario: Search page title verification
    When user is on Google search page
    Then user should see title is Google


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types apple and clicks enter
    Then user sees apple in the google title


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "apple" and clicks enter
    Then user sees "apple" in the google title

            #     Parameterization
            #  - What is Parameterization?
            #  - Parameterization is being able to pass and change data directly from feature file.
            #  - We don't have to go in the step definitions to change the data when we use Parameterization.

  Scenario Outline: Search functionality result title verification
    Given user is on Google search page
    When user types "<searchValue>" and clicks enter
    Then user sees "<result>" in the google title
    Examples:
      |searchValue  |result   |
      |Turkey       |Turkey   |
      |USA          |USA      |
      |Ukraine      |Ukraine  |
      |Germany      |Germany  |
      |UK           |UK       |
      |Latvia       |Latvia   |
      |Greece       |Greece   |

            #  dataTables
            #  - We can pass COLLECTIONS TYPE OF DATA under the same STEP.
            #  - LIST
            #  - MAP
            #  - LIST OF MAP
            #  - MAP OF MAP




            #  scenario outlines
            #  - Scenario outlines allows us to simplify the DDT (Data Driven Testing) by creating "Example:" tables under our "Scenario Outline:""
            #
            #  - We don't have to come to feature file to change the data everytime we run. We only provide once, and our scenario will be executed against all of this data.
            #
            #  - Whereas, in parameterization, we would have to come back to change all the data just to run the same scenario with another test data.


  Scenario: Data Driven Testing Format preparation
    Given user is on Google search page
    When user types "capital of Turkey" and clicks enter
    Then User should see "Ankara" in the result

  Scenario Outline: Search functionality in a Data Driven Testing Format
    Given user is on Google search page
    When user types "capital of <country>" and clicks enter
    Then User should see "<capital>" in the result
    Examples:
      |country  |capital      |
      |Turkey   |Ankara       |
      |USA      |Washington DC|
      |Ukraine  |Kyiv         |
      |Germany  |Berlin       |
      |UK       |London       |
      |Latvia   |Riga         |
      |Greece   |Athens       |


