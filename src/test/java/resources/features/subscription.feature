@regression
Feature: Subscription Feature
  In Order to check subscription functionality
  As a User
  I have to follow the steps to check subscription functionality

  Background: User is on home page
    Given I open browser
    When I enter URL
    And I navigate to "http://automationexercise.com"
    Then Home page should visible successfully

  @sanity
  Scenario: Test case 10: User should subscribe on home page
    When I Scroll down to footer
    Then I should get a subscription text "SUBSCRIPTION"
    And I enter email address "akjk@gmail.com" in input and click arrow button
    Then I should see a successfully subscribe message "You have been successfully subscribed!"

    @sanity @smoke
  Scenario: Test case 11: User should subscribe on cart page
    When I click on "Cart" button
    When I Scroll down to footer
    Then I should get a subscription text "SUBSCRIPTION"
    And I enter email address "akjk@gmail.com" in input and click arrow button
    Then I should see a successfully subscribe message "You have been successfully subscribed!"

  Scenario: Test case 25: User should scroll up using Arrow button and scroll down functionally
    When I Scroll down to footer
    Then I should get a subscription text "SUBSCRIPTION"
    And I click on arrow up button at bottom right corner
    Then I should see the message "Full-Fledged practice website for Automation Engineers"

  Scenario: Test case 26: User should scroll up without using Arrow button and scroll down functionally
    When I Scroll down to footer
    Then I should get a subscription text "SUBSCRIPTION"
    And I scroll up to top
    Then I should see the message "Full-Fledged practice website for Automation Engineers"