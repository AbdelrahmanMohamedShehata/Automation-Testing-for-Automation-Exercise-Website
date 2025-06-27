package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class PaymentPage {
    ElementActions action = new ElementActions();

    By PaymentText = By.xpath("//li[@class=\"active\"]");
    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By CVC = By.name("cvc");
    By ExpirationMonth = By.name("expiry_month");
    By ExpirationYear = By.name("expiry_year");
    By payAndConfirmOrder = By.id("submit");
    By successfulOrder = By.xpath("//div[@id=\"success_message\"]//div");
    By orderPlacedMessage = By.xpath("//h2[@data-qa=\"order-placed\"]//b");
    By orderConfirmation = By.xpath("//p[text()=\"Congratulations! Your order has been confirmed!\"]"); // //p[text()="Congratulations! Your order has been confirmed!"]
    By downloadFile = By.cssSelector("a[href=\"/download_invoice/1500\"]");
    By LogoutButton = By.cssSelector("a[href=\"/logout\"]");

    public WebElement getPaymentText(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PaymentText));
    }

    public WebElement nameOnCardField(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard));
    }

    public WebElement cardNumberField(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));

    }

    public WebElement CVCField(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CVC));

    }

    public WebElement ExpirationMonthField(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ExpirationMonth));

    }

    public WebElement ExpirationYearField(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ExpirationYear));

    }

    public WebElement payAndConfirmOrderButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(payAndConfirmOrder));
    }


    public void PaymentSteps(WebDriver driver, String nameOnCard, String cardNumber,
                             String CVC, String ExpirationMonth, String ExpirationYear) {

        Actions actions = new Actions(driver);
//        actions.moveToElement(nameOnCardField(driver)).click().sendKeys(nameOnCard).
//                moveToElement(cardNumberField(driver)).click().sendKeys(nameOnCard).
//                moveToElement(CVCField(driver)).click().sendKeys(CVC).
//                moveToElement(ExpirationMonthField(driver)).click().sendKeys(ExpirationMonth).
//                moveToElement(ExpirationYearField(driver)).click().sendKeys(ExpirationYear).
//                build().perform();
        action.SendKeys(nameOnCardField(driver), nameOnCard);
        action.SendKeys(cardNumberField(driver), cardNumber);
        action.SendKeys(CVCField(driver), CVC);
        action.SendKeys(ExpirationMonthField(driver), ExpirationMonth);
        action.SendKeys(ExpirationYearField(driver), ExpirationYear);
        action.Click(payAndConfirmOrderButton(driver));
    }

    public WebElement successfulOrderMsg(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulOrder));

    }

    public WebElement orderPlacedMessage(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedMessage));

    }

    public WebElement orderConfirmation(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));

    }

    public WebElement clickOnLogoutButton(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(LogoutButton));


    }
}
