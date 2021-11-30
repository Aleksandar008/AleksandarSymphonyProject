package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Struct;
import java.util.List;

public class CareerScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String agreeButtonXPath="//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/div/div[2]/button[1]";
    String aboutUsButtonXpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[4]/a/span";
    String careersButtonXpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[5]/a";
    String currentOpeningsXpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[5]/div/ul/li[2]/a";
    String skopjeXpath="//*[@id=\"current-openings\"]/div/nav/ul/li[7]/button/span";
    String allLocationXpath="//*[@id=\"current-openings\"]/div/nav/ul/li[1]/button/span";
    String firstJobXpath="//*[@id=\"current-openings\"]/div/ul/li[51]/a";
    String firstJobTitleXpath ="//*[@id=\"current-openings\"]/div/ul/li[51]/a/div[2]";
    String firstJobLocationXpath = "//*[@id=\"current-openings\"]/div/ul/li[51]/a/div[3]/div";
    String firstJobTypeXpath="//*[@id=\"current-openings\"]/div/ul/li[51]/a/div[1]";
    String gridXpath = "//*[@id=\"current-openings\"]/div/ul/li";
    String noviSadXpath="//*[@id=\"current-openings\"]/div/nav/ul/li[5]/button/span";

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
    WebElement getallLocationElement(){
        return chromeDriver.findElement(By.xpath(allLocationXpath));
    }
    WebElement getFirstJobElement(){
        return chromeDriver.findElement(By.xpath(firstJobXpath));
    }
    WebElement getFirstJobTitleElement(){return chromeDriver.findElement(By.xpath(firstJobTitleXpath));}
    WebElement getFirstJobLocationElement(){return chromeDriver.findElement(By.xpath(firstJobLocationXpath));}
    WebElement getFirstJobTypeElement(){return chromeDriver.findElement(By.xpath(firstJobTypeXpath));}
    WebElement getNoviSadElement(){return chromeDriver.findElement(By.xpath(noviSadXpath));}
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
    public void clickOnAllLocationButton(){
        getallLocationElement().click();
    }
    public void clickOnFirstJovButton(){
        getFirstJobElement().click();
    }
    public void clickOnNoviSad(){
        getNoviSadElement().click();
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
    public String positionAndLocation(int i ){
            String xPath1 = ("//*[@id=\"current-openings\"]/div/ul/li["+i+"]/a/div[2]");
            String xPath2 = ("//*[@id=\"current-openings\"]/div/ul/li["+i+"]/a/div[3]");
            WebElement info1 =chromeDriver.findElement(By.xpath(xPath1));
            WebElement info2 =chromeDriver.findElement(By.xpath(xPath2));
            return info1.getText()+", "+info2.getText();
    }
    public int counter(){
        int belgrad=0,nis=0,bosnia=0,novisad=0,sarajevo=0,skopje=0;
        for (int i=1;i<=getGridElement().size();i++){
            String xPath2 = ("//*[@id=\"current-openings\"]/div/ul/li["+i+"]/a/div[3]");
            WebElement info2 =chromeDriver.findElement(By.xpath(xPath2));
            if (info2.getText().matches(".*Belgrade.*")){
                belgrad++;
            }
            if(info2.getText().matches(".*Bosnia and Herzegovina.*")){
                bosnia++;
            }
            if(info2.getText().matches(".*Niš.*")){
                nis++;
            }
            if(info2.getText().matches(".*Novi Sad.*")){
                novisad++;
            }
            if(info2.getText().matches(".*Sarajevo.*")){
                sarajevo++;
            }
            if(info2.getText().matches(".*Skopje.*")){
                skopje++;
            }
        }
        System.out.println("Belgrade has: " + belgrad + " position");
        System.out.println("Bosnia and Herzegovina has: " + bosnia + " position");
        System.out.println("Niš has: " + nis + " position");
        System.out.println("Novi Sad has: " + novisad + " position");
        System.out.println("Sarajevo has: " + sarajevo + " position");
        System.out.println("Skopje has: " + skopje + " position");
        int sum =belgrad+bosnia+nis+novisad+sarajevo+skopje;
        System.out.println("All position is: "+sum);
        return sum;
    }
    public void writeToTxt() throws IOException {
            File file = new File("resources/allOpenPosition.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
        for(int i=1; i<=getGridElement().size();i++) {
            writer.write(positionAndLocation(i));
            writer.newLine();
        }
        writer.close();
    }
    public int getAllOpenPosition(){
        return getGridElement().size();
    }
}
