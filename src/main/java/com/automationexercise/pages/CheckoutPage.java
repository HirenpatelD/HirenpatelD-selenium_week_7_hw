package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {

    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    WebElement addressDetailsText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
    WebElement reviewYourOrderText;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentArea;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text() , 'Place Order')]")
    WebElement placeOrderButton;

    @CacheLookup
    @FindBy(xpath = "(//li[@class='address_address1 address_address2'][normalize-space()='12, Bhavnath'])[1]")
    WebElement deliveryAddress;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][normalize-space()='12, Bhavnath']")
    WebElement billingAddress;


    public String verifyTextOnCheckoutPage(String text) {
        if (text.equalsIgnoreCase("Address Details")) {
            log.info("Getting " + text + " : " + addressDetailsText.toString());
            return getTextFromElement(addressDetailsText);
        } else if (text.equalsIgnoreCase("Review Your Order")) {
            log.info("Getting " + text + " : " + reviewYourOrderText.toString());
            return getTextFromElement(reviewYourOrderText);
        } else {
            return "Text is not displayed";
        }
    }

    public void sendTextToCommentArea(String comment) {
        sendTextToElement(commentArea, comment);
        log.info("Sending text to comment area : " + commentArea.toString());
    }

    public void clickOnPlaceOrderButton() {
        //clickOnElement(placeOrderButton);
        try {
            placeOrderButton.click();
        } catch (Exception e) {
            javaExecutorScriptExecuteScriptToClick(placeOrderButton);
        }
        log.info("Clicking on Place Order button : " + placeOrderButton.toString());
    }

    public String verifyDeliveryAddress() {
        String dAddress = getTextFromElement(deliveryAddress);
        log.info("Getting " + dAddress + " : " + deliveryAddress.toString());
        return dAddress;
    }

    public String verifyBillingAddress() {
        String bAddress = getTextFromElement(billingAddress);
        log.info("Getting " + bAddress + " : " + billingAddress.toString());
        return bAddress;
    }
}
