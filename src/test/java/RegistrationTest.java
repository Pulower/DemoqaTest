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
        objRegistration.setUsernameAndEmail("Edward105", "edward105@onet.pl");
        objRegistration.setProfilePicture("E:\\edward.jpg");
        objRegistration.setAboutYourself("Im Edward");
        objRegistration.setPassword("Edward123", "Edward123");
        objRegistration.submit();
        Assert.assertEquals(objRegistration.getRegistrationMessage(), "Thank you for your registration");
        System.out.println("Registered");

        objRegistration.setPassword("Edward123", "Edward123");
        objRegistration.submit();
        Assert.assertEquals(objRegistration.getErrorMessage(), "Error: Username already exists");

        System.out.println("Changing username");
        objRegistration.setUsernameAndEmail("Edward205", "edward105@onet.pl");
        objRegistration.setCountry("Poland");
        objRegistration.setDateOfBirth("5","12", "1995");
        objRegistration.setPassword("Edward123", "Edward123");
        objRegistration.submit();
        Assert.assertEquals(objRegistration.getErrorMessage(), "Error: E-mail address already exists");

        System.out.println("Changing password");
        objRegistration.setUsernameAndEmail("Edward205", "edward205@onet.pl");
        objRegistration.setCountry("Poland");
        objRegistration.setDateOfBirth("5","12", "1995");
        objRegistration.setPassword("Edward123", "Edward123");
        objRegistration.submit();
        Assert.assertEquals(objRegistration.getRegistrationMessage(), "Thank you for your registration");
        System.out.println("Registered");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
