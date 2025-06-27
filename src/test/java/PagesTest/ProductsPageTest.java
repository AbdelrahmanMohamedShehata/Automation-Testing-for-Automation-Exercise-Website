package PagesTest;

import Data.ProductsPageData;
import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsPageTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductsPage products = new ProductsPage();
    ElementActions action ;

    @BeforeClass
    public void openBrowser(){
        action = new ElementActions();
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();
        action.Click(home.navigateToLoginPage(driver));
        loginPage.loginSteps(driver,loginCradintials.getLoggedEmail(),loginCradintials.getPassword());
        action.Click(products.ProductsButton(driver));
    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void validateNavigationToProductsPage() {
        String expectedUrl = "https://www.automationexercise.com/products";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error Msg : assert1 ");

        String expectedOutput = "ALL PRODUCTS";
        String actualOutput = action.getText(products.getAllProductsText(driver));
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 2");
        soft.assertAll();
    }

    @Test (dependsOnMethods = "isSpecialOfferImgDisplayed")
    public void validateCategoryTextExists() {
        String expectedOutput = "Category";
        String actualOutput = action.getText(products.getCategoryText(driver));
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 1");
    }

    @Test (dependsOnMethods = "validateCategoryTextExists")
    public void validateBrandsTextExists() {
        String expectedOutput = "Brands";
        String actualOutput = action.getText(products.getBrandText(driver));
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 1");
    }

    @Test (dependsOnMethods = "validateNavigationToProductsPage")
    public void isAutomationExerciseDisplayed () {
        soft.assertTrue(action.isDisplayed(products.isAutomationExerciseImgDisplayed(driver)),"error message : assert 1");
        String expectedOutput = "/static/images/home/logo.png";
        String actualOutput = action.getAttribute(products.isAutomationExerciseImgDisplayed(driver),"src");
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 2");
        soft.assertAll();
    }

    @Test (dependsOnMethods = "isAutomationExerciseDisplayed")
    public void isSpecialOfferImgDisplayed () {
        soft.assertTrue(action.isDisplayed(products.isSpecialOfferImgDisplayed(driver)),"error message : assert 1");
        String expectedOutput = "/static/images/shop/sale.jpg";
        String actualOutput = action.getAttribute(products.isSpecialOfferImgDisplayed(driver),"src");
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 2");
        soft.assertAll();
    }

    @Test (dependsOnMethods = "validateBrandsTextExists")
    public void validateALLProductsSize() {
        int expectedOutput = 34;
        int actualOutput = products.getAllProductsSize(driver);
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 1");
    }

    @Test (dependsOnMethods = "getProductName")
    public void getProductPrice(){

        String expectedResult = "1500";
        String actualResult = action.getText(products.getProductPrice(driver));
        soft.assertTrue(actualResult.contains(expectedResult),"error message : assert 1");

    }

    @Test (dependsOnMethods = "validateALLProductsSize")
    public void getProductName() {
        String expectedOutput = "Premium Polo";
        String actualOutput = action.getText(products.getProductName(driver));
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 1");
   }



    @Test (dependsOnMethods = "getProductPrice")
    public void navigateToProductPage() {
        action.Click(products.clickViewProduct(driver));
        String expectedUrl = "https://www.automationexercise.com/product_details/30";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error message : assert 1");
    }


    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }


}
