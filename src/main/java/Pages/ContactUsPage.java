package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    By contactUsText = By.xpath("//h2[text()=\"Contact \"]");
    By contactUsName = By.cssSelector("input[data-qa=\"name\"]");
    By contactUsEmail = By.cssSelector("input[data-qa=\"email\"]");
    By contactUsSubject = By.cssSelector("input[data-qa=\"subject\"]");
    By contactUsMessage = By.id("message");
    By uploadFile = By.name("upload_file");
    By submitButton = By.name("submit");
    By successMsg = By.cssSelector("div[class=\"status alert alert-success\"]");
    By successHomeButton = By.cssSelector("a[class=\"btn btn-success\"]");

    public WebElement getContactUsText(WebDriver driver) {
        return driver.findElement(contactUsText);
    }

    public WebElement contactUsNameField(WebDriver driver) {
        return driver.findElement(contactUsName);
    }

    public WebElement contactUsSubjectField(WebDriver driver) {
        return driver.findElement(contactUsSubject);
    }

    public WebElement contactUsEmailField(WebDriver driver) {
        return driver.findElement(contactUsEmail);
    }

    public WebElement contactUsMessageField(WebDriver driver) {
        return driver.findElement(contactUsMessage);
    }

    public WebElement uploadFileField(WebDriver driver) {
        return driver.findElement(uploadFile);
    }

    public WebElement clickOnSubmitButton(WebDriver driver) {
        return driver.findElement(submitButton);
    }

    public WebElement getContactUsSuccessMsg(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
    }

    public WebElement successHomeButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(successHomeButton));

    }




}
