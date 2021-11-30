package tests.cucumber;

import io.cucumber.java8.Th;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import tests.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CareersTest extends BaseClass {
    @Test
    public void careerTest() throws InterruptedException {
        homeScreen.clickOnAgreeButton();
        homeScreen.clickOnAboutUsButton();
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
    public void careerTestAllOpenPosition() throws InterruptedException, IOException {
        homeScreen.clickOnAgreeButton();
        homeScreen.clickOnAboutUsButton();
        Thread.sleep(2000);
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        careerScreen.writeToTxt();
    }
    @Test
    public void careerTestNumberOfAllOpenPosition() throws InterruptedException {
        homeScreen.clickOnAgreeButton();
        homeScreen.clickOnAboutUsButton();
        Thread.sleep(2000);
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        System.out.println("Number of all open position is: " + careerScreen.getAllOpenPosition());
        /*
        * Here is check for all city counter and all position the result for assert is fail
        * reason is because your position Application security engineer is based in Novi Sad and Belgrade
        * I count it double in sum of city, and once in counter for all element (for reproduce a fail scenario for exercise 6.
        * */
        assert careerScreen.counter()==careerScreen.getAllOpenPosition();
    }
    @Test
    public void careerTestNumberOfAllOpenPositionExerciseSix() throws InterruptedException, IOException {
        homeScreen.clickOnAgreeButton();
        homeScreen.clickOnAboutUsButton();
        Thread.sleep(2000);
        careerScreen.clickOnCareersButton();
        careerScreen.clickOnCurrentOpeningsButton();
        System.out.println("Number of all open position is: " + careerScreen.getAllOpenPosition());
        /*
        * Here is check for all city counter and all position the result for assert is fail
        * reason is because your position Application security engineer is based in Novi Sad and Belgrade
        * I count it double in sum of city, and once in counter for all element (for reproduce a fail scenario for exercise 6.
        * */
        try {
            assert careerScreen.counter() == careerScreen.getAllOpenPosition();
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
                Thread.sleep(7000);
        gmailHomeScreen.clickOnToField();
        Thread.sleep(3000);
        gmailHomeScreen.insertEmail("aleksandar.zahariev08@gmail.com");
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


    }


}
