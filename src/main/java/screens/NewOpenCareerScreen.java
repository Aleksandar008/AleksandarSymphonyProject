package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

public class NewOpenCareerScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String jobPositionNameXpath = "//*[@id=\"heroBackgroundColor\"]/div/h1";
    String jobPositionLocationXpath = "//*[@id=\"heroBackgroundColor\"]/div/ul/li[1]/span";
    String jobPositionTypeXpath = "//*[@id=\"heroBackgroundColor\"]/div/ul/li[2]/span";


    public NewOpenCareerScreen(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    WebElement getJobPositionNameElement(){
        return chromeDriver.findElement(By.xpath(jobPositionNameXpath));
    }
    WebElement getJobPositionLocationElement(){
        return chromeDriver.findElement(By.xpath(jobPositionLocationXpath));
    }
    WebElement getJobPositionTypeElement(){
        return chromeDriver.findElement(By.xpath(jobPositionTypeXpath));
    }

    public String getTitle(){
        return getJobPositionNameElement().getText();
    }
    public String getLocation(){
        return getJobPositionLocationElement().getText();
    }
    public String getType(){
        return getJobPositionTypeElement().getText();
    }


}
