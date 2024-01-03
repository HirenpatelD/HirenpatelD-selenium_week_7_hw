package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SubscriptionSteps {

    //Test case 10
    @When("I Scroll down to footer")
    public void iScrollDownToFooter() {
        new HomePage().scrollDownToFooter();
    }

    @Then("I should get a subscription text {string}")
    public void iShouldGetASubscriptionText(String text) {
        Assert.assertEquals(new HomePage().verifySubscriptionText(), text, "Incorrect Text");
    }

    @And("I enter email address {string} in input and click arrow button")
    public void iEnterEmailAddressInInputAndClickArrowButton(String email) {
        new HomePage().enterEmailToSubscriptionEmail(email);
        new HomePage().clickOnArrowToSubscribe();
    }

    @Then("I should see a successfully subscribe message {string}")
    public void iShouldSeeASuccessfullySubscribeMessage(String message) {
        Assert.assertEquals(new HomePage().getSubscriptionSuccessMessage(), message, "Incorrect Message");
    }

    //Test case 25
    @And("I click on arrow up button at bottom right corner")
    public void iClickOnArrowUpButtonAtBottomRightCorner() {
        new HomePage().clickOnBottomRightArrowButton();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String text) {
        Assert.assertEquals(new HomePage().getFullFledgedText(), text, "Incorrect text");
    }

    //Test case 26
    @And("I scroll up to top")
    public void iScrollUpToTop() {
        new HomePage().scrollUpToTop();

    }
}
