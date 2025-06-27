package Pages;

import Data.ProductsPageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    //locators
    By productsButton = By.cssSelector("a[href=\"/products\"]");
    By allProductsText = By.xpath("//div[@class=\"col-sm-9 padding-right\"]//h2[@class=\"title text-center\"]");
    By searchedProducts = By.xpath("//div[@class=\"col-sm-9 padding-right\"]//h2[@class=\"title text-center\"]");
    By categoryText = By.xpath("//h2[text()=\"Category\"]");
    By brandText = By.xpath("//h2[text()=\"Brands\"]");
    By allProductsItems = By.xpath("//div[@class=\"col-sm-9 padding-right\"]//div[@class=\"col-sm-4\"]");
   // By allSearchedProductsItems = By.xpath("//div[@class=\"productinfo text-center\"]");
    By searchField = By.id("search_product");
    By searchButton = By.id("submit_search");
    By productPrice = By.xpath("//div[@class=\"productinfo text-center\"]//h2[text()='Rs. 1500']");
    By productName = By.xpath("//div[@class=\"productinfo text-center\"]//p[text()='Premium Polo T-Shirts']");
    By viewProductButton = By.cssSelector("a[href=\"/product_details/30\"]");
    By automationExerciseImage = By.cssSelector("img[src=\"/static/images/home/logo.png\"]");
    By specialOfferImage = By.id("sale_image");

    // Methods

    public WebElement ProductsButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.elementToBeClickable(productsButton));
    }

    public WebElement getAllProductsText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(allProductsText));
    }

    public WebElement getSearchedProductsText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(searchedProducts));
    }

    public WebElement getCategoryText(WebDriver driver) {
        return driver.findElement(categoryText);
    }

    public WebElement getBrandText(WebDriver driver) {
        return driver.findElement(brandText);
    }

    public WebElement isAutomationExerciseImgDisplayed(WebDriver driver) {
        return driver.findElement(automationExerciseImage);
    }

    public WebElement isSpecialOfferImgDisplayed(WebDriver driver) {
        return driver.findElement(specialOfferImage);
    }


    public WebElement searchField(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
    }

    public WebElement searchButton(WebDriver driver) {
        return driver.findElement(searchButton);
    }

    public int getAllSearchedProductsSize(WebDriver driver) {
        List <WebElement> elements = driver.findElements(allProductsItems);
        return elements.size();
    }

    public int getAllProductsSize(WebDriver driver) {
        List <WebElement> elements = driver.findElements(allProductsItems);
        return elements.size();
    }

    public WebElement getProductPrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(productPrice));
    }

    public WebElement getProductName(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(productName));
    }

    public WebElement clickViewProduct(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        return wait.until(ExpectedConditions.presenceOfElementLocated(viewProductButton));
    }

    ElementActions action = new ElementActions();

    public void searchForProductSteps(WebDriver driver){
        action.Click(searchField(driver));
        action.SendKeys(searchField(driver),ProductsPageData.sendDataToSearchField());
        action.Click(searchButton(driver));
    }



}
