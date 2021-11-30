package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

public class GmailPasscodeScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String passcodeXpath="//*[@id=\"password\"]/div[1]/div/div[1]/input";
    String nextButtonXpath="//*[@id=\"passwordNext\"]/div/button/span";

    public GmailPasscodeScreen(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    WebElement getPasswordElement(){
        return chromeDriver.findElement(By.xpath(passcodeXpath));
    }
    WebElement getButtonElement(){
        return chromeDriver.findElement(By.xpath(nextButtonXpath));
    }

    public void clickOnButton(){
        getButtonElement().click();
    }
    public void insertPassword(String s){
        getPasswordElement().sendKeys(s);
    }
}
