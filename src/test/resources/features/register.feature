@RegisterPage
Feature: Register Functionality

  Scenario: User registers a new account filling only mandatory fields
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Register option
    And the user enters the following details into the mandatory fields:
      | John        |
      | Doe         |
      | john.doe_123311@gmail.com    |
      | 1234567890  |
      | password123 |
      | password123 |
    And the user clicks on the Continue button
    Then the user should see the Account Success page
    When the user clicks on the Continue button on the Account Success page
    Then the user should be taken to the Account page

  Scenario: User registers a new account filling all fields
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Register option
    And the user enters the following details into all the fields:
      | John        |
      | Doe         |
      | john.doe_1241331@gmail.com    |
      | 1234567890  |
      | password123 |
      | password123 |
    And the user clicks on the Continue button
    Then the user should see the Account Success page
    When the user clicks on the Continue button on the Account Success page
    Then the user should be taken to the Account page

  Scenario: User tries to register without entering any details
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Register option
    And the user does not enter any details into the fields and clicks on the Continue button
    Then the warning message "First Name must be between 1 and 32 characters!" should be displayed for the First Name field
    And the warning message "Last Name must be between 1 and 32 characters!" should be displayed for the Last Name field
    And the warning message "E-Mail Address does not appear to be valid!" should be displayed for the E-Mail field
    And the warning message "Telephone must be between 3 and 32 characters!" should be displayed for the Telephone field
    And the warning message "Password must be between 4 and 20 characters!" should be displayed for the Password field
    And the warning message "Warning: You must agree to the Privacy Policy!" should be displayed at the top

  Scenario: User registers and subscribes to the newsletter
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Register option
    And the user enters the following details into all the fields:
      | John        |
      | Doe         |
      | john.doe_1241@gmail.com    |
      | 1234567890  |
      | password123 |
      | password123 |
    And the user clicks on the Yes radio option for Newsletter
    And the user clicks on the Continue button
    Then the user should see the Account Success page
    When the user clicks on the Continue button on the Account Success page
    Then the user should be taken to the Account page
    When the user clicks on the SubscribeUnsubscribe to newsletter option
    Then the Yes option should be displayed as selected by default in the Newsletter page

  Scenario: User registers and does not subscribe to the newsletter
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Register option
    And the user enters the following details into all the fields:
      | John        |
      | Doe         |
      | john.doe_131331@gmail.com    |
      | 1234567890  |
      | password123 |
      | password123 |
    And the user clicks on the No radio option for Newsletter
    And the user clicks on the Continue button
    Then the user should see the Account Success page
    When the user clicks on the Continue button on the Account Success page
    Then the user should be taken to the Account page
    When the user clicks on the SubscribeUnsubscribe to newsletter option
    Then the No option should be displayed as selected by default in the Newsletter page

  Scenario: User navigates to the Register Account page
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Register option
    Then the user should be taken to the Register Account page

  Scenario: User navigates to the Register Account page through New Customer box
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Login option
    And the user clicks on the Continue button inside the New Customer box
    Then the user should be taken to the Register Account page

  Scenario: User navigates to the Register Account page through Right Column options
    Given the user is on the homepage
    When the user clicks on the My Account drop menu
    And the user clicks on the Login option
    And the user clicks on the Register option from the Right Column options
    Then the user should be taken to the Register Account page

  Scenario Outline: User registers with password confirmation mismatch
    Given the user is on the Register Account page
    When the user enters the following details into firstName "<First Name>", lastName "<Last Name>", email "<E-Mail>", telephone "<Telephone>", password "<Password>", passwordConfirm "<Password Confirm>" fields
    And the user clicks on the Continue button
    Then the account should not be created
    And the warning message "Password confirmation does not match password!" should be displayed under the Password Confirm field
    Examples:
      | First Name  | Last Name | E-Mail                | Telephone   | Password  | Password Confirm  | Warning Message                                 |
      | John        | Doe       | john.doe@example.com  | 1234567890  | 12345     | abcde             | Password confirmation does not match password!  |







