package PagesTest;

import Pages.DriverManager;
import Pages.ElementActions;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Data.loginCradintials.getLoggedEmail;

public class HomePageTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    ElementActions action = new ElementActions();

    @BeforeClass
    public void openBrowser(){
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();

    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void isAutomationExerciseDisplayed () {
        action.isDisplayed(home.isAutomationExerciseImgDisplayed(driver));
    }

        @Test
    public void verifyHomePage (){
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error Msg : assert 1");

            String expectedOutput = "automation practice";
            String actualOutput = action.getAttribute(home.getAutomationPracticeText(driver),"alt");
            soft.assertTrue(actualOutput.contains(expectedOutput),"error Msg : assert 2");

            String expectedResult = "Home";
            String actualResult = action.getText(home.getHomeText(driver));
            soft.assertEquals(actualResult,expectedResult,"error Msg : assert 3");

            String expectedTitle = "AutomationExercise";
            String actualTitle = action.getText(home.getAutomationExerciseText(driver));
            soft.assertEquals(actualTitle, expectedTitle,"error Msg : assert 4");

            soft.assertAll();

    }

    @Test (dependsOnMethods = "verifyHomePage")
    public void checkHomeSubscribeEmail () {
        action.ScrollingByElement(driver,home.subscribeEmailHome(driver));
        action.SendKeys(home.subscribeEmailHome(driver), getLoggedEmail());
        action.Click(home.subscribeButtonHome(driver));

        String expectedMessage = "You have been successfully subscribed!";
        String actualMessage = action.getText(home.subscribeSuccessfully(driver));
        soft.assertEquals(actualMessage, expectedMessage,"error message : assert 1");

    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

    }
