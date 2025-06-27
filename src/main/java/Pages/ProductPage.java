package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    By productName = By.xpath("//h2[text()[1]='Premium ']"); /*//h2[contains(text(),'Premium Polo ')]*/
    By productPrice = By.xpath("//span[text()='Rs. 1500']");
    By ProductImg = By.xpath("//div[@class=\"view-product\"]//img[@alt=\"ecommerce website products\"]");
    By ratingImg =By.cssSelector("img[src=\"/static/images/product-details/rating.png\"]");
    By CategoryName =By.xpath("//div[@class=\"product-information\"]//p[1]");
    By quantity = By.id("quantity");
    By availability = By.xpath("//p[text()=' In Stock']");
    By condition = By.xpath("//p[text()=' New']");
    By brandName = By.xpath("//p[text()=' Polo']");
    By addToCartButton = By.cssSelector("button[type=\"button\"]");
    By addedToCartMessage = By.xpath("//p[@class=\"text-center\"][1]");
    By viewCartButtonHidden = By.xpath("//p//a[@href=\"/view_cart\"]");
    By CartButton = By.xpath("//li//a[@href=\"/view_cart\"]");

    ElementActions action = new ElementActions();

    public WebElement ProductName(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
    }

    public WebElement ProductPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
    }

    public WebElement ProductQuantity(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));
    }

    public void changeProductQuantity(WebDriver driver ,String quantity){
        action.Clear(ProductQuantity(driver));
        action.SendKeys(ProductQuantity(driver),quantity);
    }

    public WebElement ProductAvailability(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(availability));
    }

    public WebElement ProductCondition(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(condition));
    }

    public WebElement ProductImg(WebDriver driver) {
        return driver.findElement(ProductImg);
    }

    public WebElement RatingImg(WebDriver driver) {
        return driver.findElement(ratingImg);
    }

    public WebElement getCategoryName(WebDriver driver) {
        return driver.findElement(CategoryName);
    }

    public WebElement ProductBrandName(WebDriver driver) {
        return driver.findElement(brandName);
    }

    public WebElement addProductToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }

    public WebElement addedProductToCartConfirmation(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addedToCartMessage));
    }

    public WebElement clickOnViewCartButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(viewCartButtonHidden));
    }

    public WebElement clickOnCartButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(CartButton));
    }

}
