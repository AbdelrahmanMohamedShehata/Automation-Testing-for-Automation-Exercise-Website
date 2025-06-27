package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignupInfoPage {

    //locators

       By Mr_gender = By.id("id_gender1");
       By Mrs_gender = By.id("id_gender2");
       By password = By.id("password");
       By day = By.id("days");
       By month = By.id("months");
       By year = By.id("years");
       By newsletter =By.id("newsletter");
       By optin = By.id("optin");
       By first_name = By.id("first_name");
       By last_name = By.id("last_name");
       By company = By.id("company");
       By address1 = By.id("address1");
       By address2 = By.id("address2");
       By country =By.id("country");
       By state = By.id("state");
       By city = By.id("city");
       By zipcode = By.id("zipcode");
       By mobile_number = By.id("mobile_number");
       By accountCreatedText = By.cssSelector("h2>b");
       By accountCreatedMsg = By.xpath("//p[contains(text(),'Congratulations!')]");
       By continueButton = By.cssSelector("a[data-qa=\"continue-button\"]");
       By deleteAccountButton = By.cssSelector("a[href=\"/delete_account\"]");
       By accountDeletedText = By.cssSelector("h2>b");
       By accountDeletedMsg = By.xpath("//p[contains(text(),'Your account has been permanently deleted!')]");

        ElementActions action = new ElementActions();

        // Methods for locators
        public WebElement genderMr(WebDriver driver){
            return driver.findElement(Mr_gender);
        }
        public WebElement genderMrs(WebDriver driver){
            return driver.findElement(Mrs_gender);
        }
        public WebElement passwordsignupele (WebDriver driver){
            return driver.findElement(password);
        }
        public WebElement dayselement (WebDriver driver){
            return driver.findElement(day);
        }
        public WebElement monthselement (WebDriver driver){
            return driver.findElement(month);
        }
        public WebElement yearelement (WebDriver driver){
            return driver.findElement(year);
        }
        public WebElement newsletterele(WebDriver driver){
            return driver.findElement(newsletter);
        }
        public WebElement getspecialofferele(WebDriver driver){
            return driver.findElement(optin);
        }
        public WebElement firstnameele(WebDriver driver){
            return driver.findElement(first_name);
        }
        public WebElement lastnameele(WebDriver driver){
            return driver.findElement(last_name);
        }
        public WebElement companyele(WebDriver driver){return driver.findElement(company);}
        public WebElement address1ele(WebDriver driver){return driver.findElement(address1);}
        public WebElement address2ele(WebDriver driver){return driver.findElement(address2);}
        public WebElement countryele(WebDriver driver){
            return driver.findElement(country);
        }
        public WebElement stateele(WebDriver driver){
            return driver.findElement(state);
        }
        public WebElement cityele(WebDriver driver){
            return driver.findElement(city);
        }
        public WebElement zipcodeele(WebDriver driver){
            return driver.findElement(zipcode);
        }
        public WebElement mobilenumberele(WebDriver driver){
            return driver.findElement(mobile_number);
        }

        public WebElement getAccountCreatedText(WebDriver driver){
            return driver.findElement(accountCreatedText);
        }
        public WebElement getAccountCreatedMsg(WebDriver driver){
        return driver.findElement(accountCreatedMsg);
    }
        public WebElement clickContinueButton(WebDriver driver){
        return driver.findElement(continueButton);
    }
        public WebElement clickDeleteAccountButton(WebDriver driver){
        return driver.findElement(deleteAccountButton);
    }
        public WebElement getAccountDeletedText(WebDriver driver){
        return driver.findElement(accountDeletedText);
        }
        public WebElement getAccountDeletedMsg(WebDriver driver){
        return driver.findElement(accountDeletedMsg);
    }


      // Steps Methods
        public void Mandatorysignupsteps (WebDriver driver,String password,String firstname,String lastname, String address
                ,String country,String state,String city,String zipcode,String mobilenumber)
        {
            action.SendKeys(passwordsignupele(driver),password);
            action.SendKeys(firstnameele(driver),firstname);
            action.SendKeys(lastnameele(driver),lastname);
            action.SendKeys(address1ele(driver),address);
            Select countrydropdown = new Select(countryele(driver));
            countrydropdown.selectByVisibleText(country);
            action.SendKeys(stateele(driver),state);
            action.SendKeys(cityele(driver),city);
            action.SendKeys(zipcodeele(driver),zipcode);
            action.SendKeys(mobilenumberele(driver),mobilenumber);
            action.submit(mobilenumberele(driver));
        }

        public void AllSignupStepsWithoutGender (WebDriver driver,String password,String day,String month,String year,
                                            String firstname,String lastname,String company,String address1,String address2,
                                            String country, String state,String city,String zipcode,String mobilenumber)
        {
            action.SendKeys(passwordsignupele(driver),password);
            Select daysdropdown = new Select(dayselement(driver));
            daysdropdown.selectByVisibleText(day);
            Select monthsdropdown = new Select(monthselement(driver));
            monthsdropdown.selectByVisibleText(month);
            Select yearsdropdown = new Select(yearelement(driver));
            yearsdropdown.selectByVisibleText(year);
            action.Click(newsletterele(driver));
            action.Click(getspecialofferele(driver));
            action.SendKeys(firstnameele(driver),firstname);
            action.SendKeys(lastnameele(driver),lastname);
            action.SendKeys(companyele(driver),company);
            action.SendKeys(address1ele(driver),address1);
            action.SendKeys(address2ele(driver),address2);
            Select countrydropdown = new Select(countryele(driver));
            countrydropdown.selectByVisibleText(country);
            action.SendKeys(stateele(driver),state);
            action.SendKeys(cityele(driver),city);
            action.SendKeys(zipcodeele(driver),zipcode);
            action.SendKeys(mobilenumberele(driver),mobilenumber);
            action.submit(mobilenumberele(driver));
        }
    }

