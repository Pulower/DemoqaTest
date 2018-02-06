import Pages.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SliderTest {

    WebDriver driver;
    SliderPage slider;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demoqa.com/slider/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider (name = "SliderProvider")
    public Object[][] getSliderPosition(){
        return new Object[][]
                {
                        {1},{2},{3},{4},{5},{6},{7},{8},{9},{10}
                };
    }

    @Test(dataProvider = "SliderProvider")
    public void sliderTest(int sliderPos){
        slider = new SliderPage(driver);
        slider.resetSlider(sliderPos);
        slider.moveSlider(sliderPos);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
