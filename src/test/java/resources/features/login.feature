@regression
Feature: Login Feature
  In Order to check login functionality
  As a User
  I have to enter valid and invalid data to check login functionality

  Background: User is on home page
    Given I open browser
    When I enter URL
    And I navigate to "http://automationexercise.com"
    Then Home page should visible successfully

  @sanity
  Scenario: Test Case: 2 User should login with valid credentials successfully
    When I click on Signup Login button
    And I enter name "Michel" and email address "mjackson12@gmail.com"
    And I click on Signup button
    And I fill all details: Title "title", Name, Email, Password "mk12345", Date of birth "5", "May", "1995"
    And I fill all details: First name "Michel", Last name "Jackson", Company "MK Ltd.", Address "12, Bhavnath", address "Near Bus stand road", Country "India", State "Gujarat", City "Junagadh", Zipcode "362002", Mobile Number "0123456789"
    And I click on Create Account button
    And I click on Continue button
    And I click on logout button
    And  I click on Signup Login button
    Then I get a login text "Login to your account"
    And I enter correct email address "mjackson12@gmail.com" and password "mk12345"
    And I click on login button
    Then I should see the Logged in as "Michel"
    And I click Delete Account button
    Then I Should get a account delete text "ACCOUNT DELETED!"

  @sanity, @smoke
  Scenario: Test Case: 3 User should not login invalid credentials
    When I click on Signup Login button
    Then I get a login text "Login to your account"
    And I enter incorrect email address "michel1234@gmail.com" and password "12345678"
    And I click on login button
    Then I should see the incorrect details text "Your email or password is incorrect!"

  @smoke
  Scenario: Test Case: 4 User should logout successfully
    When I click on Signup Login button
    Then I get a login text "Login to your account"
    And I enter correct email address "akjk@gmail.com" and password "mk12345"
    And I click on login button
    Then I should see the Logged in as "Michel"
    And I click on logout button
    Then I should navigate to "https://automationexercise.com/login"

  Scenario: Test Case: 16 User should Place Order and login before checkout successfully
      When I click on Signup Login button
      And I enter name "Michel" and email address "mjackson12@gmail.com"
      And I click on Signup button
      And I fill all details: Title "title", Name, Email, Password "mk12345", Date of birth "5", "May", "1995"
      And I fill all details: First name "Michel", Last name "Jackson", Company "MK Ltd.", Address "12, Bhavnath", address "Near Bus stand road", Country "India", State "Gujarat", City "Junagadh", Zipcode "362002", Mobile Number "0123456789"
      And I click on Create Account button
      And I click on Continue button
      And I click on logout button
      And  I click on Signup Login button
      Then I get a login text "Login to your account"
      And I enter correct email address "mjackson12@gmail.com" and password "mk12345"
      And I click on login button
      Then I should see the Logged in as "Michel"
      When I add product "Blue Top" to the cart
      And I Click View Cart button
      And I should see the welcome text on shopping cart page "Shopping Cart"
      And I click on Proceed to Checkout button
      And I should see the text on checkout page "Review Your Order"
      And I should see the text on checkout page "Address Details"
      And I enter details into comment area "Leave the product at door."
      And I click on place order button
      And I enter payment details name "Michel Jackson", card number "0000000000000000" CVC "125" Expiration date "15" and "2027"
      And I click on Pay and Confirm Order button
      Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"
      And I click Delete Account button
      Then I Should get a account delete text "ACCOUNT DELETED!"
      And I click on the Continue button