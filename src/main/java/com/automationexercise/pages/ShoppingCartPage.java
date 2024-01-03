package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//td[@class = 'cart_description']/h4/a")
    List<WebElement> cartProductsList;

    @CacheLookup
    @FindBy(xpath = "//td[@class = 'cart_price']/p")
    List<WebElement> cartProductPriceList;

    @CacheLookup
    @FindBy(xpath = "//td[@class = 'cart_quantity']/button")
    List<WebElement> cartProductQuantityList;

    @CacheLookup
    @FindBy(xpath = "//td[@class = 'cart_total']/p")
    List<WebElement> cartProductTotalPriceList;

    @CacheLookup
    @FindBy(xpath = "//li[@class='active']")
    WebElement shoppingCartWelcomeText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    WebElement registerLoginLink;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-times']")
    WebElement removeButton;

    @CacheLookup
    @FindBy(xpath = "(//span[@id='empty_cart'])[1]")
    WebElement message;


    public String getProductNameFromCart(String productName) {
        for (WebElement p : cartProductsList) {
            if (p.getText().equalsIgnoreCase(productName)) {
                log.info("Getting products name" + productName + " from shopping cart : " + cartProductsList.toString());
                return productName;
            }
        }
        return "Product Not Found";
    }

    public String getProductPriceFromCart(String productPrice) {
        for (WebElement p : cartProductPriceList) {
            if (p.getText().equalsIgnoreCase(productPrice)) {
                log.info("Getting products price name" + productPrice + " from shopping cart : " + cartProductPriceList.toString());
                return productPrice;
            }
        }
        return "Product price Not Found";
    }

    public String getProductQuantityFromCart(String productQuantity) {
        for (WebElement p : cartProductQuantityList) {
            if (p.getText().equalsIgnoreCase(productQuantity)) {
                log.info("Getting products price name" + productQuantity + " from shopping cart : " + cartProductQuantityList.toString());
                return productQuantity;
            }
        }
        return "Product Quantity Not Found";
    }

    public String getProductTotalPriceFromCart(String productTotalPrice) {
        for (WebElement p : cartProductTotalPriceList) {
            if (p.getText().equalsIgnoreCase(productTotalPrice)) {
                log.info("Getting products price name" + productTotalPrice + " from shopping cart : " + cartProductTotalPriceList.toString());
                return productTotalPrice;
            }
        }
        return "Product Total price Not Found";
    }

    public String verifyShoppingCartWelcomeText() {
        String text = getTextFromElement(shoppingCartWelcomeText);
        log.info("Getting welcome text from shopping cart page : " + shoppingCartWelcomeText.toString());
        return text;
    }

    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
        log.info("Clicking on proceed to checkout button : " + checkoutButton.toString());
    }

    public void clickOnRegisterLoginLinkOnCheckoutPopup() {
        clickOnElement(registerLoginLink);
    }

    public void clickOnCrossButtonToRemoveProduct() {
        clickOnElement(removeButton);
        log.info("Clicking on cross button to remove the product from cart : " + removeButton.toString());
    }

    public void verifyThatCartIsEmpty() {
        String text = getTextFromElement(message);
        log.info("Getting cart empty text : " + message.toString());
    }
}
