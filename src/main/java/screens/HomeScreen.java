package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

public class HomeScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String agreeButtonXPath="//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/div/div[2]/button[1]";
    String aboutUsButton="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[4]/a/span";

    public HomeScreen(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    WebElement getAgreeButtonElement(){
        return chromeDriver.findElement(By.xpath(agreeButtonXPath));
    }
    WebElement getAboutUsButtonElement(){
        return chromeDriver.findElement(By.xpath(aboutUsButton));
    }

    public void clickOnAgreeButton(){
        getAgreeButtonElement().click();
   }
   public void clickOnAboutUsButton(){
        getAboutUsButtonElement().click();
   }

}
