Feature: Login in ea.com

  Scenario Outline: Login with several account Outline scenario
    Given I navigate fb page
    And I enter <username>
    And I verify the count of my salary digits for rs 10000
    And I click Login button
    Then I should see my personal wall

    Examples:
      |username|
      |boyanjavier@gmail.com|
