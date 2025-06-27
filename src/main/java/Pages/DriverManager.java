package Pages;

import Data.URLData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private WebDriver driver;

    public DriverManager(WebDriver driver) {
         this.driver = driver;
    }

    public WebDriver getDriver (){

        return driver;
    }

    public WebDriver setupDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URLData.getNavigationUrl());
        return driver;
    }

    public void quitDriver(WebDriver driver) {
        this.driver = driver;
      driver.quit();
    }
}
