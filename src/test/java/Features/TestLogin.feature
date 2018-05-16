Feature: Login to touchdesigner.navisdrive.com

  Scenario Outline: Login with navis profile
    Given I navigate Navis profile page
    And I enter <account> and <profile>
    Then I verify the count of my salary digits for rs javoCme%3825


    Examples:
      |account|profile|
      |1005|9998|
