Feature: Using Application

  Scenario: User success to login
    Given User already in login page
    When  User input username
    And User input password
    Then User click login button
    Then User on dashboard page

  Scenario: User failed to login
    Given User already in login page
    When  User input username
    And User input invalid password
    Then User click login button
    Then User get error message

  Scenario: User logout
    Given User already in login page
    When  User input username
    And User input password
    Then User click login button
    Then User on dashboard page
    When User click hamburger menu
    And User click logout
    Then User back to login page

  Scenario : User buy product
    Given User already in login page
    When  User input username
    And User input password
    Then User click login button
    Then User on dashboard page
    And User click add to cart
    And User click cart
    Then User click checkout
    When User input first name
    And User input last name
    And User input zip
    Then User click continue
    And User click finish
    And User click back
    Then User on dashboard page

