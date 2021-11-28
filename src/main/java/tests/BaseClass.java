package tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import screens.AboutUsScreen;
import screens.HomeScreen;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    ChromeDriver chromeDriver;
    //C:\Users\Aleksandar Zahariev\Documents\Aleksandar Symphony\symphony-main\symphony-main\AleksandarSymphonyProject\chromedriver_win32
    public HomeScreen homeScreen;
    public AboutUsScreen aboutUsScreen;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aleksandar Zahariev\\Documents\\Aleksandar Symphony\\symphony-main\\symphony-main\\AleksandarSymphonyProject\\chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://symphony.is/");
        chromeDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        homeScreen = new HomeScreen(chromeDriver);
        aboutUsScreen = new AboutUsScreen(chromeDriver);

    }

}
