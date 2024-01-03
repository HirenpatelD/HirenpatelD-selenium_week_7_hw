@regression
Feature: Register Feature
  In Order to check registration functionality
  As a User
  I have to enter mandatory details to check registration functionality

  Background: User is on home page
    Given I open browser
    When I enter URL
    And I navigate to "http://automationexercise.com"
    Then Home page should visible successfully

  @sanity
  Scenario: Test Case: 1 User should register successfully
    When I click on Signup Login button
    Then I should see signup text "New User Signup!"
    And I enter name "Michel" and email address
    And I click on Signup button
    Then I should see the enter information text "ENTER ACCOUNT INFORMATION"
    And I fill all details: Title "title", Name, Email, Password "mk12345", Date of birth "5", "May", "1995"
    And I select checkbox Sign up for our newsletter!
    And I select checkbox Receive special offers from our partners!
    And I fill all details: First name "Michel", Last name "Jackson", Company "MK Ltd.", Address "12, Bhavnath", address "Near Bus stand road", Country "India", State "Gujarat", City "Junagadh", Zipcode "362002", Mobile Number "0123456789"
    And I click on Create Account button
    Then I should get a account text "ACCOUNT CREATED!"
    And I click on Continue button
    Then I should see the Logged in as "Michel"
    And I click Delete Account button
    Then I Should get a account delete text "ACCOUNT DELETED!"
    And I click on the Continue button

  @sanity, @smoke
  Scenario: Test Case: 5 User should not register with existing email
    When I click on Signup Login button
    Then I should see signup text "New User Signup!"
    And I enter name "Michel Jackson" and already register email address "mkjk@gmail.com"
    And I click on Signup button
    Then I should get an email already exist error message "Email Address already exist!"

  @smoke
  Scenario: Test Case: 14 User should Place Order and Register while Checkout successfully
    When I add product "Blue Top" to the cart
    And I Click View Cart button
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    And I click on register link in the checkout popup
    And I enter name "Michel" and email address
    And I click on Signup button
    Then I should see the enter information text "ENTER ACCOUNT INFORMATION"
    And I fill all details: Title "title", Name, Email, Password "mk12345", Date of birth "5", "May", "1995"
    And I fill all details: First name "Michel", Last name "Jackson", Company "MK Ltd.", Address "12, Bhavnath", address "Near Bus stand road", Country "India", State "Gujarat", City "Junagadh", Zipcode "362002", Mobile Number "0123456789"
    And I click on Create Account button
    Then I should get a account text "ACCOUNT CREATED!"
    And I click on Continue button
    Then I should see the Logged in as "Michel"
    When I click on "Cart" button
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

  Scenario: Test Case: 15 User should Place Order and Register before Checkout successfully
    When I click on Signup Login button
    Then I should see signup text "New User Signup!"
    And I enter name "Michel" and email address
    And I click on Signup button
    Then I should see the enter information text "ENTER ACCOUNT INFORMATION"
    And I fill all details: Title "title", Name, Email, Password "mk12345", Date of birth "5", "May", "1995"
    And I select checkbox Sign up for our newsletter!
    And I select checkbox Receive special offers from our partners!
    And I fill all details: First name "Michel", Last name "Jackson", Company "MK Ltd.", Address "12, Bhavnath", address "Near Bus stand road", Country "India", State "Gujarat", City "Junagadh", Zipcode "362002", Mobile Number "0123456789"
    And I click on Create Account button
    Then I should get a account text "ACCOUNT CREATED!"
    And I click on Continue button
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

  Scenario: Test Case: 23 User should verify the details in checkout page
    When I click on Signup Login button
    Then I should see signup text "New User Signup!"
    And I enter name "Michel" and email address
    And I click on Signup button
    Then I should see the enter information text "ENTER ACCOUNT INFORMATION"
    And I fill all details: Title "title", Name, Email, Password "mk12345", Date of birth "5", "May", "1995"
    And I select checkbox Sign up for our newsletter!
    And I select checkbox Receive special offers from our partners!
    And I fill all details: First name "Michel", Last name "Jackson", Company "MK Ltd.", Address "12, Bhavnath", address "Near Bus stand road", Country "India", State "Gujarat", City "Junagadh", Zipcode "362002", Mobile Number "0123456789"
    And I click on Create Account button
    Then I should get a account text "ACCOUNT CREATED!"
    And I click on Continue button
    Then I should see the Logged in as "Michel"
    When I add product "Blue Top" to the cart
    And I Click View Cart button
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    Then I should see the delivery address is same address filled at the time registration of account "12, Bhavnath"
    And I should see billing address is same address filled at the time registration of account "12, Bhavnath"
    And I click Delete Account button
    Then I Should get a account delete text "ACCOUNT DELETED!"
    And I click on the Continue button