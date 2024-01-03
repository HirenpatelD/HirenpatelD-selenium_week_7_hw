package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class PaymentPage extends Utility {

    private static final Logger log = LogManager.getLogger(PaymentPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCard;

    @CacheLookup
    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='ex. 311']")
    WebElement CVC;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='MM']")
    WebElement expirationMonth;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='YYYY']")
    WebElement expirationYear;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submit']")
    WebElement payAndConfirmButton;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    WebElement confirmationMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    WebElement invoiceButton;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;

    public void sendPaymentDetails(String name, String number, String CVCNumber, String Month, String Year) {
        sendTextToElement(nameOnCard, name);
        log.info("Enter name " + name + " to Name on Card field : " + nameOnCard.toString());
        sendTextToElement(cardNumber, number);
        log.info("Enter card number " + number + " to Card Number : " + cardNumber.toString());
        sendTextToElement(CVC, CVCNumber);
        log.info("Enter CVC " + CVCNumber + " to CVC field : " + CVC.toString());
        sendTextToElement(expirationMonth, Month);
        log.info("Enter month " + Month + " to Month field : " + expirationMonth.toString());
        sendTextToElement(expirationYear, Year);
        log.info("Enter Year " + Year + " to Year field : " + expirationYear.toString());
    }

    public void clickOnPayAndConfirmOrderButton() {
        clickOnElement(payAndConfirmButton);
        log.info("Clicking on Pay and Confirm Order button : " + payAndConfirmButton.toString());
    }

    public String verifyOrderConfirmationMessage() {
        log.info("Getting order confirmation message : " + confirmationMessage.toString());
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnDownloadInvoiceButtonAfterOrderSuccessMessage() {
        clickOnElement(invoiceButton);
        log.info("Click on download invoice button : " + invoiceButton.toString());
    }

    public void verifyDownloadedFile() {
        Map<String, Object> fileMap = new HashMap<>();
        fileMap.put("fileName", "...the file name...");
        ((JavascriptExecutor) driver).executeScript("tb:fileExists", fileMap);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        log.info("Click on continue button after order success message : " + continueButton.toString());
    }
}
