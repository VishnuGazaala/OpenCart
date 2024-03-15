Feature: Login features of OpenCArt website
  As a user of OpenCart website
  I need to login into my account
  So that I can access my account-related features and track my orders

  Background:
    Given I am on OpenCart Login Page

  Scenario: Successful login with vaild credentials
      Given I have entered "vgazzala@gmail.com" and "admin"
      When I click on Login button
      Then Title of the page should be "My Account"

  Scenario Outline:Unsuccessful logins with invalid credentials
    Given I have entered "<username>" and "<password>"
    When I click on Login button
    Then I should see error message "<error message>"

    Examples:
      | username           | password   | error message                                |  |
      | invalid@email.com  | invalidpwd | No match for E-Mail Address and/or Password. |  |
      | asdfkf@jjkhjjk     | admin      | No match for E-Mail Address and/or Password. |  |
      | vgazzala@gmail.com | yuio       | No match for E-Mail Address and/or Password. |  |


Scenario: Navigating to forgotten password page
  When user clicks on Forgotten Password link
  Then Title of the page should be "Forgot Your Password?"