Feature: Smoke test - Demo

  Scenario Outline: Opening Image Library
    Given I navigate Navis profile page
    And I enter <account> and <profile>
    And I go to Image Library
    Then Image Library is properly opened

    Examples:
      |account|profile|
      |QA1005 - QA1005 - Scott QA Test|9998 - NAVIS Tech Support|

  Scenario Outline: Opening View existing messages
    Given I navigate Navis profile page
    And I enter <account> and <profile>
    And I go to View existing messages
    Then View existing messages is properly opened

    Examples:
      |account|profile|
      |QA1005 - QA1005 - Scott QA Test|9998 - NAVIS Tech Support|