package PagesTest;

import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutPageTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductsPage products = new ProductsPage();
    ElementActions action ;
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();
    CheckoutPage checkout = new CheckoutPage();

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

    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void getCheckoutPageLink (){
        String expectedUrl = "https://www.automationexercise.com/checkout";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @Test
    public void getCheckoutText (){
        String expectedName = "Checkout";
        String actualName = action.getText(checkout.getCheckoutText(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test
    public void ValidateAddressFirstLastName (){
        String DeliveryAddressFirstLastName = action.getText(checkout.getDeliveryAddressFirstLastNameText(driver));
        String BillingAddressFirstLastName = action.getText(checkout.getBillingAddressFirstLastNameText(driver));
        soft.assertTrue(BillingAddressFirstLastName.contains(DeliveryAddressFirstLastName),"error message : assert 1");
    }

    @Test
    public void ValidateAddress1Address2 (){
        String DeliveryAddress1Address2Text = action.getText(checkout.getDeliveryAddress1Address2Text(driver));
        String BillingAddress1Address2Text = action.getText(checkout.getBillingAddress1Address2Text(driver));
        soft.assertTrue(BillingAddress1Address2Text.contains(DeliveryAddress1Address2Text),"error message : assert 1");
    }

    @Test
    public void ValidateAddressCityStatePostcodeText (){
        String DeliveryAddressCityStatePostcodeText = action.getText(checkout.getDeliveryAddressCityStatePostcodeText(driver));
        String BillingAddressCityStatePostcodeText = action.getText(checkout.getBillingAddressCityStatePostcodeText(driver));
        soft.assertTrue(BillingAddressCityStatePostcodeText.contains(DeliveryAddressCityStatePostcodeText),"error message : assert 1");
    }

    @Test
    public void ValidateAddressCountryName (){
        String DeliveryAddressCountryNameText = action.getText(checkout.getDeliveryAddressCountryNameText(driver));
        String BillingAddressCountryNameText = action.getText(checkout.getBillingAddressCountryNameText(driver));
        soft.assertTrue(BillingAddressCountryNameText.contains(DeliveryAddressCountryNameText),"error message : assert 1");
    }

    @Test
    public void ValidateAddressPhoneNumber (){
        String DeliveryAddressPhoneNumberText = action.getText(checkout.getDeliveryAddressPhoneNumberText(driver));
        String BillingAddressPhoneNumberText = action.getText(checkout.getBillingAddressPhoneNumberText(driver));
        soft.assertTrue(BillingAddressPhoneNumberText.contains(DeliveryAddressPhoneNumberText),"error message : assert 1");
    }

    @Test
    public void checkProductNameInCheckout (){
        String expectedName = "Premium Polo";
        String actualName = action.getText(checkout.getCheckoutProductName(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test
    public void checkProductPriceInCheckout (){
        String expectedPrice = "1500";
        String actualPrice = action.getText(checkout.getCheckoutProductPrice(driver));
        soft.assertTrue(actualPrice.contains(expectedPrice),"error message : assert 1");
    }

    @Test
    public void checkProductTotalPriceInCheckout (){
        String expectedPrice = "3000";
        String actualPrice = action.getText(checkout.getCheckoutProductTotalPrice(driver));
        soft.assertTrue(actualPrice.contains(expectedPrice),"error message : assert 1");
    }

    @Test
    public void checkProductsTotalPriceInCheckout (){
        String expectedPrice = "3000";
        String actualPrice = action.getText(checkout.getCheckoutProductsTotalPrice(driver));
        soft.assertTrue(actualPrice.contains(expectedPrice),"error message : assert 1");
    }

    @Test
    public void selectProductQuantityInCheckout(){
        String expectedQuantity = "2";
        String actualQuantity = action.getText(checkout.getCheckoutProductQuantity(driver));
        soft.assertEquals(actualQuantity, expectedQuantity,"error message : assert 1");
    }

    @Test(dependsOnMethods = {"selectProductQuantityInCheckout"})
    public void navigateTOPaymentPage(){
        String expectedUrl ="https://www.automationexercise.com/payment";
        action.Click(checkout.clickOnPlaceOrderButton(driver));
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }




}
