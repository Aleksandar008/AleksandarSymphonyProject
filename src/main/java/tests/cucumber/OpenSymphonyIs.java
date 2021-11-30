package tests.cucumber;
import io.cucumber.java.en.Given;
import org.testng.annotations.Test;
import tests.BaseClass;

public class OpenSymphonyIs extends BaseClass {
    @Test
    public void homePageTest(){
        homeScreen.clickOnAgreeButton();
    }

}
