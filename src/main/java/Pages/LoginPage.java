package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    // locators
     By loginEmail = By.cssSelector("input[data-qa=\"login-email\"]");
     By loginPassword = By.name("password");
     By loginButton = By.cssSelector("button[data-qa=\"login-button\"]");
     By loggedInAs = By.xpath("//a[text()=\" Logged in as \"]");
     By logoutButton = By.cssSelector("a[href=\"/logout\"]");
     By deleteAccountButton = By.cssSelector("a[href=\"/delete_account\"]");
     By LoginErrorMsg = By.cssSelector("p[style=\"color: red;\"]");
     ElementActions action = new ElementActions();

    // Methods

    public WebElement getLoggedInAsText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAs));
    }

    public WebElement loginEmail(WebDriver driver) {
        return driver.findElement(loginEmail);
    }

    public WebElement loginPassword(WebDriver driver) {
        return driver.findElement(loginPassword);
    }

    public WebElement loginButton(WebDriver driver) {
        return driver.findElement(loginButton);
    }

    public WebElement LoginUnsuccessfully(WebDriver driver) {
        return driver.findElement(LoginErrorMsg);
    }


    public void loginSteps(WebDriver driver, String email, String Password){
        action.SendKeys(loginEmail(driver),email);
        action.SendKeys(loginPassword(driver),Password);
        action.Click(loginButton(driver));

    }

  public WebElement getLogoutText (WebDriver driver){
        return driver.findElement(logoutButton);
  }

    public WebElement getDeleteAccountText (WebDriver driver){
        return driver.findElement(deleteAccountButton);
    }


}
