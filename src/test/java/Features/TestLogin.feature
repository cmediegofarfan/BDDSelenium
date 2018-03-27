Feature: Login in Facebook.com
  This login delas with the login funtionality of the app

  Scenario: Login with the proper credentials
    Given I navigate fb page
    And I enter the following for login
      |nickname|password1|
      |riverdiego|diego1111|
    And I click Login button
    And I create an email using the nickname
    Then I should see my personal wall


  Scenario Outline: Login with several account Outline scenario
    Given I navigate fb page
    And I enter <username> and <pass>
    And I verify the count of my salary digits for rs 10000
    And I click Login button
    Then I should see my personal wall

    Examples:
      |username|pass|
      |admin|1234|
      |diego|pass1234|
      |root|root|