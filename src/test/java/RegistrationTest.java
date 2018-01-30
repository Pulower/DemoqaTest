import Pages.DemoqaHomePage;
import Pages.DemoqaRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    WebDriver driver;
    DemoqaHomePage objHomePage;
    DemoqaRegistration objRegistration;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://demoqa.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void correctRegistration(){
        objHomePage = new DemoqaHomePage(driver);
        Assert.assertEquals(objHomePage.getHomePageTitle(), "Home");
        objHomePage.clickRegistration();
        Assert.assertEquals(objHomePage.getRegistrationTitle(), "Registration");

        objRegistration = new DemoqaRegistration(driver);
        objRegistration.setFirstName("Edward");
        objRegistration.setLastName("Dziąsło");
        objRegistration.setMaritalStatus("single");
        objRegistration.setHobby("dance");
        objRegistration.setCountry("Poland");
        objRegistration.setDateOfBirth("5","12", "1995");
        objRegistration.setPhoneNumber("48123123123");
        objRegistration.setUsernameAndEmail("Borys123", "borys123@onet.pl");
        objRegistration.setProfilePicture("E:\\edward.jpg");
    }

    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
