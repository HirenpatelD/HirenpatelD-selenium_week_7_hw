package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginText;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Password'])[1]")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = " //button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']\n")
    WebElement getErrorMessage;

    public String verifyLoginToYourAccountText() {
        String text = getTextFromElement(loginText);
        log.info("Getting text : " + loginText);
        return text;
    }

    public void enterEmailAddress(String email) {
        sendTextToElement(enterEmail, email);
        log.info("Enter email: " + email + " to email field " + enterEmail);
    }

    public void enterPassword(String password) {
        sendTextToElement(enterPassword, password);
        log.info("Enter password: " + password + " to password field " + enterPassword);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Clicking on login button : " + loginButton);
    }

    public String verifyTheErrorMessage() {
        String msg = getTextFromElement(getErrorMessage);
        log.info("Getting error message : " + getErrorMessage);
        return msg;
    }

    public String navigateToLoginPage(String Url) {
        driver.navigate().to(Url);
        System.out.println("Current login page URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}
