package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class DemoqaRegistration {

    private WebDriver driver;

    @FindBy(id = "name_3_firstname")
    private WebElement firstNameField;

    @FindBy(id = "name_3_lastname")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@value='single']")
    private WebElement maritalStatusSingle;

    @FindBy(xpath = "//input[@value='married']")
    private WebElement maritalStatusMarried;

    @FindBy(xpath = "//input[@value='divorced']")
    private WebElement maritalStatusDivorced;

    @FindBy(xpath = "//input[@value='dance']")
    private WebElement hobbyDance;

    @FindBy(xpath = "//input[@value='reading']")
    private WebElement hobbyReading;

    @FindBy(xpath = "//input[@value='cricket']")
    private WebElement hobbyCricket;

    @FindBy(id = "dropdown_7")
    private WebElement countryDropdown;

    @FindBy(id = "mm_date_8")
    private WebElement monthDropdown;

    @FindBy(id = "dd_date_8")
    private WebElement dayDropdown;

    @FindBy(id = "yy_date_8")
    private WebElement yearDropdown;

    @FindBy(id = "phone_9")
    private WebElement phoneNumberField;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "email_1")
    private WebElement emailField;

    @FindBy(id = "profile_pic_10")
    private WebElement profilePicture;

    @FindBy(id = "description")
    private WebElement aboutYourselfField;

    @FindBy(id = "password_2")
    private WebElement passwordField;

    @FindBy(id = "confirm_password_password_2")
    private WebElement confirmPasswordField;

    @FindBy(className = "piereg_message")
    private WebElement registrationMessage;

    @FindBy(name = "pie_submit")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"post-49\"]/div/p")
    private WebElement registrationError;

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
        PageFactory.initElements(driver, this);
    }

    public DemoqaRegistration setFirstName(String strFirstName){
        firstNameField.sendKeys(strFirstName);
        return this;
    }

    public DemoqaRegistration setLastName(String strLastName){
        lastNameField.sendKeys(strLastName);
        return this;
    }

    public DemoqaRegistration setMaritalStatus(String status){
        if(status.equalsIgnoreCase("single")){
            maritalStatusSingle.click();
        }
        else if(status.equalsIgnoreCase("married")){
            maritalStatusMarried.click();
        }
        else if(status.equalsIgnoreCase("divorced")){
            maritalStatusDivorced.click();
        }
        return this;
    }
    public DemoqaRegistration setHobby(String hobby){
        if(hobby.equalsIgnoreCase("dance"))
            hobbyDance.click();
        else if(hobby.equalsIgnoreCase("reading"))
            hobbyReading.click();
        else if(hobby.equalsIgnoreCase("cricket"))
            hobbyCricket.click();
        return this;
    }

    public DemoqaRegistration setCountry(String countryName){
        Select drpCountry = new Select(countryDropdown);
        drpCountry.selectByVisibleText(countryName);
        return this;
    }

    public DemoqaRegistration setDateOfBirth(String mm, String dd, String yy){
        Select drpMonth = new Select(monthDropdown);
        Select drpDay = new Select(dayDropdown);
        Select drpYear = new Select(yearDropdown);
        drpMonth.selectByValue(mm);
        drpDay.selectByValue(dd);
        drpYear.selectByValue(yy);
        return this;
    }

    public DemoqaRegistration setPhoneNumber(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public DemoqaRegistration setUsernameAndEmail(String username, String email){
        usernameField.clear();
        emailField.clear();
        usernameField.sendKeys(username);
        emailField.sendKeys(email);
        return this;
    }
    public DemoqaRegistration setProfilePicture(String picturePath){
        profilePicture.sendKeys(picturePath);
        return this;
    }
    public DemoqaRegistration setAboutYourself(String aboutYourself){
        aboutYourselfField.sendKeys(aboutYourself);
        return this;
    }
    public DemoqaRegistration setPassword(String password, String confirmedPassword){
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmedPassword);
        return this;
    }
    public DemoqaRegistration submit(){
        submitButton.click();
        return this;
    }
    public String getRegistrationMessage(){
        return registrationMessage.getText();
    }
    public String getErrorMessage(){
        return registrationError.getText();
    }
}
