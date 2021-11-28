package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

public class AboutUsScreen extends BaseClass {

    ChromeDriver chromeDriver;
    String aboutUsButton="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[4]/a/span";
    String careersButton="//*[@id=\"gatsby-focus-wrapper\"]/div/header/div/div[1]/div/nav/ul/li[5]/a/span";
    String hqXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[1]/strong";
    String sanfranciskoXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[1]/div/div/p";
    String foundedXpath = "//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[2]/strong";
    String y2007Xpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[2]/div/div/p";
    String sizeXpath = "//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[3]/strong";
    String n450Xpath ="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[3]/div/div/p";
    String consultingOfficeXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[4]/strong";
    String officesXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[4]/div/div";
    String engineeringXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[5]/strong";
    String officesEngXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[5]/div/div";
    String clientsXpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[6]/strong";
    String n100Xpath="//*[@id=\"gatsby-focus-wrapper\"]/div/main/div/div[2]/div/div[1]/section/ul/li[6]/div/div/p";

    public AboutUsScreen(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }
    WebElement getButtonElement(){
        return chromeDriver.findElement(By.xpath(aboutUsButton));
    }
    WebElement getButtonCareersElement(){
        return chromeDriver.findElement(By.xpath(careersButton));
    }
    WebElement getHQElement(){
        return chromeDriver.findElement(By.xpath(hqXpath));
    }
    WebElement getSFElement(){
        return chromeDriver.findElement(By.xpath(sanfranciskoXpath));
    }
    WebElement getFoundedElement(){
        return chromeDriver.findElement(By.xpath(foundedXpath));
    }
    WebElement getY2007Element(){
        return chromeDriver.findElement(By.xpath(y2007Xpath));
    }
    WebElement getSizeElement(){
        return chromeDriver.findElement(By.xpath(sizeXpath));
    }
    WebElement getN450Element(){
        return chromeDriver.findElement(By.xpath(n450Xpath));
    }
    WebElement getConsultingElement(){
        return chromeDriver.findElement(By.xpath(consultingOfficeXpath));
    }
    WebElement getOfficesElement(){
        return chromeDriver.findElement(By.xpath(officesXpath));
    }
    WebElement getEngineeringElement(){
        return chromeDriver.findElement(By.xpath(engineeringXpath));
    }
    WebElement getOfficesEngElement(){
        return chromeDriver.findElement(By.xpath(officesEngXpath));
    }
    WebElement getClientElement(){
        return chromeDriver.findElement(By.xpath(clientsXpath));
    }
    WebElement getn100Element(){
        return chromeDriver.findElement(By.xpath(n100Xpath));
    }

    public void checkSelection(){
        String url = chromeDriver.getCurrentUrl();
        assert  url.equals("https://symphony.is/about-us");
    }
    public void checkOffices(){
        assert getConsultingElement().getText().equals("Consulting Offices");
        assert getOfficesElement().getText().equals("Amsterdam\n" +
                "Berlin\n" +
                "Copenhagen\n" +
                "London\n" +
                "Denver\n" +
                "Zurich");
        System.out.println("Checking of offices is done");
    }
    public void checkHQ(){
        assert getHQElement().getText().equals("HQ");
        assert getSFElement().getText().equals("San Francisco");
        System.out.println("Checking of HQ is done");

    }
    public void checkFounded(){
        assert getFoundedElement().getText().equals("Founded");
        assert getY2007Element().getText().equals("2007");
        System.out.println("Checking of founded year is done");

    }
    public void checkSize(){
        assert getSizeElement().getText().equals("Size");
        assert getN450Element().getText().equals("450+");
        System.out.println("Checking of size is done");

    }
    public void checkEngineeringHubs(){
        assert getEngineeringElement().getText().equals("Engineering Hubs");
        assert getOfficesEngElement().getText().equals("Sarajevo\n" +
                "Belgrade\n" +
                "Skopje\n" +
                "Novi Sad\n" +
                "Nis");
        System.out.println("Checking of hub is done");

    }
    public void checkClients(){
        assert getClientElement().getText().equals("Clients");
        assert getn100Element().getText().equals("100+");
        System.out.println("Checking of clients size is done");

    }
    public void clickOnCareers(){
        getButtonCareersElement().click();
    }
}
