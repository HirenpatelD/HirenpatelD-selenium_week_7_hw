package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends Utility {

    private static final Logger log = LogManager.getLogger(TopMenuPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement getText;

    @CacheLookup
    @FindBy(name = "name")
    WebElement enterName;

    @CacheLookup
    @FindBy(name = "email")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(name = "subject")
    WebElement enterSubject;

    @CacheLookup
    @FindBy(id = "message")
    WebElement enterMessage;

    @CacheLookup
    @FindBy(name = "upload_file")
    WebElement uploadFile;

    @CacheLookup
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Home']")
    WebElement homeButton;


    public void selectOption(String option) {
        WebElement optionList = driver.findElement(By.linkText(option));
        Actions actions = new Actions(driver);
        actions.moveToElement(optionList).click().build().perform();
        log.info("Select menu from : " + option + optionList.toString());
    }

    public String verifyGetInTouchText() {
        String text = getTextFromElement(getText);
        log.info("Getting message from : " + getText.toString());
        return text;
    }

    public void enterName(String name) {
        sendTextToElement(enterName, name);
        log.info("Enter Name : " + name + " to name field " + enterName.toString());
    }

    public void enterEmail(String email) {
        sendTextToElement(enterEmail, email);
        log.info("Enter email : " + email + " to email field " + enterEmail.toString());
    }

    public void enterSubject(String subject) {
        sendTextToElement(enterSubject, subject);
        log.info("Enter subject: " + subject + enterSubject.toString());
    }

    public void enterMessage(String message) {
        sendTextToElement(enterMessage, message);
        log.info("Enter message : " + message + enterMessage.toString());
    }

    public void uploadFile(String file) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        sendTextToElement(uploadFile, file);
        log.info("upload a file : " + file + " to choose file option " + uploadFile.toString());
    }

    public void clickOnSubmitButton() {
        clickOnElement(submitButton);
        log.info("Clicking on submit button : " + submitButton.toString());
    }

    public void clickOnOkAlertButton() {
        driver.switchTo().alert().accept();
    }

    public String verifySuccessMessage() {
        String message = getTextFromElement(successMessage);
        log.info("Getting message from : " + successMessage.toString());
        return message;
    }

    public void clickOnHomeButton() {
        clickOnElement(homeButton);
        log.info("Clicking on home button : " + homeButton.toString());
    }

    public String navigateToHomePage(String Url) {
        driver.navigate().to(Url);
        System.out.println("Current home page URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String navigateToTestCasePage(String url) {
        driver.navigate().to(url);
        System.out.println("Test case Page title: " + driver.getTitle());
        return driver.getCurrentUrl();
    }
}
