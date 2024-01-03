package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signupLoginButton;

    @CacheLookup
    @FindBy(xpath = " //li[10]//a[1]")
    WebElement usernameText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement arrowButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successfullySubscribeMessage;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    List<WebElement> headerTabs;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    @CacheLookup
    @FindBy(xpath = " //div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")
    WebElement product;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    WebElement bottomRightArrowButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement fullFledgedText;

    public void clickOnSignupLoginButton() {
        clickOnElement(signupLoginButton);
        log.info("Clicking on sign up / login button : " + signupLoginButton);
    }

    public String verifyLoggedInAsAUserNameText() {
        String text = getTextFromElement(usernameText);
        log.info("Getting text : " + usernameText);
        return text;
    }

    public void clickOnDeleteAccountButton() {
        clickOnElement(deleteButton);
        log.info("Clicking on Delete account button : " + deleteButton);
    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
        log.info("Clicking on logout button : " + logoutButton);
    }

    public String navigateToHomePage(String url) {
        driver.navigate().to(url);
        System.out.println("Home Page URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public void homePageVisibleSuccessfully() {
        System.out.println("Home Page Title: " + driver.getTitle());
    }

    public void scrollDownToFooter() {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(subscriptionText);
        log.info("Scroll down to footer until get text : " + subscriptionText.toString());
    }

    public String verifySubscriptionText() {
        String text = getTextFromElement(subscriptionText);
        log.info("Getting Subscription text : " + subscriptionText.toString());
        return text;
    }

    public void enterEmailToSubscriptionEmail(String email) {
        sendTextToElement(enterEmail, email);
        log.info("Enter email id " + email + " to subscription email field : " + enterEmail.toString());
    }

    public void clickOnArrowToSubscribe() {
        clickOnElement(arrowButton);
        log.info("Clicking on subscription arrow button : " + arrowButton.toString());
    }

    public String getSubscriptionSuccessMessage() {
        String message = getTextFromElement(successfullySubscribeMessage);
        log.info("Getting  subscribe message : " + successfullySubscribeMessage.toString());
        return message;
    }

    public void clickOnViewCartLink() {
        clickOnElement(viewCartLink);
        log.info("Clicking on view cart link after adding product to the cart : " + viewCartLink.toString());
    }

    public String getRecommendedItemText() {
        log.info("Getting recommended items text : " + recommendedItemsText.toString());
        return getTextFromElement(recommendedItemsText);
    }

    public void scrollDownToRecommendedItems() {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(recommendedItemsText);
        log.info("Scroll Down to recommended items");
    }

    public void addProductFromRecommendedProductToTheCart() {
        javaExecutorScriptExecuteScriptToClick(product);
        log.info("click on product " + product);
    }

    public void clickOnBottomRightArrowButton() {
       javaExecutorScriptExecuteScriptToClick(bottomRightArrowButton);
        log.info("Clicking on bottom right corner arrow button : " + bottomRightArrowButton.toString());
    }

    public void scrollUpToTop() {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(fullFledgedText);
        log.info("Scroll down to footer until get text : " + fullFledgedText.toString());
    }

    public String getFullFledgedText() {
        String text = getTextFromElement(fullFledgedText);
        log.info("Getting full fledged text from top of the page : " + fullFledgedText.toString());
        return text;
    }

}
