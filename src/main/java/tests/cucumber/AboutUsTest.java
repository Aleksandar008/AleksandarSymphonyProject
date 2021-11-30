package tests.cucumber;

import org.testng.annotations.Test;
import tests.BaseClass;

public class AboutUsTest extends BaseClass {
    @Test
    public void aboutUsTest() throws InterruptedException {
        homeScreen.clickOnAgreeButton();
        homeScreen.clickOnAboutUsButton();
        Thread.sleep(2000);
        aboutUsScreen.checkSelection();
    }
    @Test
    public void valuesOfItemTest() throws InterruptedException {
        /*If you want to test by test please remove the comment bellow*/
//        homeScreen.clickOnAgreeButton();
//        homeScreen.clickOnAboutUsButton();
//        Thread.sleep(2000);
        aboutUsScreen.checkSelection();
        aboutUsScreen.checkHQ();
        aboutUsScreen.checkFounded();
        aboutUsScreen.checkSize();
        aboutUsScreen.checkOffices();
        aboutUsScreen.checkEngineeringHubs();
        aboutUsScreen.checkClients();
    }
    @Test
    public void verifyURL() throws InterruptedException {
        /*If you want to test by test please remove the comment bellow*/
//        homeScreen.clickOnAgreeButton();
//        homeScreen.clickOnAboutUsButton();
//        Thread.sleep(2000);
        aboutUsScreen.checkSelection();
    }

}
