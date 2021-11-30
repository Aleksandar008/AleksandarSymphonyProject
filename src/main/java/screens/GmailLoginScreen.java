package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

public class GmailLoginScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String loginXpath="//*[@id=\"identifierId\"]";
    String nextButtonXpath="//*[@id=\"identifierNext\"]/div/button/span";

    public GmailLoginScreen(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    WebElement getLoginElement(){
        return chromeDriver.findElement(By.xpath(loginXpath));
    }
    WebElement getButtonElement(){
        return chromeDriver.findElement(By.xpath(nextButtonXpath));
    }

    public void clickOnButton(){
        getButtonElement().click();
    }
    public void insertEmail(String s){
        getLoginElement().sendKeys(s);
    }
}
