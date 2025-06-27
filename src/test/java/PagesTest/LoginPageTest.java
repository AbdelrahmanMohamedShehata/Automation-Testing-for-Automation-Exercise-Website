package PagesTest;

import Data.loginCradintials;
import Pages.DriverManager;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import Pages.ElementActions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class LoginPageTest {
    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    LoginPage loginPage = new LoginPage();
    ElementActions action ;

    @BeforeMethod
    public void openBrowser(){
        action = new ElementActions();
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();
        action.Click(home.navigateToLoginPage(driver));
    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void LoginWithRegisteredEmail(){
        loginPage.loginSteps(driver,loginCradintials.getLoggedEmail(),loginCradintials.getPassword());
        String expectedResult = "Logout";
        String actualResult = action.getText(loginPage.getLogoutText(driver));
        soft.assertEquals(actualResult,expectedResult,"error message : assert 1");

        String expectedOutput = "Delete Account";
        String actualOutput = action.getText(loginPage.getDeleteAccountText(driver));
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 2");

        String expectedText = "Logged in as";
        String actualText = action.getText(loginPage.getLoggedInAsText(driver));
        soft.assertTrue(actualText.contains(expectedText),"error message : assert 3");

        soft.assertAll();
    }

    @Test
    public void LoginWithUnRegisteredEmail() {
        loginPage.loginSteps(driver, loginCradintials.getUnRegisteredEmail(), loginCradintials.getPassword());
        String expectedResult = "Your email or password is incorrect!";
        String actualResult = action.getText(loginPage.LoginUnsuccessfully(driver));
        soft.assertEquals(actualResult, expectedResult, "error message : assert 1");

    }
        @AfterMethod
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
