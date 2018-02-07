import Pages.FramesAndWindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FramesAndWindowsTest {

    private WebDriver driver;
    private FramesAndWindowsPage framesAndWindows;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demoqa.com/frames-and-windows/");
        driver.manage().window().maximize();
    }

    @Test
    public void CreatingAndSwitchingWindows() {

        framesAndWindows = new FramesAndWindowsPage(driver);
        String parentWindow = driver.getWindowHandle();
        framesAndWindows.createNewBrowserTab();
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
        }
        framesAndWindows.returnToHomepage();
        driver.switchTo().window(parentWindow);
        framesAndWindows.returnToHomepage();
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
        }

        driver.close();

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        Assert.assertEquals(windows.size(), 1);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
