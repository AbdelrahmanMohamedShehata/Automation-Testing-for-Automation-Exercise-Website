package PagesTest;

import Pages.ContactUsPage;
import Pages.DriverManager;
import Pages.ElementActions;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Data.ContactUsData.*;

public class ContactUsPageTest {

    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    ContactUsPage contactus = new ContactUsPage();
    ElementActions action ;

    @BeforeClass
    public void openBrowser(){
        action = new ElementActions();
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();
        action.Click(home.navigateToContactUsPage(driver));
    }

    SoftAssert soft = new SoftAssert();

    @Test
    public void validateNavigationToContactusPage() {
        String expectedUrl = "https://www.automationexercise.com/contact_us";
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl,expectedUrl,"error Msg : assert1 ");

        String expectedOutput = "CONTACT US";
        String actualOutput = action.getText(contactus.getContactUsText(driver));
        soft.assertEquals(actualOutput,expectedOutput,"error message : assert 2");
        soft.assertAll();
    }

    @Test
    public void sendContactUsDetailsSuccessfully() {
        action.SendKeys(contactus.contactUsNameField(driver),getName());
        action.SendKeys(contactus.contactUsEmailField(driver),getEmail());
        action.SendKeys(contactus.contactUsSubjectField(driver),getSubject());
        action.SendKeys(contactus.contactUsMessageField(driver),getMessage());
        action.SendKeys(contactus.uploadFileField(driver),getFilePath());
        action.Click(contactus.clickOnSubmitButton(driver));
        driver.switchTo().alert().accept();

        soft.assertTrue(action.isEnabled(contactus.successHomeButton(driver)),"error Msg : assert 1");

        String expectedOutput = "Your details have been submitted";
        String actualOutput = action.getText(contactus.getContactUsSuccessMsg(driver));
        soft.assertTrue(actualOutput.contains(expectedOutput),"error message : assert 2");

        soft.assertAll();
    }

    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
