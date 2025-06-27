package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class SignupPage {

        By newUserSignupText = By.xpath("//div[@class=\"signup-form\"]//h2");
        By signupButton = By.cssSelector("button[data-qa=\"signup-button\"]");
        By SignupName = By.name("name");
        By signupEmail = By.cssSelector("input[data-qa=\"signup-email\"]");
        By EmailExistedMsg = By.xpath("//p[@style=\"color: red;\"]");
        By accountInformationText = By.xpath("//b[text()=\"Enter Account Information\"]");


        ElementActions action = new ElementActions();
        public WebElement getSignupText(WebDriver driver){
            return driver.findElement(newUserSignupText);
        }

        public WebElement clickSignupButton(WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        }

        public WebElement NameField(WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(SignupName));
        }

        public WebElement EmailField(WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmail));
        }

        public void signupSteps(WebDriver driver, String name , String email){
            action.SendKeys(NameField(driver),name);
            action.SendKeys(EmailField(driver),email);
            action.Click(clickSignupButton(driver));
        }

        public WebElement getEmailExistedMsg(WebDriver driver){
            return driver.findElement(EmailExistedMsg);
        }

        public WebElement getAccountInformationText(WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(accountInformationText));
        }

        public void clearsignupdata(WebDriver driver){
            action.Clear(NameField(driver));
            action.Clear(EmailField(driver));
        }

    }

