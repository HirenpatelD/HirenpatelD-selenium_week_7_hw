package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(AccountPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;
    //a[normalize-space()='Continue']

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedText;


    public String verifyAccountCreatedText() {
        String accountText = getTextFromElement(accountCreatedText);
        log.info("Getting text : " + accountCreatedText);
        return accountText;
    }

    public void clickOnContinueButton() {
        javaExecutorScriptExecuteScriptToClick(continueButton);
        log.info("Clicking on Continue button : " + continueButton);
    }

    public String verifyAccountDeletedText() {
        String accountDeleteText = getTextFromElement(accountDeletedText);
        log.info("Getting text : " + accountDeletedText);
        return accountDeleteText;
    }

}
