package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    public ElementActions(){};

    public void Click(WebElement element) {
        element.click();
    }

    public void SendKeys(WebElement element,String data) {
        element.sendKeys(data);
    }

    public void submit(WebElement element) {
            element.submit();
    }

    public void Clear(WebElement element) {
        element.clear();
    }

    public void ScrollingByElement(WebDriver driver, WebElement element){
        JavascriptExecutor jsE = (JavascriptExecutor)driver;
        jsE.executeScript("arguments[0].scrollIntoView();",element);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getAttribute(WebElement element,String data) {
       return element.getAttribute(data);
    }

    public boolean isDisplayed(WebElement element) {
       return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }


}
