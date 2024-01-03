package com.automationexercise.steps;

import com.automationexercise.pages.TopMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TopMenuSteps {
    //Test case 6
    @When("I click on {string} button")
    public void iClickOnButton(String option) {
        new TopMenuPage().selectOption(option);
    }

    @Then("I should see get in touch text {string}")
    public void iShouldSeeGetInTouchText(String getInTouch) {
        Assert.assertEquals(new TopMenuPage().verifyGetInTouchText(), getInTouch, "Invalid text");
    }

    @And("I enter name {string}, email {string}, subject {string} and message {string}")
    public void iEnterNameEmailSubjectAndMessage(String name, String email, String subject, String message) {
        new TopMenuPage().enterName(name);
        new TopMenuPage().enterEmail(email);
        new TopMenuPage().enterSubject(subject);
        new TopMenuPage().enterMessage(message);
    }

    @And("I upload file {string}")
    public void iUploadFile(String filePath) {
        new TopMenuPage().uploadFile(filePath);
    }

    @And("I click on Submit button")
    public void iClickOnSubmitButton() {
        new TopMenuPage().clickOnSubmitButton();
    }

    @And("I click on OK button")
    public void iClickOnOKButton() {
        new TopMenuPage().clickOnOkAlertButton();
    }

    @Then("I should get a success message {string}")
    public void iShouldGetASuccessMessage(String successMessage) {
        Assert.assertEquals(new TopMenuPage().verifySuccessMessage(), successMessage, "Invalid Message");
    }

    @And("I click on home button and verify that landed to {string} successfully")
    public void iClickOnButtonAndVerifyThatLandedToSuccessfully(String homePage) {
        new TopMenuPage().clickOnHomeButton();
        new TopMenuPage().navigateToHomePage(homePage);
    }

    //Test case 7
    @Then("I should navigate to test case page {string} Successfully")
    public void iShouldNavigateToTestCasePageSuccessfully(String testCasePage) {
        new TopMenuPage().navigateToTestCasePage(testCasePage);
    }
}
