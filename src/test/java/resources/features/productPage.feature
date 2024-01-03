@regression
Feature: Product page Feature
  In Order to check functionality Product page
  As a User
  I have to follow the steps to fulfill all the requirements

  Background: User is on home page
    Given I open browser
    When I enter URL
    And I navigate to "http://automationexercise.com"
    Then Home page should visible successfully

  @sanity
  Scenario: Test case: 8 User should get the all products list and landed successfully to product details page
    When I click on Products button
    Then I should navigated to all products "https://automationexercise.com/products" page successfully
    And I should get The products list
    And I Click on View Product of first product
    And I should landed to "https://automationexercise.com/product_details/1"
    Then I should get a product name "Blue Top", category "Category: Women > Tops", price "Rs. 500", availability "Availability: In Stock", condition "Condition: New", brand "Brand: Polo"

  @sanity @smoke
  Scenario: Test case: 9 User should search the products successfully
    When I click on Products button
    Then I should navigated to all products "https://automationexercise.com/products" page successfully
    And I enter product name "Jeans" in search input and click search button
    Then I should get search product title "SEARCHED PRODUCTS"
    Then I should see all the products related to search product "Soft Stretch Jeans"

  @smoke
  Scenario: Test case: 12 User should add products in cart successfully
    When I click on Products button
    When I add product "Blue Top" to the cart
    And I click Continue Shopping button
    When I add product "Men Tshirt" to the cart
    And I Click View Cart button
    Then I verify the product "Blue Top" in shopping cart
    Then I verify the product "Men Tshirt" in shopping cart

  Scenario: Test case: 13 User should verify product quantity in cart
    When I Click on View Product of first product
    And I should landed to "https://automationexercise.com/product_details/1"
    Then I should get a product name "Blue Top", category "Category: Women > Tops", price "Rs. 500", availability "Availability: In Stock", condition "Condition: New", brand "Brand: Polo"
    And I increase the quantity "4"
    And I click on add to cart button
    And I click on view cart link in success message
    Then I should see that product is displayed in cart page with exact quantity "4"

  Scenario: Test case: 17 User should remove the product from the cart successfully
    When I add product "Blue Top" to the cart
    And I Click View Cart button
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click X button corresponding to particular product
    Then I should get the empty cart

  Scenario: Test case: 18 User should see the category of the product successfully
    When I click on Products button
    Then I click on "Women" category
    And I click on "Dress" in women category
    And I should see "WOMEN - DRESS PRODUCTS" page title
    Then I click on "Men" category
    And I click on "Tshirts" in men category
    Then I should see "MEN - TSHIRTS PRODUCTS" page title
    Then I should navigated to "https://automationexercise.com/category_products/3" that category page

  Scenario: Test case: 19 User should navigate to the brand page and see the products successfully
    When I click on Products button
    Then  I click on polo brand in Brands tab
    And I should see polo "BRAND - POLO PRODUCTS" page title
    And I click on madame brand in Brands tab
    Then I should see madame "BRAND - MADAME PRODUCTS" page title

  Scenario: Test case: 20 User should see the products in cart after login
    When I click on Products button
    Then I should navigated to all products "https://automationexercise.com/products" page successfully
    And I enter product name "Jeans" in search input and click search button
    Then I should get search product title "SEARCHED PRODUCTS"
    Then I should see all the products related to search product "Soft Stretch Jeans"
    And I add product "Jeans" to the cart
    And I Click View Cart button
    Then I verify the product "Soft Stretch Jeans" in shopping cart
    When I click on Signup Login button
    Then I get a login text "Login to your account"
    And I enter correct email address "akjk@gmail.com" and password "mk12345"
    And I click on login button
    When I click on "Cart" button
    Then I verify the product "Soft Stretch Jeans" in shopping cart

  Scenario: Test case: 21 User should add a review on products successfully
    When I click on Products button
    Then I should navigated to all products "https://automationexercise.com/products" page successfully
    And I Click on View Product of first product
    And I enter "Michel" name in your name field
    And I enter "michel@gmail.com" email in email address field
    And I enter "The fabric is really good" message to review here field
    And I click on review submit button
    Then I should see "Thank you for your review." message

  Scenario: Test case: 22 User should add a review on products successfully
    When I scroll down up to recommended items text
    Then I should see "RECOMMENDED ITEMS" text
    And I add product to the cart from recommended product
    And I Click View Cart button
    Then I verify the product "Stylish Dress" in shopping cart

  Scenario: Test case: 24 User should download the invoice after purchase order
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
#    And I click on download invoice
    And I click on download invoice and verify the Invoice is downloaded
    And I click on continue button
    And I click Delete Account button
    Then I Should get a account delete text "ACCOUNT DELETED!"
    And I click on the Continue button