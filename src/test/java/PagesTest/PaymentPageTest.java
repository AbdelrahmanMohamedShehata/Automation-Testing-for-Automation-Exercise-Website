package PagesTest;

import Data.PaymentData;
import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class PaymentPageTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductsPage products = new ProductsPage();
    ElementActions action ;
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();
    CheckoutPage checkout = new CheckoutPage();
    PaymentPage payment = new PaymentPage();

    @BeforeClass
    public void openBrowser(){
        action = new ElementActions();
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();
        action.Click(home.navigateToLoginPage(driver));
        loginPage.loginSteps(driver, loginCradintials.getLoggedEmail(),loginCradintials.getPassword());
        action.Click(products.ProductsButton(driver));
        products.searchForProductSteps(driver);
        action.Click(products.clickViewProduct(driver));
        product.changeProductQuantity(driver,"2");
        action.Click(product.addProductToCart(driver));
        action.Click(product.clickOnViewCartButton(driver));
        action.Click(cart.clickOnCheckoutButton(driver));
        action.Click(checkout.clickOnPlaceOrderButton(driver));
    }

    SoftAssert soft = new SoftAssert();
    PaymentData paymentData = new PaymentData();

    @Test
    public void getPaymentPageLink (){
        String expectedUrl = "https://www.automationexercise.com/payment";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @Test (dependsOnMethods = {"getPaymentPageLink"})
    public void getPaymentText (){
        String expectedName = "Payment";
        String actualName = action.getText(payment.getPaymentText(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test (dependsOnMethods = {"getPaymentText"})
    public void OrderMadeSuccessfully (){
        String expectedMsg = "ORDER PLACED!";
        payment.PaymentSteps(driver,paymentData.getNameOnCard(),paymentData.getCardNumber(),
                paymentData.getCVC(),paymentData.getExpirationMonth(),paymentData.getExpirationYear());

        String actualMsg = action.getText(payment.orderPlacedMessage(driver));
        soft.assertEquals(actualMsg, expectedMsg,"error message : assert 1");

        String expectedMessage = "Congratulations! Your order has been confirmed!";
        String actualMessage = action.getText(payment.orderConfirmation(driver));
        soft.assertEquals(actualMessage, expectedMessage,"error message : assert 1");

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
