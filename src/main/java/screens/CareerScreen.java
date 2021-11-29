package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CareerScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String agreeButtonXPath="//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/div/div[2]/button[1]";
    String aboutUsButtonXpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[4]/a/span";
    String careersButtonXpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[5]/a";
    String currentOpeningsXpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[5]/div/ul/li[2]/a";
    String skopjeXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[5]/div/ul/li[2]/a";
    String firstJobXpath="//*[@id=\"current-openings\"]/div/ul/li[51]/a";
    String firstJobTitleXpath ="//*[@id=\"current-openings\"]/div/ul/li[51]/a/div[2]";
    String firstJobLocationXpath = "//*[@id=\"current-openings\"]/div/ul/li[51]/a/div[3]/div";
    String firstJobTypeXpath="//*[@id=\"current-openings\"]/div/ul/li[51]/a/div[1]";
    String gridXpath = "//*[@id=\"current-openings\"]/div/ul/li";

    public CareerScreen(ChromeDriver chromeDriver) throws IOException {
        this.chromeDriver = chromeDriver;
    }

    WebElement getAgreeButtonElement(){
        return chromeDriver.findElement(By.xpath(agreeButtonXPath));
    }
    WebElement getAboutUsButtonElement(){
        return chromeDriver.findElement(By.xpath(aboutUsButtonXpath));
    }
    WebElement getCareersButtonElement(){
        return chromeDriver.findElement(By.xpath(careersButtonXpath));
    }
    WebElement getCurrentOpeningsElement(){
        return chromeDriver.findElement(By.xpath(currentOpeningsXpath));
    }
    WebElement getSkopjeElement(){
        return chromeDriver.findElement(By.xpath(skopjeXpath));
    }
    WebElement getFirstJobElement(){
        return chromeDriver.findElement(By.xpath(firstJobXpath));
    }
    WebElement getFirstJobTitleElement(){return chromeDriver.findElement(By.xpath(firstJobTitleXpath));}
    WebElement getFirstJobLocationElement(){return chromeDriver.findElement(By.xpath(firstJobLocationXpath));}
    WebElement getFirstJobTypeElement(){return chromeDriver.findElement(By.xpath(firstJobTypeXpath));}
    List<WebElement> getGridElement(){ return chromeDriver.findElements(By.xpath(gridXpath));}
    public void clickOnAgreeButton(){
        getAgreeButtonElement().click();
    }
    public void clickOnAboutUsButton(){
        getAboutUsButtonElement().click();
    }
    public void clickOnCareersButton(){
        getCareersButtonElement().click();
    }
    public void clickOnCurrentOpeningsButton(){
        getCurrentOpeningsElement().click();
    }
    public void clickOnSkopjeButton(){
        getSkopjeElement().click();
    }
    public void clickOnFirstJovButton(){
        getFirstJobElement().click();
    }
    public String getTitle(){
       return getFirstJobTitleElement().getText();
    }
    public String getLocation(){
        return getFirstJobLocationElement().getText();
    }
    public String getType(){
       return getFirstJobTypeElement().getText();
    }
    public String print(int i ){
            String xPath1 = ("//*[@id=\"current-openings\"]/div/ul/li["+i+"]/a/div[2]");
            String xPath2 = ("//*[@id=\"current-openings\"]/div/ul/li["+i+"]/a/div[3]");
            WebElement info1 =chromeDriver.findElement(By.xpath(xPath1));
            WebElement info2 =chromeDriver.findElement(By.xpath(xPath2));
            return info1.getText()+", "+info2.getText();
    }
    public void printaj() throws IOException {
            File file = new File("resources/allOpenPosition.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
        for(int i=1; i<=getGridElement().size();i++) {
            writer.write(print(i));
            writer.newLine();
        }
        writer.close();
    }
}
