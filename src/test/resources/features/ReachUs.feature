@web
Feature: Validate on reach us functionality

  Background:
    Given user opens application
    When user select his desired city "city.name"
    And clicks on the entered location
    Then verify user is on the home page
    When user selects "menu.reach.us.option" from the menu
    Then verify user is on reach us page

  Scenario Outline: Verify user can submit with valid details
    When user enters the details as "<name>","<email>","<mobile>" and "<comment>"
    And clicks on submit button
    Then verify user can get a city selection option
    Examples:
      | name  | email              | mobile     | comment                |
      | Pavan | pavan@gmail.com    | 9900876823 | It is nice             |
      | Arun  | arun@test.com      | 8799005445 | Helpful                |
      | Varun | varun123@gmail.com | 9779523445 | The interface was good |
      | Kavya | kavya@outlook.com  | 6789543201 | Excellent bike service |

  Scenario Outline: Verify user can submit with invalid details
    When user enters the details as "<name>","<email>","<mobile>" and "<comment>"
    And clicks on submit button
    Then verify user can get a message "reach.us.number.error.msg"
    Examples:
      | name  | email              | mobile     | comment                |
      | Arun  |                    | 8799005445 | Helpful                |
      | Varun | varun123@gmail.com |            | The interface was good |
      | Pavan |                    |            | It is nice             |
      | Kavya | kavya@outlook.com  | 78605467   | Excellent bike service |

  Scenario: Verify user can submit without a comment message
    When user enters the details as "reach.us.name","reach.us.email" and "reach.us.mobile"
    And clicks on submit button
    Then verify user can get a message "reach.us.comment.error.msg"

