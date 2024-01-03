package com.automationexercise.pages;

import com.automationexercise.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//a[@href='/products']")
    WebElement products;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'productinfo text-center']/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/p")
    List<WebElement> listOfProducts;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement viewProduct;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    WebElement productCategory;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Rs. 500']")
    WebElement productPrice;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-details']//p[2]")
    WebElement productAvailability;

    @CacheLookup
    @FindBy(xpath = "//body//section//p[3]")
    WebElement productCondition;

    @CacheLookup
    @FindBy(xpath = "//body//section//p[4]")
    WebElement productBrand;

    @CacheLookup
    @FindBy(id = "search_product")
    WebElement searchProductsBox;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    WebElement searchedProductsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'single-products']/div/p")
    WebElement searchedProductsName;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement clickContinueShopping;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement clickViewCart;

    @CacheLookup
    @FindBy(xpath = "//input[@id='quantity']")
    WebElement productQuantity;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLinkInSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//td[@class = 'cart_quantity']/button")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Women']")
    WebElement womenTabInCategory;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Men']")
    WebElement menTabInCategory;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Kids']")
    WebElement kidsTabInCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'Women']/div/ul/li/a")
    List<WebElement> womenSubMenuList;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'Men']/div/ul/li/a")
    List<WebElement> menSubMenuList;

    @CacheLookup
    @FindBy(xpath = "//h2[@class = 'title text-center']")
    WebElement subMenuPageTitle;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Brands']")
    WebElement brandText;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'nav nav-pills nav-stacked']/li/a")
    List<WebElement> brandsList;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Brand - Madame Products']")
    WebElement madameBrand;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Brand - Polo Products']")
    WebElement poloBrand;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    WebElement poloBrandText;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    WebElement madameBrandText;

    @CacheLookup
    @FindBy(id = "name")
    WebElement nameField;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "review")
    WebElement addReviewField;

    @CacheLookup
    @FindBy(id = "button-review")
    WebElement reviewSubmitButton;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Thank you for your review.']")
    WebElement thankYouForReviewMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    By downloadInvoiceButton = By.xpath("//a[normalize-space()='Download Invoice']");


    public void clickOnProducts() {
        clickOnElement(products);
        log.info("Clicking on products button : " + products.toString());
    }

    public String navigateToAllProductPage(String url) {
        driver.navigate().to(url);
        System.out.println("Home Page URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        return driver.getCurrentUrl();
    }

    public void gettingListOfProducts() {
        List<WebElement> elements = productList;
        ArrayList<String> originalElementList = new ArrayList<>();
        for (WebElement e : elements) {
            originalElementList.add(e.getText());
        }
        System.out.println(originalElementList);
        log.info("Getting List of Product: " + productList.toString());
    }

    public void clickOnViewProductOnFirstProduct() {
        javaExecutorScriptExecuteScriptToPerformScroll();
        javaExecutorScriptExecuteScriptToClick(viewProduct);
        log.info("Clicking on view product button : " + viewProduct.toString());
    }

    public String navigateToProductDetailPage(String url) {
        driver.navigate().to(url);
        System.out.println("Home Page URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String verifyProductName() {
        String PName = getTextFromElement(productName);
        log.info("Getting Product Product: " + productName.toString());
        return PName;
    }

    public String verifyProductCategory() {
        String PCategory = getTextFromElement(productCategory);
        log.info("Getting category of Product: " + productCategory.toString());
        return PCategory;
    }

    public String verifyProductPrice() {
        String PPrice = getTextFromElement(productPrice);
        log.info("Getting price of Product: " + productPrice.toString());
        return PPrice;
    }

    public String verifyProductAvailability() {
        String PAvailability = getTextFromElement(productAvailability);
        log.info("Getting availability of Product: " + productAvailability.toString());
        return PAvailability;
    }

    public String verifyProductCondition() {
        String PCondition = getTextFromElement(productCondition);
        log.info("Getting condition of Product: " + productCondition.toString());
        return PCondition;
    }

    public String verifyProductBrand() {
        String PBrand = getTextFromElement(productBrand);
        log.info("Getting brand of Product: " + productBrand.toString());
        return PBrand;
    }

    public void enterProductNameToSearchBar(String product) {
        sendTextToElement(searchProductsBox, product);
        log.info("Enter product name: " + product + " to search box : " + searchProductsBox.toString());
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
        log.info("Clicking on the search button : " + searchButton.toString());
    }

    public String verifySearchedProductsText() {
        String text = getTextFromElement(searchedProductsText);
        log.info("Getting Searched Products text : " + searchedProductsText.toString());
        return text;
    }

    public String getSearchedProductName() {
        log.info("Getting Searched Product name : " + searchedProductsName.toString());
        System.out.println("searched products name: " + searchedProductsName);
        return getTextFromElement(searchedProductsName);
    }

    public void clickOnDismissAlertButton() {
        driver.switchTo().alert().dismiss();
    }

    public void mouseHoverAndClickAddToCartOnProduct(String product) {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(recommendedItemsText);
        javaExecutorScriptExecuteScriptToClick(addToCart);
        for (WebElement pr : productList) {
            if (pr.getText().equalsIgnoreCase(product)) {
                mouseHoverToElement(pr);
                log.info("Hovering mouse over " + product + " : " + productList.toString());
                try {
                    addToCart.click();
                } catch (Exception e) {
                    javaExecutorScriptExecuteScriptToClick(addToCart);
                }
                log.info("Click on " + product + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }

    public void clickOnContinueShoppingButton() {
        javaExecutorScriptExecuteScriptToClick(clickContinueShopping);
        log.info("Clicking on add to cart button : " + clickContinueShopping.toString());
    }


    public void clickOnViewCartButton() {
        clickOnElement(clickViewCart);
        log.info("Clicking on view cart button : " + clickViewCart.toString());
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        log.info("Clicking on add to cart button : " + addToCartButton.toString());
    }

    public void enterQuantity(String quantity) {
        clearTextFromField(productQuantity);
        sendTextToElement(productQuantity, quantity);
        log.info("Changing the quantity : " + productQuantity.toString());
    }

    public void clickOnViewCartLinkInSuccessMessage() {
        clickOnElement(viewCartLinkInSuccessMessage);
        log.info("Clicking on the view cart link in success message : " + viewCartLinkInSuccessMessage.toString());
    }

    public String verifyQuantity() {
        String qty = getTextFromElement(quantity);
        log.info("Getting quantity from shopping cart page : " + quantity.toString());
        return qty;
    }

    public void clickOnCategory(String category) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        if (category.equalsIgnoreCase("Men")) {
            clickOnElement(menTabInCategory);
            log.info("Clicking on Men category : " + menTabInCategory.toString());
        } else if (category.equalsIgnoreCase("Women")) {
            clickOnElement(womenTabInCategory);
            log.info("Clicking on Women category : " + womenTabInCategory.toString());
        } else if (category.equalsIgnoreCase("Child")) {
            clickOnElement(kidsTabInCategory);
            log.info("Clicking on Kids category : " + kidsTabInCategory.toString());
        } else {
            System.out.println("Category is not available");
        }
    }

    public void clickOnSubCategoryOfWomen(String womenSubCategory) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        for (WebElement s : womenSubMenuList) {
            if (s.getText().equalsIgnoreCase(womenSubCategory)) {
                clickOnElement(s);
                log.info("Clicking on " + womenSubCategory + " of women sub category : " + womenSubMenuList.toString());
                break;
            } else {
                System.out.println("Sub category is not available");
            }
        }
    }

    public void clickOnSubCategoryOfMen(String menSubCategory) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        for (WebElement s : menSubMenuList) {
            if (s.getText().equalsIgnoreCase(menSubCategory)) {
                clickOnElement(s);
                log.info("Clicking on " + menSubCategory + " of men sub category : " + menSubMenuList.toString());
                break;
            } else {
                System.out.println("Sub category is not available");
            }
        }
    }

    public String getSubMenuPageTitle() {
        String text = getTextFromElement(subMenuPageTitle);
        log.info("Getting Sub Menu Page Title : " + subMenuPageTitle.toString());
        return text;
    }

    public String navigateToCategoryPage(String url) {
        driver.navigate().to(url);
        System.out.println("Category Page URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public void clickOnBrandOnBrandsTab(String brand) {
        javaExecutorScriptExecuteScriptToPerformScroll();
        for (WebElement b : brandsList) {
            System.out.println(b);
            if (b.getText().equalsIgnoreCase(brand)) {
                b.click();
                log.info("Clicking on " + brand + " in Brands tab : " + brandsList.toString());
                break;
            } else {
                System.out.println("Brand name is not available");
            }
        }
    }

    public String verifyBrandName() {
        String text = getTextFromElement(brandText);
        log.info("Getting brand text : " + brandText.toString());
        return text;
    }

    public void clickOnPoloBrand() {
        javaExecutorScriptExecuteScriptToPerformScroll();
        mouseHoverToElementAndClick(poloBrandText);
    }

    public void clickOnMadameBrand() {
        javaExecutorScriptExecuteScriptToPerformScroll();
        mouseHoverToElementAndClick(madameBrandText);
    }

    public String getPoloBrandPageTitle() {
        String text = getTextFromElement(poloBrand);
        log.info("Getting Brand Page Title : " + poloBrand.toString());
        return text;
    }

    public String getBibaBrandPageTitle() {
        String txt = getTextFromElement(madameBrand);
        log.info("Getting Brand Page Title : " + madameBrand.toString());
        return txt;
    }


    public void sendNameToYourNameField(String name) {
        sendTextToElement(nameField, name);
        log.info("Enter name " + name + " to your name field : " + nameField.toString());
    }

    public void sendEmailToEmailAddressField(String email) {
        sendTextToElement(emailField, email);
        log.info("Enter email " + email + " to email field : " + emailField.toString());
    }

    public void sendReviewToAddReviewField(String review) {
        sendTextToElement(addReviewField, review);
        log.info("Enter review " + review + " to add review field : " + addReviewField.toString());
    }

    public void clickOnReviewSubmitButton() {
        javaExecutorScriptExecuteScriptToClick(reviewSubmitButton);
        log.info("Clicking on the review submit button : " + reviewSubmitButton.toString());
    }

    public String getThankYouForReviewMessage() {
        String msg = getTextFromElement(thankYouForReviewMessage);
        log.info("Getting thank you for review message test : " + thankYouForReviewMessage.toString());
        return msg;
    }

    public void clickOnDownloadInvoiceButtonAndVerify() throws InterruptedException {
        log.info("Click on download invoice : " + downloadInvoiceButton.toString());
        seleniumDownloadFile(downloadInvoiceButton);

    }
}