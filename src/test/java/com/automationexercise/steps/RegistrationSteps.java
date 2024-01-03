package com.automationexercise.steps;

import com.automationexercise.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegistrationSteps {

    @Given("I open browser")
    public void iOpenBrowser() {
    }

    @When("I enter URL")
    public void iEnterURLHttpAutomationexerciseCom() {
    }

    @And("I navigate to {string}")
    public void iNavigateTo(String Url) {
        new HomePage().navigateToHomePage(Url);
    }

    @Then("Home page should visible successfully")
    public void homePageShouldVisibleSuccessfully() {
        new HomePage().homePageVisibleSuccessfully();
    }

    //Test Case 1
    @When("I click on Signup Login button")
    public void iClickOnSignupLoginButton() {
        new HomePage().clickOnSignupLoginButton();
    }

    @Then("I should see signup text {string}")
    public void iShouldSeeSignupText(String signupText) {
        Assert.assertEquals(new SignupPage().verifyNewUserSignupText(), signupText, "Incorrect text");
    }

    @And("I enter name {string} and email address")
    public void iEnterNameAndEmailAddress(String name) {
        new SignupPage().enterName(name);
        new SignupPage().enterEmail();
    }

    @And("I click on Signup button")
    public void iClickOnSignupButton() {
        new SignupPage().clickOnSignupButton();
    }

    @Then("I should see the enter information text {string}")
    public void iShouldSeeTheEnterInformationText(String text) {
        Assert.assertEquals(new RegistrationPage().verifyEnterAccountInformationText(), text, "Incorrect text");
    }

    @And("I fill all details: Title {string}, Name, Email, Password {string}, Date of birth {string}, {string}, {string}")
    public void iFillAllDetailsTitleNameEmailPasswordDateOfBirth(String title, String password, String day, String month, String year) {
        new RegistrationPage().selectTitle(title);
        new RegistrationPage().enterAccountInformation(password, day, month, year);
    }

    @And("I select checkbox Sign up for our newsletter!")
    public void iSelectCheckboxSignUpForOurNewsletter() {
        new RegistrationPage().selectNewsLetterCheckBox();
    }

    @And("I select checkbox Receive special offers from our partners!")
    public void iSelectCheckboxReceiveSpecialOffersFromOurPartners() {
        new RegistrationPage().selectReceiveSpecialOffersFromOurPartnersCheckBox();
    }

    @And("I fill all details: First name {string}, Last name {string}, Company {string}, Address {string}, " +
            "address {string}, Country {string}, State {string}, City {string}, Zipcode {string}, Mobile Number {string}")
    public void iFillAllDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber
            (String firstName, String lastName, String company, String Address, String address,
             String country, String state, String city, String zipcode, String number) {
        new RegistrationPage().enterAddressInformation(firstName, lastName, company, Address,
                address, country, state, city, zipcode, number);
    }

    @And("I click on Create Account button")
    public void iClickOnCreateAccountButton() {
        new RegistrationPage().clickOnCreateAccountButton();
    }

    @Then("I should get a account text {string}")
    public void iShouldGetAAccountText(String accountText) {
        Assert.assertEquals(new AccountPage().verifyAccountCreatedText(), accountText, "Incorrect Text");
    }

    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        new AccountPage().clickOnContinueButton();
    }

    @Then("I should see the Logged in as {string}")
    public void iShouldSeeTheLogInText(String userName) {
        String expected = "Logged in as " + userName;
        String actual = new HomePage().verifyLoggedInAsAUserNameText();
        Assert.assertEquals(actual, expected, "Incorrect Text");
    }

    @And("I click Delete Account button")
    public void iClickDeleteAccountButton() {
        new HomePage().clickOnDeleteAccountButton();
    }

    @Then("I Should get a account delete text {string}")
    public void iShouldGetAAccountDeleteText(String deleteText) {
        Assert.assertEquals(new AccountPage().verifyAccountDeletedText(), deleteText, "Incorrect Text");
    }

    @And("I click on the Continue button")
    public void iClickOnTheContinueButton() {
        new AccountPage().clickOnContinueButton();
    }

    //Test Case 5
    @And("I enter name {string} and already register email address {string}")
    public void iEnterNameAndAlreadyRegisterEmailAddress(String name, String email) {
        new SignupPage().enterName(name);
        new SignupPage().enterAlreadyExistEmail(email);
    }

    @Then("I should get an email already exist error message {string}")
    public void iShouldGetAnEmailAlreadyExistErrorMessage(String errorMessage) {
        Assert.assertEquals(new SignupPage().verifyErrorMessage(), errorMessage, "Incorrect message");
    }

    //Test Case 14
    @When("I add product {string} to the cart")
    public void iAddProductToTheCart(String product) {
        new ProductPage().mouseHoverAndClickAddToCartOnProduct(product);
    }

    @And("I should see the welcome text on shopping cart page {string}")
    public void iShouldSeeTheWelcomeTextOnShoppingCartPage(String welcomeText) {
        Assert.assertEquals(new ShoppingCartPage().verifyShoppingCartWelcomeText(), welcomeText, "Incorrect text");
    }

    @And("I click on Proceed to Checkout button")
    public void iClickOnProceedToCheckoutButton() {
        new ShoppingCartPage().clickOnCheckoutButton();
    }

    @And("I click on register link in the checkout popup")
    public void iClickOnRegisterLinkInTheCheckoutPopup() {
        new ShoppingCartPage().clickOnRegisterLoginLinkOnCheckoutPopup();
    }

    @And("I should see the text on checkout page {string}")
    public void iShouldSeeTheTextOnCheckoutPage(String text) {
        Assert.assertEquals(new CheckoutPage().verifyTextOnCheckoutPage(text), text, "Incorrect text");
    }

    @And("I enter details into comment area {string}")
    public void iEnterDetailsIntoCommentArea(String comment) {
        new CheckoutPage().sendTextToCommentArea(comment);
    }

    @And("I click on place order button")
    public void iClickOnPlaceOrderButton() {
        new CheckoutPage().clickOnPlaceOrderButton();
    }

    @And("I enter payment details name {string}, card number {string} CVC {string} Expiration date {string} and {string}")
    public void iEnterPaymentDetailsNameCardNumberCVCExpirationDateAnd
            (String name, String number, String CVC, String month, String year) {
        new PaymentPage().sendPaymentDetails(name, number, CVC, month, year);
    }

    @And("I click on Pay and Confirm Order button")
    public void iClickOnPayAndConfirmOrderButton() {
        new PaymentPage().clickOnPayAndConfirmOrderButton();
    }

    @Then("I should see the order confirmation message {string}")
    public void iShouldSeeTheOrderConfirmationMessage(String message) {
        Assert.assertEquals(new PaymentPage().verifyOrderConfirmationMessage(), message, "Incorrect message");
    }

    //Test Case 24

    @Then("I should see the delivery address is same address filled at the time registration of account {string}")
    public void iShouldSeeTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String dAddress) {
        Assert.assertEquals(new CheckoutPage().verifyDeliveryAddress(), dAddress, "Incorrect address");
    }

    @And("I should see billing address is same address filled at the time registration of account {string}")
    public void iShouldSeeBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String bAddress) {
        Assert.assertEquals(new CheckoutPage().verifyBillingAddress(), bAddress, "Incorrect address");
    }
}
