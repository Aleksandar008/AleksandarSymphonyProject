package tests.cucumber;

import org.testng.annotations.Test;
import tests.BaseClass;

import java.util.Iterator;
import java.util.Set;

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
}
