@android
Feature: Validate login functionality

  Background:
    Given the user opens the website or application
    When user select his desired city "app.city.name"
    And clicks on the entered location
    Then verify user is on the home page

  Scenario: Successful login with valid credentials
    When user clicks on the menu option
    And selects the login option from the menu
    Then verify user is on the login page
    When user selects the country "INDIA" with code "(+91)"
    And user enter valid phone number "login.phone"
    And click on get otp option
    Then the user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify login is successful

  Scenario Outline: Unsuccessful login with invalid credentials
    When user clicks on the menu option
    And selects the login option from the menu
    Then verify user is on the login page
    When user selects the country "INDIA" with code "(+91)"
    And user enter invalid phone number "<invalid.phone>"
    And click on get otp option
    Then verify error message is displayed "app.error.message"

    Examples:
      | invalid.phone |
      | 123456789     |
      | 09876543      |
      | 897634        |
      | 9876          |