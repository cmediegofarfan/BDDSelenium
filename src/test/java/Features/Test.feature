Feature: Login to facebook and save cookies

  Scenario Outline: Opening View existing messages
    Given I navigate Navis profile page
    And I enter <account> and <profile>
    And I go to View existing messages
    Then View existing messages is properly opened

    Examples:
      |account|profile|
      |QA1005 - QA1005 - Scott QA Test|9998 - NAVIS Tech Support|


