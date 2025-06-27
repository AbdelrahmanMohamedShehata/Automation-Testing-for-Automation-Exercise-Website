package PagesTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SignupInfoPageTest {
    private WebDriver driver;
    DriverManager driverManager;
    HomePage home = new HomePage();
    SignupPage signup = new SignupPage();
    ElementActions action ;
    SignupInfoPage signupInfo = new SignupInfoPage();

    SoftAssert soft = new SoftAssert();

    @BeforeClass
    public void openbrowser() {
        action = new ElementActions();
        driverManager = new DriverManager(driver);
        driverManager.setupDriver();
        driver = driverManager.getDriver();
        action.Click(home.navigateToLoginPage(driver));
        signup.signupSteps(driver,"Mohamed tarek","mohamedtarek@gmail.com");
        // you have to change the email after every successful Account created
    }

    @Test
    public void signupWithOnlyMandatory(){
        signupInfo.Mandatorysignupsteps(driver,"1123aZdfs@A","ahmed","hassan","India newdelhi",
                "India","India1","new delhi","1353","23534534533");
        String Expectedurl = "https://www.automationexercise.com/account_created";
        String Actualurl = driver.getCurrentUrl();
        soft.assertEquals(Actualurl,Expectedurl,"error : wrong url Assert1");
        String expectedResult = "ACCOUNT CREATED!";
        String actualResult = action.getText(signupInfo.getAccountCreatedText(driver));
        soft.assertEquals(actualResult,expectedResult,"error : wrong result Assert2");
        String expectedOutput = "Congratulations!";
        String actualOutput = action.getText(signupInfo.getAccountCreatedMsg(driver));
        System.out.println(actualOutput);
        soft.assertTrue(actualOutput.contains(expectedOutput),"error : wrong result Assert3");

        soft.assertAll();
    }
    @Test (dependsOnMethods = {"signupWithOnlyMandatory"})
    public void deleteAccountSuccessfully (){
    action.Click(signupInfo.clickContinueButton(driver));
    action.Click(signupInfo.clickDeleteAccountButton(driver));
        String Expectedurl = "https://www.automationexercise.com/delete_account";
        String Actualurl = driver.getCurrentUrl();
        soft.assertEquals(Actualurl,Expectedurl,"error : wrong url Assert1");
        String expectedResult = "ACCOUNT DELETED!";
        String actualResult = action.getText(signupInfo.getAccountDeletedText(driver));
        soft.assertEquals(actualResult,expectedResult,"error : wrong result Assert2");
        String expectedOutput = "Your account has been permanently deleted!";
        String actualOutput = action.getText(signupInfo.getAccountDeletedMsg(driver));
        soft.assertTrue(actualOutput.contains(expectedOutput),"error : wrong result Assert3");

        soft.assertAll();
    }


    @AfterClass
    public void quitDriver(){
        driverManager.quitDriver(driver);
    }

}
