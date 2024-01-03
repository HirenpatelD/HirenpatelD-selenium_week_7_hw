package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {
    //Test Case 2
    @And("I enter name {string} and email address {string}")
    public void iEnterNameAndEmailAddress(String name, String email) {
        new SignupPage().enterName(name);
        new SignupPage().enterEmailAddress(email);
    }

    @And("I click on logout button")
    public void iClickOnLogoutButton() {
        new HomePage().clickOnLogoutButton();
    }

    @Then("I get a login text {string}")
    public void iGetALoginText(String loginText) {
        Assert.assertEquals(new LoginPage().verifyLoginToYourAccountText(), loginText, "Incorrect Text");
    }

    @And("I enter correct email address {string} and password {string}")
    public void iEnterCorrectEmailAddressAndPassword(String correctEmail, String correctPassword) {
        new LoginPage().enterEmailAddress(correctEmail);
        new LoginPage().enterPassword(correctPassword);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    //Test Case 3
    @And("I enter incorrect email address {string} and password {string}")
    public void iEnterIncorrectEmailAddressAndPassword(String incorrectEmail, String incorrectPassword) {
        new LoginPage().enterEmailAddress(incorrectEmail);
        new LoginPage().enterPassword(incorrectPassword);
    }

    @Then("I should see the incorrect details text {string}")
    public void iShouldSeeTheIncorrectDetailsText(String errorText) {
        Assert.assertEquals(new LoginPage().verifyTheErrorMessage(), errorText, "Incorrect Text");
    }

    //Test Case 4
    @Then("I should navigate to {string}")
    public void iShouldNavigateTo(String Url) {
        new LoginPage().navigateToLoginPage(Url);
    }
}
