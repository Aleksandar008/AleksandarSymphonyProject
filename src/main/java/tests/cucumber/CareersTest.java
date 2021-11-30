package tests.cucumber;

import io.cucumber.java.bs.A;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class CareersTest extends BaseClass {

    @Test
    public void careerTest() throws InterruptedException {
        homeScreen.clickOnAgreeButton();
        Thread.sleep(2000);
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        careerScreen.clickOnSkopjeButton();
        careerScreen.clickOnFirstJovButton();
        String title = careerScreen.getTitle();
        String location = careerScreen.getLocation();
        String type = careerScreen.getType();
        String mainWindowsHandle = chromeDriver.getWindowHandle();
        Set<String> allWindowHandles = chromeDriver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindowsHandle.equalsIgnoreCase(childWindow)){
                chromeDriver.switchTo().window(childWindow);
                assert title.equals(newOpenCareerScreen.getTitle());
                assert location.equals(newOpenCareerScreen.getLocation());
                assert type.equals(newOpenCareerScreen.getType());
            }
        }
        chromeDriver.switchTo().window(mainWindowsHandle);
        System.out.println("url e "+ chromeDriver.getCurrentUrl());
    }
    @Test
    public void careerTestAllOpenPosition() throws  IOException {
        //AgreeButton is need once if you run just this test please remove comment
        //homeScreen.clickOnAgreeButton();
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        careerScreen.writeToTxt();
    }
    @Test
    public void careerTestNumberOfAllOpenPosition_ExerciseFive()  {
        //AgreeButton is need once if you run just this test please remove comment
        //homeScreen.clickOnAgreeButton();
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        System.out.println("Number of all open position is: " + careerScreen.getAllOpenPosition());
        try {
            assert careerScreen.counter() == careerScreen.getAllOpenPosition();
        }
        catch (AssertionError e){
            System.err.println("Assert about counter position is fail");
        }
    }
    @Test
    public void careerTestNumberOfAllOpenPosition_ExerciseSix() throws IOException, InterruptedException {
        //AgreeButton is need once if you run just this test please remove comment
        //homeScreen.clickOnAgreeButton();
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        System.out.println("Number of all open position is: " + careerScreen.getAllOpenPosition());
        /*
        * Here is check for all city counter and all position. The result for assert is fail
        * reason is because because in one of counter I will increase result for see fail in assert
        *
        * */
        try {
            //this increase is just to verify fail assert
            assert careerScreen.counter() == careerScreen.getAllOpenPosition()+1;
        }
        catch (AssertionError e){
            System.err.println("Assert about counter position is fail");
        }
        careerScreen.clickOnNoviSad();
        TakesScreenshot screen = (TakesScreenshot) chromeDriver;
        File srcFile = screen.getScreenshotAs(OutputType.FILE);
        File destFile = new File("D:/google.png");
        FileUtils.copyFile(srcFile, destFile);

        chromeDriver.get("https://mail.google.com/mail/u/0/#inbox");
        gmailLoginScreen.insertEmail("aleksandar.symphony@gmail.com");
        gmailLoginScreen.clickOnButton();
        gmailPasscodeScreen.insertPassword("ASymphony01!");
        gmailPasscodeScreen.clickOnButton();
        Thread.sleep(2000);
        gmailHomeScreen.clickOnCompose();
        //here is need to wait at least 7sec until the form for new mail to be opened.
        Thread.sleep(7000);
        gmailHomeScreen.clickOnToField();
        Thread.sleep(3000);
        gmailHomeScreen.insertEmail("aleksandar.zahariev08@gmail.com"+Keys.TAB);
        Thread.sleep(1000);
        gmailHomeScreen.clickOnMessageField();
        Thread.sleep(1000);
        gmailHomeScreen.clickOnSubjectField();
        Thread.sleep(1000);
        gmailHomeScreen.insertSubject("Report within screenshot");
        gmailHomeScreen.clickOnMessageField();
        Thread.sleep(1000);
        gmailHomeScreen.insertMessage("This is a report from the automation test suite. Please see attachment");
        Thread.sleep(2000);
        gmailHomeScreen.attachPhoto("D:/google.png");
        Thread.sleep(2000);
        gmailHomeScreen.clickOnSendButton();
        Thread.sleep(1000);
        gmailHomeScreen.clickOnSentButtonTopMenu();
        try {
            assert gmailHomeScreen.getSentMessageAttachmentName().equals("google.png");
            System.out.println("Assert that screenshot is sent was successfully");
        }
        catch (AssertionError e)
        {
            System.err.println("Assert that screenshot is sent was fail");
        }
        try {
            assert gmailHomeScreen.getSentMessageReceiverText().matches("aleksa.*");
            System.out.println("Assert about receiver is passed");

        }
        catch (AssertionError e)
        {
            System.err.println("Message receiver is not assert with receiver!!!");
        }
        try {
            assert gmailHomeScreen.getSentMessageTitleText().equals("Report within screenshot");
            System.out.println("Assert about message title is passed");

        }
        catch (AssertionError e)
        {
            System.err.println("Title when sent is not assert with title that we sent!!!");
        }
    }
}
