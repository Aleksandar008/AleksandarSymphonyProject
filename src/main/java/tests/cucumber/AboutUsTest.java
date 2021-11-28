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
        homeScreen.clickOnAgreeButton();
        homeScreen.clickOnAboutUsButton();
        Thread.sleep(2000);
        aboutUsScreen.checkSelection();
        aboutUsScreen.checkSelectionHQ();
        aboutUsScreen.checkFounded();
        aboutUsScreen.checkSize();
        aboutUsScreen.checkSelectionOffices();
        aboutUsScreen.checkEngineeringHubs();
        aboutUsScreen.checkClients();
    }

}
