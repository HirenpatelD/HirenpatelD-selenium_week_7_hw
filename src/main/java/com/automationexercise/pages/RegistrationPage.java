package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterInfoText;

    @CacheLookup
    @FindBy(id = "id_gender1")
    WebElement selectMrTitle;

    @CacheLookup
    @FindBy(id = "id_gender2")
    WebElement selectMrsTitle;

    @CacheLookup
    @FindBy(id = "password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(id = "days")
    WebElement selectDay;

    @CacheLookup
    @FindBy(id = "months")
    WebElement selectMonth;

    @CacheLookup
    @FindBy(id = "years")
    WebElement selectYear;

    @CacheLookup
    @FindBy(xpath = " //label[normalize-space()='Sign up for our newsletter!']")
    WebElement clickNewsletter;


    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Receive special offers from our partners!']")
    WebElement clickOptin;

    @CacheLookup
    @FindBy(id = "first_name")
    WebElement enterFirstName;

    @CacheLookup
    @FindBy(id = "last_name")
    WebElement enterLastName;

    @CacheLookup
    @FindBy(id = "company")
    WebElement enterCompany;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement enterAddress1;

    @CacheLookup
    @FindBy(id = "address2")
    WebElement enterAddress2;

    @CacheLookup
    @FindBy(id = "country")
    WebElement selectCountry;

    @CacheLookup
    @FindBy(id = "state")
    WebElement enterState;

    @CacheLookup
    @FindBy(id = "city")
    WebElement enterCity;

    @CacheLookup
    @FindBy(id = "zipcode")
    WebElement enterZipcode;

    @CacheLookup
    @FindBy(id = "mobile_number")
    WebElement enterMobileNumber;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountButton;


    public String verifyEnterAccountInformationText() {
        String text = getTextFromElement(enterInfoText);
        log.info("Getting text : " + enterInfoText);
        return text;
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mrs")) {
            clickOnElement(selectMrsTitle);
            log.info("Selecting radio button against Mrs.");
        } else {
            clickOnElement(selectMrTitle);
            log.info("Selecting radio button against Mr.");
        }
    }

    public void enterAccountInformation(String password, String day, String month, String year) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        sendTextToElement(enterPassword, password);
        log.info("Enter password : " + password + " to password field " + enterPassword);
        selectByVisibleTextFromDropDown(selectDay, day);
        log.info("Select day of Birth : " + day + " from day dropdown " + selectDay);
        selectByVisibleTextFromDropDown(selectMonth, month);
        log.info("Select month of Birth : " + month + " from day dropdown " + selectMonth);
        selectByVisibleTextFromDropDown(selectYear, year);
        log.info("Select year of Birth : " + year + " from day dropdown " + selectYear);
    }

    public void selectNewsLetterCheckBox() {
        mouseHoverToElementAndClick(clickNewsletter);
        log.info("Clicking on checkbox : " + clickNewsletter);
    }

    public void selectReceiveSpecialOffersFromOurPartnersCheckBox() {
        mouseHoverToElementAndClick(clickOptin);
        log.info("Clicking on checkbox : " + clickOptin);
    }

    public void enterAddressInformation(String firstName, String lastName, String company, String address1, String address2,
                                        String country, String state, String city, String zipcode, String number) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        sendTextToElement(enterFirstName, firstName);
        log.info("Enter first name : " + firstName + " to First name field " + enterFirstName);
        sendTextToElement(enterLastName, lastName);
        log.info("Enter last name : " + lastName + " to Last name field " + enterLastName);
        sendTextToElement(enterCompany, company);
        log.info("Enter company : " + company + " to Company field " + enterCompany);
        sendTextToElement(enterAddress1, address1);
        log.info("Enter address: " + address1 + " to address1 field " + enterAddress1);
        sendTextToElement(enterAddress2, address2);
        log.info("Enter address: " + address2 + " to address2 field " + enterAddress2);
        selectByVisibleTextFromDropDown(selectCountry, country);
        log.info("select country : " + country + " from country dropdown " + selectCountry);
        sendTextToElement(enterState, state);
        log.info("Enter state : " + state + " to state field " + enterState);
        sendTextToElement(enterCity, city);
        log.info("Enter city : " + city + " to city field " + enterCity);
        sendTextToElement(enterZipcode, zipcode);
        log.info("Enter zipcode : " + zipcode + " to zipcode field " + enterZipcode);
        sendTextToElement(enterMobileNumber, number);
        log.info("Enter Mobile Number : " + number + " to contact number field " + enterMobileNumber);
    }

    public void clickOnCreateAccountButton() {
        try {
            javaExecutorScriptExecuteScriptToClick(createAccountButton);
        } catch (Exception exception) {
            javaExecutorScriptExecuteScriptToClick(createAccountButton);
        }
        log.info("Clicking on create account button : " + createAccountButton);
    }
}
