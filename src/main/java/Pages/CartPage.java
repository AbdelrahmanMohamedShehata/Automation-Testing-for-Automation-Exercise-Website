package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    By shoppingCartText = By.cssSelector("li[class=\"active\"]");
    By productName = By.cssSelector("a[href=\"/product_details/30\"]");
    By cartQuantity = By.xpath("//tr[@id=\"product-30\"]//button");
    By cartPrice = By.xpath("//tr[@id=\"product-30\"]//td[@class=\"cart_price\"]");
    By cartTotalPrice = By.xpath("//tr[@id=\"product-30\"]//p[@class=\"cart_total_price\"]");
    By proceedToCheckoutButton = By.cssSelector("a[class=\"btn btn-default check_out\"]");
    By deleteItemFromCart = By.cssSelector("td[class=\"cart_delete\"]");
    By cartIsEmptyMsg = By.xpath("//b[text()=\"Cart is empty!\"]");
    By LoginRegisterButton = By.xpath("//P[@class=\"text-center\"]//a[@href=\"/login\"]");
    By LoginMsgToContinueYouPaymentProcess = By.xpath("//p[text()= \"Register / Login account to proceed on checkout.\"]");


    public WebElement getShoppingCartText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartText));
    }

    public WebElement getCartProductName(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(productName));
    }

    public WebElement getCartProductQuantity(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(cartQuantity));
    }

    public WebElement getCartProductPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(cartPrice));
    }

    public WebElement getCartProductTotalPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(cartTotalPrice));
    }

    public WebElement clickOnCheckoutButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
    }

    public WebElement removeProductFromCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(deleteItemFromCart));
    }

    public WebElement cartIsEmptyMsg (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(cartIsEmptyMsg));
    }

    public WebElement getLoginMsgToContinuePaymentProcess (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(LoginMsgToContinueYouPaymentProcess));
    }

    public WebElement clickOnLoginRegisterButtonInCartPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(LoginRegisterButton));
    }

    }
