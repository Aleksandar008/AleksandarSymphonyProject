package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.BaseClass;

public class GmailHomeScreen extends BaseClass  {

    ChromeDriver chromeDriver;
    String composeXpath="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div";
    String toFieldXpath="/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea";
    String nameTo="to";
    String toSubjectXpath="/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[3]/div/input";
    String toSubjectName="subjectbox";
    String messageXpath="/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div";
    String messageID=":et";
    String filedata="Filedata";
    String sendButton="/html/body/div[24]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]";
    String sentButtonTopMenuXpath="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div[4]/div/div/div[2]";
    String sentMessageAttachementXpath="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[5]/div[2]/div/span[2]";
    String sentMessageTitleXpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[5]/div[1]/div/div[2]/span/span";
    String sentMessageReceiverXpath ="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[4]/div[2]/span";
    String sentMessageTextXpath ="/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[1]/td[5]/div[1]/div/span";

    public GmailHomeScreen(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    WebElement getComposeElement(){
        return chromeDriver.findElement(By.xpath(composeXpath));
    }
    WebElement getToFieldElement(){
        return chromeDriver.findElement(By.name(nameTo));
    }
    WebElement getSubjectFieldElement(){
        return chromeDriver.findElement(By.name(toSubjectName));
    }
    WebElement getMessageFieldElement(){
        return chromeDriver.findElement(By.xpath(messageXpath));
    }
    WebElement getSendButtonElement(){
        return chromeDriver.findElement(By.xpath(sendButton));
    }
    WebElement getAttachmentElement(){
        return chromeDriver.findElement(By.name(filedata));
    }
    WebElement getSentButtonTopMenuElement(){return chromeDriver.findElement(By.xpath(sentButtonTopMenuXpath));}
    WebElement getSentMessageAttachmentElement(){return chromeDriver.findElement(By.xpath(sentMessageAttachementXpath));}
    WebElement getSentMessageTitleElement(){
        return chromeDriver.findElement(By.xpath(sentMessageTitleXpath));
    }
    WebElement getSentMessageReceiverElement(){
        return chromeDriver.findElement(By.xpath(sentMessageReceiverXpath));
    }
    WebElement getSentMessageTextElement(){
        return chromeDriver.findElement(By.xpath(sentMessageTextXpath));
    }

    public void attachPhoto(String s){
        getAttachmentElement().sendKeys(s);
    }
    public void clickOnCompose(){
        getComposeElement().click();
    }
    public void clickOnToField(){
        getToFieldElement().click();
    }
    public void insertEmail(String s){
        getToFieldElement().sendKeys(s);
    }
    public void clickOnSubjectField(){
        getSubjectFieldElement().click();
    }
    public void insertSubject(String s){
        getSubjectFieldElement().sendKeys(s);
    }
    public void clickOnMessageField(){
        getMessageFieldElement().click();
    }
    public void insertMessage(String s){
        getMessageFieldElement().sendKeys(s);
    }
    public void clickOnAttachmentButton(){
        getAttachmentElement().click();
    }
    public void clickOnSendButton(){
        getSendButtonElement().click();
    }
    public void clickOnSentButtonTopMenu(){
        getSentButtonTopMenuElement().click();
    }
    public String getSentMessageAttachmentName(){
        return getSentMessageAttachmentElement().getText();
    }
    public String getSentMessageTitleText(){
        return getSentMessageTitleElement().getText();
    }
    public String getSentMessageReceiverText(){
        return getSentMessageReceiverElement().getText();
    }
    public String getSentMessageText(){
        return getSentMessageTextElement().getText();
    }
}
