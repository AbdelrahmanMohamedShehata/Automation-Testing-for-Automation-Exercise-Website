package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    By CheckOutText = By.xpath("//li[text()= \"Checkout\"]");
    By productName = By.cssSelector("a[href=\"/product_details/30\"]");
    By ProductQuantity = By.xpath("//tr[@id=\"product-30\"]//button");
    By ProductPrice = By.xpath("//tr[@id=\"product-30\"]//td[@class=\"cart_price\"]");
    By ProductTotalPrice = By.xpath("//tr[@id=\"product-30\"]//p[@class=\"cart_total_price\"]");
    By placeOrderButton = By.cssSelector("a[href=\"/payment\"]");
    // Delivery Address
    By AddressFirstLastNameD = By.xpath("//ul[@id=\"address_delivery\"]//li[2]");
    By Address1Address2D = By.xpath("//ul[@id=\"address_delivery\"]//li[4]");
    By AddressCityStatePostcodeD = By.xpath("//ul[@id=\"address_delivery\"]//li[6]");
    By AddressCountryNameD = By.xpath("//ul[@id=\"address_delivery\"]//li[7]");
    By AddressPhoneNumberD = By.xpath("//ul[@id=\"address_delivery\"]//li[8]");
    // Billing Address
    By AddressFirstLastNameB = By.xpath("//ul[@id=\"address_invoice\"]//li[2]");
    By Address1Address2B = By.xpath("//ul[@id=\"address_invoice\"]//li[4]");
    By AddressCityStatePostcodeB = By.xpath("//ul[@id=\"address_invoice\"]//li[6]");
    By AddressCountryNameB = By.xpath("//ul[@id=\"address_invoice\"]//li[7]");
    By AddressPhoneNumberB = By.xpath("//ul[@id=\"address_invoice\"]//li[8]");



    public WebElement getProductsTotalAmount(WebDriver driver){
        List<WebElement> Elements = driver.findElements(By.cssSelector("P[class=\"cart_total_price\"]"));
        return Elements.getLast();
    }

    public WebElement getCheckoutText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(CheckOutText));
    }

    public WebElement getDeliveryAddressFirstLastNameText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressFirstLastNameD));
    }

    public WebElement getDeliveryAddress1Address2Text(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(Address1Address2D));
    }

    public WebElement getDeliveryAddressCityStatePostcodeText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressCityStatePostcodeD));
    }

    public WebElement getDeliveryAddressCountryNameText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressCountryNameD));
    }

    public WebElement getDeliveryAddressPhoneNumberText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressPhoneNumberD));
    }

    public WebElement getBillingAddressFirstLastNameText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressFirstLastNameB));
    }

    public WebElement getBillingAddress1Address2Text(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(Address1Address2B));
    }

    public WebElement getBillingAddressCityStatePostcodeText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressCityStatePostcodeB));
    }

    public WebElement getBillingAddressCountryNameText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressCountryNameB));
    }

    public WebElement getBillingAddressPhoneNumberText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(AddressPhoneNumberB));
    }

    public WebElement getCheckoutProductName(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(productName));
    }

    public WebElement getCheckoutProductQuantity(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(ProductQuantity));
    }

    public WebElement getCheckoutProductPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(ProductPrice));
    }

    public WebElement getCheckoutProductTotalPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(ProductTotalPrice));
    }

    public WebElement getCheckoutProductsTotalPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.visibilityOf(getProductsTotalAmount(driver)));
    }

    public WebElement clickOnPlaceOrderButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(placeOrderButton));
    }
}
