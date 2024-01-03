package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.PaymentPage;
import com.automationexercise.pages.ProductPage;
import com.automationexercise.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductPageSteps {

    //Test case 8
    @When("I click on Products button")
    public void iClickOnProductsButton() {
        new ProductPage().clickOnProducts();
    }

    @Then("I should navigated to all products {string} page successfully")
    public void iShouldNavigatedToAllProductsPageSuccessfully(String productPage) {
        new ProductPage().navigateToAllProductPage(productPage);
    }

    @And("I should get The products list")
    public void iShouldGetTheProductsList() {
        new ProductPage().gettingListOfProducts();
    }

    @And("I Click on View Product of first product")
    public void iClickOnViewProductOfFirstProduct() {
        new ProductPage().clickOnViewProductOnFirstProduct();
    }

    @And("I should landed to {string}")
    public void iShouldLandedTo(String Url) {
        new ProductPage().navigateToProductDetailPage(Url);
    }

    @Then("I should get a product name {string}, category {string}, price {string}, availability {string}, condition {string}, brand {string}")
    public void iShouldGetAProductNameCategoryPriceAvailabilityConditionBrand(String productName, String category, String price, String availability, String condition, String brand) {
        Assert.assertEquals(new ProductPage().verifyProductName(), productName, "Incorrect name");
        Assert.assertEquals(new ProductPage().verifyProductCategory(), category, "Incorrect category");
        Assert.assertEquals(new ProductPage().verifyProductPrice(), price, "Incorrect price");
        Assert.assertEquals(new ProductPage().verifyProductAvailability(), availability, "Incorrect text");
        Assert.assertEquals(new ProductPage().verifyProductCondition(), condition, "Incorrect text");
        Assert.assertEquals(new ProductPage().verifyProductBrand(), brand, "Incorrect brand");
    }

    //Test case 9

    @And("I enter product name {string} in search input and click search button")
    public void iEnterProductNameInSearchInputAndClickSearchButton(String product) {
        new ProductPage().enterProductNameToSearchBar(product);
        new ProductPage().clickOnSearchButton();
    }

    @Then("I should get search product title {string}")
    public void iShouldGetSearchProductTitle(String title) {
        Assert.assertEquals(new ProductPage().verifySearchedProductsText(), title, "Incorrect title");
    }

    @Then("I should see all the products related to search product {string}")
    public void iShouldSeeAllTheProductsRelatedToSearchProduct(String productName) {
        Assert.assertEquals(new ProductPage().getSearchedProductName(), productName, "Incorrect product name");
    }

    //Test Case 12

    @And("I hover over {string} product and click Add to cart")
    public void iHoverOverFirstProductAndClickAddToCart(String product) {
        new ProductPage().mouseHoverAndClickAddToCartOnProduct(product);
    }

    @And("I click Continue Shopping button")
    public void iClickContinueShoppingButton() {
        new ProductPage().clickOnContinueShoppingButton();
        new ProductPage().clickOnDismissAlertButton();
    }

//    @And("I hover over {string}  product and click Add to cart")
//    public void iHoverOverSecondProductAndClickAddToCart(String product) {
//        new ProductPage().mouseHoverAndClickAddToCartOnProduct(product);
//    }

    @And("I Click View Cart button")
    public void iClickViewCartButton() {
        new HomePage().clickOnViewCartLink();
    }

    @Then("I should see both products {string}  are added to Cart")
    public void iShouldSeeBothProductsAreAddedToCart(String product) {
        new ShoppingCartPage().getProductNameFromCart(product);
    }

    @Then("I should see their {string} , {string} and {string}")
    public void iShouldSeeTheirAnd(String price, String quantity, String totalPrice) {
        new ShoppingCartPage().getProductPriceFromCart(price);
        new ShoppingCartPage().getProductQuantityFromCart(quantity);
        new ShoppingCartPage().getProductTotalPriceFromCart(totalPrice);
    }

    //Test case 13

    @And("I increase the quantity {string}")
    public void iIncreaseTheQuantity(String qty) {
        new ProductPage().enterQuantity(qty);
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @And("I click on view cart link in success message")
    public void iClickOnViewCartLinkInSuccessMessage() {
        new ProductPage().clickOnViewCartButton();
    }

    @Then("I should see that product is displayed in cart page with exact quantity {string}")
    public void iShouldSeeThatProductIsDisplayedInCartPageWithExactQuantity(String qtyValue) {
        Assert.assertEquals(new ProductPage().verifyQuantity(), qtyValue, "Incorrect Quantity");
    }

    //Test case 17

    @And("I click X button corresponding to particular product")
    public void iClickXButtonCorrespondingToParticularProduct() {
        new ShoppingCartPage().clickOnCrossButtonToRemoveProduct();
    }

    @Then("I should get the empty cart")
    public void iShouldGetTheEmptyCart() {
        new ShoppingCartPage().verifyThatCartIsEmpty();
    }

    //Test case 18
    @Then("I click on {string} category")
    public void iClickOnCategory(String category) {
        new ProductPage().clickOnCategory(category);
    }

    @And("I click on {string} in women category")
    public void iClickOnInWomenCategory(String womenSubCategory) {
        new ProductPage().clickOnSubCategoryOfWomen(womenSubCategory);
    }

    @And("I should see {string} page title")
    public void iShouldSeePageTitle(String title) {
        Assert.assertEquals(new ProductPage().getSubMenuPageTitle(), title, "Incorrect Text");
    }

    @And("I click on {string} in men category")
    public void iClickOnInMenCategory(String menSubCategory) {
        new ProductPage().clickOnSubCategoryOfMen(menSubCategory);
    }

    @Then("I should navigated to {string} that category page")
    public void iShouldNavigatedToThatCategoryPage(String Url) {
        new ProductPage().navigateToCategoryPage(Url);
    }

    //Test case 19
    @Then("I click on {string} brand in Brands tab")
    public void iClickOnBrandInBrandsTab(String brand) {
        new ProductPage().clickOnBrandOnBrandsTab(brand);
    }

    @Then("I click on polo brand in Brands tab")
    public void iClickOnPoloBrandInBrandsTab() {
        new ProductPage().clickOnPoloBrand();
    }

    @And("I click on madame brand in Brands tab")
    public void iClickOnMadameBrandInBrandsTab() {
        new ProductPage().clickOnMadameBrand();
    }

    @And("I should see polo {string} page title")
    public void iShouldSeePoloPageTitle(String polo) {
        Assert.assertEquals(new ProductPage().getPoloBrandPageTitle(), polo, "Incorrect Text");
    }

    @Then("I should see madame {string} page title")
    public void iShouldSeeMadamePageTitle(String madame) {
        Assert.assertEquals(new ProductPage().getBibaBrandPageTitle(), madame, "Incorrect Text");
    }

    //Test case 20
    @Then("I verify the product {string} in shopping cart")
    public void iVerifyTheProductInShoppingCart(String productName) {
        Assert.assertEquals(new ShoppingCartPage().getProductNameFromCart(productName), productName);
    }

    //Test case 21
    @And("I enter {string} name in your name field")
    public void iEnterNameInYourNameField(String name) {
        new ProductPage().sendNameToYourNameField(name);
    }

    @And("I enter {string} email in email address field")
    public void iEnterEmailInEmailAddressField(String email) {
        new ProductPage().sendEmailToEmailAddressField(email);
    }

    @And("I enter {string} message to review here field")
    public void iEnterMessageToReviewHereField(String review) {
        new ProductPage().sendReviewToAddReviewField(review);

    }

    @And("I click on review submit button")
    public void iClickOnReviewSubmitButton() {
        new ProductPage().clickOnReviewSubmitButton();
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        Assert.assertEquals(new ProductPage().getThankYouForReviewMessage(), message, "Incorrect message");
    }

    //Test case 22
    @When("I scroll down up to recommended items text")
    public void iScrollDownUpToRecommendedItemsText() {
        new HomePage().scrollDownToRecommendedItems();
    }

    @Then("I should see {string} text")
    public void iShouldSeeText(String text) {
        Assert.assertEquals(new HomePage().getRecommendedItemText(), text, "Incorrect Details");
    }

    @And("I add product to the cart from recommended product")
    public void iAddProductToTheCartFromRecommendedProduct() {
        new HomePage().addProductFromRecommendedProductToTheCart();
    }

    //Test case 24
    @And("I click on download invoice and verify the Invoice is downloaded")
    public void iClickOnDownloadInvoice() {
        new PaymentPage().clickOnDownloadInvoiceButtonAfterOrderSuccessMessage();
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        new PaymentPage().clickOnContinueButton();
    }

    @And("I verify the Invoice is downloaded")
    public void iVerifyTheInvoiceIsDownloaded() throws InterruptedException {
        new ProductPage().clickOnDownloadInvoiceButtonAndVerify();
    }
}
