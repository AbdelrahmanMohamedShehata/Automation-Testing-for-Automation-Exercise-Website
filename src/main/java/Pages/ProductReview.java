package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Data.ReviewData.*;

public class ProductReview {

    ElementActions action = new ElementActions();

    By reviewName = By.id("name");
    By reviewEmail = By.id("email");
    By addReview = By.id("review");
    By submitReviewButton = By.id("button-review");
    By ReviewSuccessMsg= By.xpath("//span[text()=\"Thank you for your review.\"]");


    public WebElement getReviewName(WebDriver driver) {
        return driver.findElement(reviewName);
    }

    public WebElement getReviewEmail(WebDriver driver) {
        return driver.findElement(reviewEmail);
    }

    public WebElement addReview(WebDriver driver) {
        return driver.findElement(addReview);
    }

    public WebElement submitReviewButton(WebDriver driver) {
        return driver.findElement(submitReviewButton);
    }

    public WebElement getReviewSuccessMsg(WebDriver driver) {
        return driver.findElement(ReviewSuccessMsg);
    }


    public void SendReviewSteps(WebDriver driver){
        action.SendKeys(getReviewName(driver),getNameReview());
        action.SendKeys(getReviewEmail(driver),getEmailReview());
        action.SendKeys(addReview(driver),addReviewMsg());
        action.Click(submitReviewButton(driver));
    }





}
