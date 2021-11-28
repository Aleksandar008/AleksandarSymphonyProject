package tests;
import io.cucumber.java8.Ca;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import screens.AboutUsScreen;
import screens.CareerScreen;
import screens.HomeScreen;
import screens.NewOpenCareerScreen;
import tests.cucumber.CareersTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public ChromeDriver chromeDriver;
    //C:\Users\Aleksandar Zahariev\Documents\Aleksandar Symphony\symphony-main\symphony-main\AleksandarSymphonyProject\chromedriver_win32
    public HomeScreen homeScreen;
    public AboutUsScreen aboutUsScreen;
    public CareerScreen careerScreen;
    public NewOpenCareerScreen newOpenCareerScreen;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksandar Zahariev\\Documents\\Aleksandar Symphony\\symphony-main\\symphony-main\\AleksandarSymphonyProject\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://symphony.is/");
        chromeDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        homeScreen = new HomeScreen(chromeDriver);
        aboutUsScreen = new AboutUsScreen(chromeDriver);
        careerScreen = new CareerScreen(chromeDriver);
        newOpenCareerScreen = new NewOpenCareerScreen(chromeDriver);
    }

}
