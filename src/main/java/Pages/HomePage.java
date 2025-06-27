package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    By loginSignupButton =By.xpath("//li//a[@href=\"/login\"]");
    By HomeText =By.xpath("//a[text()=\" Home\"]");
    By AutomationPracticeText = By.cssSelector("img[src=\"/static/images/home/logo.png\"]");
    By AutomationExerciseText = By.xpath("//div[@class=\"col-sm-6\"]//h1");
    By subscribeEmail = By.id("susbscribe_email");
    By subscribeButton = By.id("subscribe");
    By successfulSubscriptionMsg = By.cssSelector("div[class=\"alert-success alert\"]");
    By automationExerciseImage = By.cssSelector("img[src=\"/static/images/home/logo.png\"]");
    By contactUsButton = By.cssSelector("a[href=\"/contact_us\"]");

    public WebElement navigateToContactUsPage(WebDriver driver) {

        return driver.findElement(contactUsButton);
    }

    public WebElement isAutomationExerciseImgDisplayed(WebDriver driver) {
        return driver.findElement(automationExerciseImage);
    }

    public WebElement getHomeText(WebDriver driver){

        return driver.findElement(HomeText);
    }

    public WebElement getAutomationPracticeText(WebDriver driver){

        return driver.findElement(AutomationPracticeText);
    }

    public WebElement getAutomationExerciseText(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationExerciseText));
    }

    public WebElement navigateToLoginPage(WebDriver driver){

        return driver.findElement(loginSignupButton);
    }

    public WebElement subscribeEmailHome(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscribeEmail));
    }

    public WebElement subscribeButtonHome(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
    }

    public WebElement subscribeSuccessfully(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulSubscriptionMsg));
    }

}
