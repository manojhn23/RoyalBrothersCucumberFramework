Feature: Validate user can logout successfully

  Background:
    Given the user opens the website or application
    When user select his desired city "app.city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user clicks on the menu option
    And selects the login option from the menu
    Then verify user is on the login page
    When user selects the country "INDIA" with code "(+91)"
    And user enter valid phone number "login.phone"
    And click on get otp option
    Then the user should be redirected to the OTP details page
    When user enter otp and click on submit button
    Then verify login is successful

  Scenario: verify user successfully logs out
    When user clicks on the menu option
    And selects the logout option from the menu
    Then verify the user is logged out successfully