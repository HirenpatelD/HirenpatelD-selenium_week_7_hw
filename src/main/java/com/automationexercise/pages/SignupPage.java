package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class SignupPage extends Utility {
    private static final Logger log = LogManager.getLogger(SignupPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupText;

    @CacheLookup
    @FindBy(name = "name")
    WebElement enterName;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement signupButton;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement errorMessage;

    public String verifyNewUserSignupText() {
        String text = getTextFromElement(newUserSignupText);
        log.info("Getting text : " + newUserSignupText);
        return text;
    }

    public void enterName(String name) {
        sendTextToElement(enterName, name);
        log.info("Enter name : " + name + " to name field " + enterName);
    }

    final String randomEmail = randomEmail();

    public void enterEmail() {
        sendTextToElement(enterEmail, randomEmail);
        log.info("Enter email : " + randomEmail + " in email field " + enterEmail.toString());
    }

    public static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    public void enterEmailAddress(String email) {
        sendTextToElement(enterEmail, email);
        log.info("Enter email : " + email + " in email field " + enterEmail.toString());
    }


    public void clickOnSignupButton() {
        clickOnElement(signupButton);
        log.info("Clicking on login button : " + signupButton);
    }

    public void enterAlreadyExistEmail(String email) {
        sendTextToElement(enterEmail, email);
        log.info("Enter email : " + email + " in email field " + enterEmail.toString());
    }

    public String verifyErrorMessage() {
        String message = getTextFromElement(errorMessage);
        log.info("Getting error message : " + errorMessage);
        return message;
    }

}
