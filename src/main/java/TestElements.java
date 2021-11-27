import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

//import org.openqa.selenium.remote.CapabilityType;


public class TestElements {
    WebDriver webDriver;
    AndroidDriver androidDriver;
    AppiumDriver appiumDriver;
    MobileElement mobileElement;
    MobileDriver mobileDriver;
    ChromeDriver chromeDriver;

    @BeforeClass
    public void setUp() throws Exception {
         DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "6.0.1");
        capabilities.setCapability("deviceName", "SM-J327P");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("appPackage", "com.viber.voip");
        capabilities.setCapability("appActivity", "com.viber.voip.HomeActivity");

         System.out.println("creating the driver");
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         System.out.println("Appium Driver is created");

     }


    @Test
    public void testViber() throws Exception {

//        List<WebElement>  listItemsWithContacts = appiumDriver.findElements(MobileBy.id("com.viber.voip:id/from"));
//        foundAndClickOnFirstContact(listItemsWithContacts);
//        Thread.sleep(2000);
//        sentDefaultMessage();
//        Thread.sleep(1000);
//        clickOnPhisicalBackButton();
//        Thread.sleep(1000);
//        clickOnPhisicalBackButton();
//        Thread.sleep(2000);
//        clickOnButtonForNewMessage();
//        Thread.sleep(3000);
//        clickOnFieldForSearch();
//        List <WebElement> contactItemList = appiumDriver.findElements(MobileBy.id("com.viber.voip:id/name"));
////         listWithContacts(contactItemList);
//         if(listWithContacts(contactItemList)) {
//             sentDefaultMessage();
//         }
        //        clickOnPhisicalBackButton();
//        clickOnPhisicalBackButton();

        clickOnCallButton();
            clickOnSearchButtonInCall();
            clickOnSearchFieldInCall();
            List<WebElement>  listItemsWithContactsInCall = appiumDriver.findElements(MobileBy.id("com.viber.voip:id/name"));
            Thread.sleep(500);
            if(foundAndClickOnContactInCall(listItemsWithContactsInCall)){
                Thread.sleep(4000);
                endCall();
            }
            else {
                System.out.println("Users is not in list");
            }
            clickOnPhisicalBackButton();
            clickOnPhisicalBackButton();
            clickOnPhisicalBackButton();
            clickOnSearchButtonInCall();
            clickOnSearchFieldInCall();
            clickOnPhisicalBackButton();
//            WebElement ace = appiumDriver.findElement(MobileBy.);



    }

    private void endCall() {
        WebElement endCall = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/phone_end_call"));
        endCall.click();



    }

    private void clickOnSearchFieldInCall() {

        WebElement clickOnSearchFieldInCall = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/search_src_text"));
        clickOnSearchFieldInCall.sendKeys("Aleksandar");
        System.out.println("Click On Search field in Call is executed");


    }

    private boolean foundAndClickOnContactInCall(List<WebElement> listItemsWithContactsInCall) {
        int flag = 0;
        while(true) {
            System.out.println("Numbers of contacts are " + listItemsWithContactsInCall.size());
            for (int i = 0; i < listItemsWithContactsInCall.size(); i++) {
                System.out.println("Contact with number " + i + " is " + listItemsWithContactsInCall.get(i).getText());
                if (listItemsWithContactsInCall.get(i).getText().equals("Aleksandar Zahariev")) {
                    System.out.println("Our Contact is with number " + i + " is " + listItemsWithContactsInCall.get(i).getText());
                    flag = i;
                    break;
                }
            }
            List<WebElement>  listItemsWithContactsInCallFoundIconNumber = appiumDriver.findElements(MobileBy.id("com.viber.voip:id/callButtonView"));
           if(flag>0){
               listItemsWithContactsInCallFoundIconNumber.get(flag).click();
               return true;
           }
           else
           {
               return false;
           }

        }
    }

    private void clickOnSearchButtonInCall() {
        WebElement clickOnSearchButtonInCall = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/menu_search"));
        clickOnSearchButtonInCall.click();
        System.out.println("Click On Search Button in Call is executed");

    }


    private void clickOnCallButton() {
        WebElement clickOnCallButton = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/bottom_nav_tab_2"));
        clickOnCallButton.click();
        System.out.println("Click On Call Button is executed");
    }


    private boolean listWithContacts(List<WebElement> contactItemList) throws Exception {
        int flag=0;
         System.out.println("Contact: Contact Numbers of contacts are " + contactItemList.size());
            for (int i = 0; i < contactItemList.size(); i++) {
                Thread.sleep(2000);
                System.out.println("Contact: Contact with number " + i + " is " + contactItemList.get(i).getText());
                if (contactItemList.get(i).getText().equals("Aleksandar Zahariev")) {
                    System.out.println("Contact: Our Contact is with number " + i + " is " + contactItemList.get(i).getText());
                    contactItemList.get(i).click();
                    flag=1;
                    return true;
                  }

            }

        if(flag==0){
            System.out.println("Item is not in the list ");
            return false;
        }
        return false;
    }

    private void clickOnFieldForSearch() {
        WebElement messageField = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/search_src_text"));
        messageField.click();
        messageField.sendKeys("S");
        clickOnPhisicalBackButton();

    }

    private void clickOnButtonForNewMessage() throws Exception {
        tap(960,1800);
        System.out.println("Button is clicked");
    }


    private void tap(int x,int y) throws Exception {
        Runtime.getRuntime().exec("adb shell input tap " + x + " " + y);
    }


    private void scrolling() throws Exception {
        System.out.println("Scrolling...");
        Thread.sleep(4000);
        TouchAction touchAction = new TouchAction(appiumDriver);
        PointOption pointStart = PointOption.point(413, 1602);
        PointOption pointEnd = PointOption.point(482, 958);
        touchAction.press(pointStart);
        touchAction.moveTo(pointEnd);
        touchAction.release();
        touchAction.perform();
        System.out.println("Scrolling is done");

    }

    private void sentDefaultMessage() throws Exception {

        Thread.sleep(2000);
        WebElement messageField = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/send_text"));
        messageField.click();
        System.out.println("Message field is clicked");
        messageField.sendKeys("Sending default automation message to users");
        System.out.println("Message field is populated with " + messageField.getText());
        WebElement sentButton = appiumDriver.findElement(MobileBy.id("com.viber.voip:id/btn_send"));
        sentButton.click();
        System.out.println("Send button is clicked");

    }

    private void foundAndClickOnFirstContact(List<WebElement> listItemsWithContacts) throws Exception {
        int flag = 0;
        while(true) {
            System.out.println("Numbers of contacts are " + listItemsWithContacts.size());
            for (int i = 0; i < listItemsWithContacts.size(); i++) {
                System.out.println("Contact with number " + i + " is " + listItemsWithContacts.get(i).getText());
                if (listItemsWithContacts.get(i).getText().equals("Svekrva")) {
                    System.out.println("Our Contact is with number " + i + " is " + listItemsWithContacts.get(i).getText());
                    listItemsWithContacts.get(i).click();
                    flag = 1;
                    break;
                }
            }
//            System.out.println("Flag1 ==  " + flag);
            if (flag == 0) {
                scrolling();
            }
//            System.out.println("Flag2  ==  " + flag);

            if (flag ==1) {
//                System.out.println("SYSO == pred break   ");

                break;
            }
//            System.out.println("Flag3 ==  " + flag);

            flag=0;
//            System.out.println("One while cicle is done");

        }

     }

    private void clickOnPhisicalBackButton(){
        appiumDriver.navigate().back();
        System.out.println("Back button is clicked ");
    }

    @AfterClass
    public void teardown() {
        //close the app
        // driver.quit();
    }


}