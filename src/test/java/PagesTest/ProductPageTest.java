package PagesTest;

import Data.ProductsPageData;
import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductPageTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductsPage products = new ProductsPage();
    ElementActions action ;
    ProductPage product = new ProductPage();

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
    }

    SoftAssert soft = new SoftAssert();

    @Test (dependsOnMethods = "isProductImgDisplayed")
    public void checkProductName (){
        String expectedName = "Premium  Polo  T-Shirts";
        String actualName = action.getText(product.ProductName(driver));
        soft.assertEquals(actualName,expectedName,"error message : assert 1");
    }

    @Test
    public void isProductImgDisplayed () {
        action.Click(products.clickViewProduct(driver));
        soft.assertTrue(action.isDisplayed(product.ProductImg(driver)),"error message : assert 1");
        String expectedOutput = "/get_product_picture/30";
        String actualOutput = action.getAttribute(product.ProductImg(driver),"src");
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 2");
        soft.assertAll();
    }

    @Test (dependsOnMethods = "getCategoryName")
    public void isRatingImgDisplayed () {
        soft.assertTrue(action.isDisplayed(product.RatingImg(driver)),"error message : assert 1");
        String expectedOutput = "/static/images/product-details/rating.png";
        String actualOutput = action.getAttribute(product.RatingImg(driver),"src");
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 2");
       soft.assertAll();
    }

    @Test (dependsOnMethods = "checkProductName")
    public void getCategoryName () {
        String expectedName ="Category: Men";
        String actualName = action.getText(product.getCategoryName(driver));
        soft.assertTrue(actualName.contains(expectedName),"error message : assert 1");
    }

    @Test (dependsOnMethods = "isRatingImgDisplayed")
    public void checkProductPrice (){
        String expectedPrice = "1500";
        String actualPrice = action.getText(product.ProductPrice(driver));
        soft.assertTrue(actualPrice.contains(expectedPrice),"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductPrice")
    public void selectProductQuantity (){
        String expectedQuantity = "2";
        product.changeProductQuantity(driver,"2");
        String actualQuantity = action.getText(product.ProductQuantity(driver));
        soft.assertEquals(actualQuantity, expectedQuantity,"error message : assert 1");
    }

    @Test (dependsOnMethods = "selectProductQuantity")
    public void checkProductAvailability (){
        String expectedName = "In Stock";
        String actualName = action.getText(product.ProductAvailability(driver));
        soft.assertEquals(actualName,expectedName,"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductAvailability")
    public void checkProductCondition (){
        String expectedName = "New";
        String actualName = action.getText(product.ProductCondition(driver));
        soft.assertEquals(actualName,expectedName,"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductCondition")
    public void checkProductBrandName (){
        String expectedName = "Polo";
        String actualName = action.getText(product.ProductBrandName(driver));
        soft.assertEquals(actualName,expectedName,"error message : assert 1");
    }

    @Test (dependsOnMethods = "checkProductBrandName")
    public void AddedProductToCartSuccessfully (){
        action.Click(product.addProductToCart(driver));
        String expectedName = "Your product has been added to cart.";
        String actualName = action.getText(product.addedProductToCartConfirmation(driver));
        soft.assertEquals(actualName,expectedName,"error message : assert 1");
    }

    @Test (dependsOnMethods = "AddedProductToCartSuccessfully")
    public void navigateTOViewCartPage (){
        String expectedUrl ="https://www.automationexercise.com/view_cart";
        action.Click(product.clickOnViewCartButton(driver));
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
