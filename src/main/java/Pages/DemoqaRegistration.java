package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class DemoqaRegistration {

    private WebDriver driver;
    private By firstNameField = By.id("name_3_firstname");
    private By lastNameField = By.id("name_3_lastname");
    private By maritalStatusSingle = By.xpath("//input[@value='single']");
    private By maritalStatusMarried = By.xpath("//input[@value='married']");
    private By maritalStatusDivorced = By.xpath("//input[@value='divorced']");
    private By hobbyDance = By.xpath("//input[@value='dance']");
    private By hobbyReading = By.xpath("//input[@value='reading']");
    private By hobbyCricket = By.xpath("//input[@value='cricket']");
    private By countryDropdown = By.id("dropdown_7");
    private By monthDropdown = By.id("mm_date_8");
    private By dayDropdown = By.id("dd_date_8");
    private By yearDropdown = By.id("yy_date_8");
    private By phoneNumberField = By.id("phone_9");
    private By usernameField = By.id("username");
    private By emailField = By.id("email_1");
    private By profilePicture = By.id("profile_pic_10");
    private By aboutYourselfField = By.id("description");
    private By passwordField = By.id("password_2");
    private By confirmPasswordField = By.id("confirm_password_password_2");
    private By registrationMessage = By.className("piereg_message");
    private By submitButton = By.name("pie_submit");
    private By registrationError = By.xpath("//*[@id=\"post-49\"]/div/p");

    public String generateName(){
        String chars = "0123456789abcdefghijklmnoprstuwxyzABCDEFGHIJKLMNOPRSTUWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for(int i = 0; i<10; i++){
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
    public DemoqaRegistration(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String strFirstName){
        driver.findElement(firstNameField).sendKeys(strFirstName);
    }

    public void setLastName(String strLastName){
        driver.findElement(lastNameField).sendKeys(strLastName);
    }

    public void setMaritalStatus(String status){
        if(status.equalsIgnoreCase("single")){
            driver.findElement(maritalStatusSingle).click();
        }
        else if(status.equalsIgnoreCase("married")){
            driver.findElement(maritalStatusMarried).click();
        }
        else if(status.equalsIgnoreCase("divorced")){
            driver.findElement(maritalStatusDivorced).click();
        }
    }
    public void setHobby(String hobby){
        if(hobby.equalsIgnoreCase("dance"))
            driver.findElement(hobbyDance).click();
        else if(hobby.equalsIgnoreCase("reading"))
            driver.findElement(hobbyReading).click();
        else if(hobby.equalsIgnoreCase("cricket"))
            driver.findElement(hobbyCricket).click();
    }

    public void setCountry(String countryName){
        Select drpCountry = new Select(driver.findElement(countryDropdown));
        drpCountry.selectByVisibleText(countryName);
    }

    public void setDateOfBirth(String mm, String dd, String yy){
        Select drpMonth = new Select(driver.findElement(monthDropdown));
        Select drpDay = new Select(driver.findElement(dayDropdown));
        Select drpYear = new Select(driver.findElement(yearDropdown));
        drpMonth.selectByValue(mm);
        drpDay.selectByValue(dd);
        drpYear.selectByValue(yy);
    }

    public void setPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void setUsernameAndEmail(String username, String email){
        driver.findElement(usernameField).clear();
        driver.findElement(emailField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
    }
    public void setProfilePicture(String picturePath){
        driver.findElement(profilePicture).sendKeys(picturePath);
    }
    public void setAboutYourself(String aboutYourself){
        driver.findElement(aboutYourselfField).sendKeys(aboutYourself);
    }
    public void setPassword(String password, String confirmedPassword){
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmedPassword);
    }
    public void submit(){
        driver.findElement(submitButton).click();
    }
    public String getRegistrationMessage(){
        return driver.findElement(registrationMessage).getText();
    }
    public String getErrorMessage(){
        return driver.findElement(registrationError).getText();
    }
}
