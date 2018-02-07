import Pages.DemoqaHomePage;
import Pages.DemoqaRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private DemoqaHomePage objHomePage;
    private DemoqaRegistration objRegistration;
    private String oldName;
    private String newName;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 25);
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
        oldName = objRegistration.generateName();
        newName = objRegistration.generateName();
        objRegistration.setFirstName("Edward");
        objRegistration.setLastName("Dziąsło");
        objRegistration.setMaritalStatus("single");
        objRegistration.setHobby("dance");
        objRegistration.setCountry("Poland");
        objRegistration.setDateOfBirth("5","12", "1995");
        objRegistration.setPhoneNumber("48123123123");
        objRegistration.setUsernameAndEmail(oldName, oldName+"@onet.pl");
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
        objRegistration.setUsernameAndEmail(newName, oldName+"@onet.pl");
        objRegistration.setCountry("Poland");
        objRegistration.setDateOfBirth("5","12", "1995");
        objRegistration.setPassword("Edward123", "Edward123");
        objRegistration.submit();
        Assert.assertEquals(objRegistration.getErrorMessage(), "Error: E-mail address already exists");

        System.out.println("Changing password");
        objRegistration.setUsernameAndEmail(newName, newName+"@onet.pl");
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
