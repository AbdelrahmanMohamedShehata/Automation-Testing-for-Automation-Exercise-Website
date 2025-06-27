package PagesTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignupPageTest {
    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    SignupPage signup = new SignupPage();
    ElementActions action ;

    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void openbrowser() {
        action = new ElementActions();
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();
        action.Click(home.navigateToLoginPage(driver));
    }


    @Test
    public void visibleSignup(){
        String ExpectedResult = "New User Signup!";
        String ActualResult = action.getText(signup.getSignupText(driver));
        System.out.println("actual : "+ ActualResult);
        soft.assertEquals(ActualResult, ExpectedResult,"error message : verify signup Assert 1");
    }

    @Test
    public void signupWithUnRegisteredUser(){
        signup.signupSteps(driver,"SGSFG EEgd","Cr7gdm343@gmail.com");
        String ExpectedUrl = "https://www.automationexercise.com/signup";
        String ActualUrl = driver.getCurrentUrl();
        soft.assertEquals(ActualUrl, ExpectedUrl,"error : assert 1");
        //  System.out.println("url : "+ ActualUrl);
        String expectedResult = "ENTER ACCOUNT INFORMATION";
        String actualResult = action.getText(signup.getAccountInformationText(driver));
        soft.assertEquals(actualResult,expectedResult, "error : assert 2");
        soft.assertAll();
    }

    @Test
    public void SignupWithRegisteredUser(){
        signup.signupSteps(driver,"12435@","abdeltraghman@gmail.com");
        String ExpectedResult = "Email Address already exist!";
        String ActualResult = action.getText(signup.getEmailExistedMsg(driver));
        soft.assertEquals(ActualResult.contains(ExpectedResult),true);
        System.out.println("Actual result : "+ActualResult);
    }

    @AfterMethod
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}


