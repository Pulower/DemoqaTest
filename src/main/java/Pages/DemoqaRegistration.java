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

    public void setFirstName(String strFirstName){
        firstNameField.sendKeys(strFirstName);
    }

    public void setLastName(String strLastName){
        lastNameField.sendKeys(strLastName);
    }

    public void setMaritalStatus(String status){
        if(status.equalsIgnoreCase("single")){
            maritalStatusSingle.click();
        }
        else if(status.equalsIgnoreCase("married")){
            maritalStatusMarried.click();
        }
        else if(status.equalsIgnoreCase("divorced")){
            maritalStatusDivorced.click();
        }
    }
    public void setHobby(String hobby){
        if(hobby.equalsIgnoreCase("dance"))
            hobbyDance.click();
        else if(hobby.equalsIgnoreCase("reading"))
            hobbyReading.click();
        else if(hobby.equalsIgnoreCase("cricket"))
            hobbyCricket.click();
    }

    public void setCountry(String countryName){
        Select drpCountry = new Select(countryDropdown);
        drpCountry.selectByVisibleText(countryName);
    }

    public void setDateOfBirth(String mm, String dd, String yy){
        Select drpMonth = new Select(monthDropdown);
        Select drpDay = new Select(dayDropdown);
        Select drpYear = new Select(yearDropdown);
        drpMonth.selectByValue(mm);
        drpDay.selectByValue(dd);
        drpYear.selectByValue(yy);
    }

    public void setPhoneNumber(String phoneNumber){
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void setUsernameAndEmail(String username, String email){
        usernameField.clear();
        emailField.clear();
        usernameField.sendKeys(username);
        emailField.sendKeys(email);
    }
    public void setProfilePicture(String picturePath){
        profilePicture.sendKeys(picturePath);
    }
    public void setAboutYourself(String aboutYourself){
        aboutYourselfField.sendKeys(aboutYourself);
    }
    public void setPassword(String password, String confirmedPassword){
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmedPassword);
    }
    public void submit(){
        submitButton.click();
    }
    public String getRegistrationMessage(){
        return registrationMessage.getText();
    }
    public String getErrorMessage(){
        return registrationError.getText();
    }
}
