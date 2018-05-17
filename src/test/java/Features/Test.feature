Feature: Login to facebook and save cookies

  Scenario Outline: Login with proper credentials
    Given I navigate to Fb page page
    And I fill <account> and <profile>
    Then I verify the count of my salary digits for rs javoCme%3825


    Examples:
      |account|profile|
      |riverdiego|R1v3rd13g0|



  Scenario: Login to fb with
    Given I go to google page page
    Then I verify the count of my salary digits for rs javoCme%3825