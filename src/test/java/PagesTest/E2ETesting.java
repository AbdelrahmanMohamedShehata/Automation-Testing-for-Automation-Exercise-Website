package PagesTest;

import Data.PaymentData;
import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class E2ETesting {

    private WebDriver driver;
    DriverManager driverManager;
    ElementActions action = new ElementActions();

    @BeforeClass
    public void openBrowser(){
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();

    }

    SoftAssert soft = new SoftAssert();
    HomePage home = new HomePage();

    @Test
    public void verifyHomePage (){
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error Msg : assert 1");

        String expectedTitle = "AutomationExercise";
        String actualTitle = action.getText(home.getAutomationExerciseText(driver));
        soft.assertEquals(actualTitle, expectedTitle,"error Msg : assert 2");

        soft.assertAll();

    }

    ProductsPage products = new ProductsPage();

    @Test (dependsOnMethods = "verifyHomePage")
    public void validateNavigationToProductsPage() {
        action.Click(products.ProductsButton(driver));
        String expectedUrl = "https://www.automationexercise.com/products";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error Msg : assert1 ");

        String expectedOutput = "ALL PRODUCTS";
        String actualOutput = action.getText(products.getAllProductsText(driver));
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 2");
        soft.assertAll();
    }

    ProductPage product = new ProductPage();

    @Test (dependsOnMethods = "validateNavigationToProductsPage")
    public void navigateToProductPage() {
        action.Click(products.clickViewProduct(driver));
        String expectedUrl = "https://www.automationexercise.com/product_details/30";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @Test (dependsOnMethods = "navigateToProductPage")
    public void AddedProductToCartSuccessfully (){
        String expectedName = "Your product has been added to cart.";
        product.changeProductQuantity(driver,"2");
        action.Click(product.addProductToCart(driver));
        String actualName = action.getText(product.addedProductToCartConfirmation(driver));
        soft.assertEquals(actualName,expectedName,"error message : assert 1 add product to cart Successfully");
        soft.assertAll();

    }

    @Test (dependsOnMethods = "AddedProductToCartSuccessfully")
    public void navigateTOViewCartPage (){
        String expectedUrl ="https://www.automationexercise.com/view_cart";
        action.Click(product.clickOnViewCartButton(driver));
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    CartPage cart = new CartPage();

    @Test (dependsOnMethods = "navigateTOViewCartPage")
    public void validateShoppingCartPage (){
        String expectedName = "Shopping Cart";
        String actualName = action.getText(cart.getShoppingCartText(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test (dependsOnMethods = "validateShoppingCartPage")
    public void getLoginMsgINCartPage (){
        action.Click(cart.clickOnCheckoutButton(driver));
        String expectedMsg = "Register / Login account to proceed on checkout.";
        String actualMsg = action.getText(cart.getLoginMsgToContinuePaymentProcess(driver));
        soft.assertTrue(actualMsg.contains(expectedMsg),"error message : assert 1");
    }

    LoginPage loginPage = new LoginPage();

    @Test (dependsOnMethods = "getLoginMsgINCartPage")
    public void LoginWithRegisteredEmail(){
        action.Click(cart.clickOnLoginRegisterButtonInCartPage(driver));
        loginPage.loginSteps(driver, loginCradintials.getLoggedEmail(),loginCradintials.getPassword());

        String expectedText = "Logged in as";
        String actualText = action.getText(loginPage.getLoggedInAsText(driver));
        System.out.println("actual :"+ actualText);
        soft.assertTrue(actualText.contains(expectedText),"error message : assert 3");

    }

    CheckoutPage checkout = new CheckoutPage();

    @Test (dependsOnMethods = "LoginWithRegisteredEmail")
    public void getCheckoutLink (){
        action.Click(product.clickOnCartButton(driver));
        action.Click(cart.clickOnCheckoutButton(driver));
        String expectedUrl = "https://www.automationexercise.com/checkout";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");

        String expectedName = "Checkout";
        String actualName = action.getText(checkout.getCheckoutText(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 2");

    }

    PaymentPage payment = new PaymentPage();

    @Test (dependsOnMethods = "getCheckoutLink")
    public void getPaymentPageLink (){
        action.Click(checkout.clickOnPlaceOrderButton(driver));
        String expectedUrl = "https://www.automationexercise.com/payment";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @Test (dependsOnMethods = "getPaymentPageLink")
    public void getPaymentText (){
        String expectedName = "Payment";
        String actualName = action.getText(payment.getPaymentText(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    PaymentData paymentData = new PaymentData();

    @Test (dependsOnMethods = "getPaymentText")
    public void OrderMadeSuccessfully (){

        String expectedMsg = "ORDER PLACED!";
        payment.PaymentSteps(driver,paymentData.getNameOnCard(),paymentData.getCardNumber(),
                paymentData.getCVC(),paymentData.getExpirationMonth(),paymentData.getExpirationYear());

        String actualMsg = action.getText(payment.orderPlacedMessage(driver));
        soft.assertEquals(actualMsg, expectedMsg,"error message : assert 1");

        String expectedMessage = "Congratulations! Your order has been confirmed!";
        String actualMessage = action.getText(payment.orderConfirmation(driver));
        soft.assertTrue(actualMessage.contains(expectedMessage),"error message : assert 2");

        soft.assertAll();
    }

    @Test (dependsOnMethods = {"OrderMadeSuccessfully"})
    public void clickOnLogoutButton () {

        String expectedUrl = "https://www.automationexercise.com/login";
        action.Click(payment.clickOnLogoutButton(driver));
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl, expectedUrl, "error message : assert 1");

    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
