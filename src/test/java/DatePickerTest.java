import Pages.DatePickerPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DatePickerTest {

    private WebDriver driver;
    private DatePickerPage datePicker;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demoqa.com/datepicker/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void presentDateChoose() {
        datePicker = new DatePickerPage(driver);
        datePicker.setPresentDate("April", "24", "2020");
        Assert.assertEquals(datePicker.getDate(), "April 24, 2020");
    }

    @Test(priority = 1)
    public void pastDateChoose() {
        datePicker = new DatePickerPage(driver);
        datePicker.setPastDate("January", "1", "2017");
        Assert.assertEquals(datePicker.getDate(), "January 1, 2017");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
