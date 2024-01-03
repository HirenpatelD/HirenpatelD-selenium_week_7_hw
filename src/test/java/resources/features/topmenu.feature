@regression
Feature: Top menu Feature
  In Order to check functionality for top menu on home page
  As a User
  I have to follow the steps for each menu given om home page top menu bar

  Background: User is on home page
    Given I open browser
    When I enter URL
    And I navigate to "http://automationexercise.com"
    Then Home page should visible successfully

    @sanity
  Scenario: Test case: 6 User should use the contact us form feature successfully
    When I click on "Contact us" button
    Then I should see get in touch text "GET IN TOUCH"
    And I enter name "Michel", email "mkjk@gmail.com", subject "New collection" and message "I am looking for a new collection of casual clothes. Please let me know when new stock is arrive."
    And I upload file "C:\Users\ankit\OneDrive\Desktop"
    And I click on Submit button
    And I click on OK button
    Then I should get a success message "Success! Your details have been submitted successfully."
    And I click on home button and verify that landed to "http://automationexercise.com" successfully

      @sanity @smoke
  Scenario: Test case : 7 User should navigate to the test case page successfully
    When I click on "Test Cases" button
    Then I should navigate to test case page "https://automationexercise.com/test_cases" Successfully