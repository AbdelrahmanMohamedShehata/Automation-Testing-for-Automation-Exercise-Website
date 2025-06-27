package PagesTest;

import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchForProduct {

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
        loginPage.loginSteps(driver, loginCradintials.getLoggedEmail(),loginCradintials.getPassword());
        action.Click(products.ProductsButton(driver));
    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void validateNavigationToProductsPage() {
        products.searchForProductSteps(driver);
        String expectedUrl = "https://www.automationexercise.com/products?search=Tshirt";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error Msg : assert1 ");

        String expectedOutput = "SEARCHED PRODUCTS";
        String actualOutput = action.getText(products.getSearchedProductsText(driver));
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 2");
        soft.assertAll();
    }

    @Test(dependsOnMethods = "validateNavigationToProductsPage")
    public void validateALLSearchedProductsSize() {
        int expectedOutput = 6;
        int actualOutput = products.getAllSearchedProductsSize(driver);
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 1 Method 2");
    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
