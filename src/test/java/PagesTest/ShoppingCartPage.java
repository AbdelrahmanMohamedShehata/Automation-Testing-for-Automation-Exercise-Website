package PagesTest;

import Data.loginCradintials;
import Pages.*;
import Pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartPage {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductsPage products = new ProductsPage();
    ElementActions action ;
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();

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

    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void validateShoppingCartPage (){
        String expectedName = "Shopping Cart";
        String actualName = action.getText(cart.getShoppingCartText(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test (dependsOnMethods = "validateShoppingCartPage")
    public void checkProductNameInCart (){
        String expectedName = "Premium Polo";
        String actualName = action.getText(cart.getCartProductName(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductNameInCart")
    public void checkProductPriceInCart (){
        String expectedPrice = "1500";
        String actualPrice = action.getText(cart.getCartProductPrice(driver));
        soft.assertTrue(actualPrice.contains(expectedPrice),"error message : assert 1");
    }

    @Test (dependsOnMethods = "selectProductQuantityInCart")
    public void checkProductTotalPriceInCart (){
        String expectedPrice = "3000";
        String actualPrice = action.getText(cart.getCartProductTotalPrice(driver));
        soft.assertTrue(actualPrice.contains(expectedPrice),"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductPriceInCart")
    public void selectProductQuantityInCart (){
        String expectedQuantity = "2";
        String actualQuantity = action.getText(cart.getCartProductQuantity(driver));
        soft.assertEquals(actualQuantity, expectedQuantity,"error message : assert 1");
    }

    @Test (dependsOnMethods = "removeItemFromCart")
    public void navigateTOCheckoutPage(){
        String expectedUrl ="https://www.automationexercise.com/checkout";
        action.Click(cart.clickOnCheckoutButton(driver));
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductTotalPriceInCart")
    public void removeItemFromCart(){
        action.Click(cart.removeProductFromCart(driver));
        String expectedResult = "Cart is empty!";
        String actualResult = action.getText(cart.cartIsEmptyMsg(driver));

        soft.assertEquals(actualResult,expectedResult,"error message : assert 1");
    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
