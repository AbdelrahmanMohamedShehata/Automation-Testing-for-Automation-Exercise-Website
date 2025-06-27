package PagesTest;

import Data.loginCradintials;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductReviewTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductsPage products = new ProductsPage();
    ElementActions action ;
    ProductReview review = new ProductReview();

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

    @Test
    public void sendReviewSuccessfully(){
        action.Click(products.clickViewProduct(driver));
        review.SendReviewSteps(driver);
            String expectedPrice ="Thank you for your review.";
            String actualPrice = action.getText(review.getReviewSuccessMsg(driver));
            soft.assertEquals(actualPrice,expectedPrice,"error message : assert 1");
    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }


}
