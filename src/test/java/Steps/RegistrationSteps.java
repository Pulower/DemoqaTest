package Steps;

import Base.BaseUtil;
import Pages.DemoqaHomePage;
import Pages.DemoqaRegistration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class RegistrationSteps extends BaseUtil{

    private DemoqaRegistration objRegistration;
    private DemoqaHomePage objHomePage;
    private String oldName;
    private String newName;
    private BaseUtil base;

    public RegistrationSteps(BaseUtil base){
        this.base = base;
        objRegistration = new DemoqaRegistration(driver);
        objHomePage = new DemoqaHomePage(driver);
    }

    @And("^I go to registration page$")
    public void iGoToRegistrationPage() {
        objHomePage.clickRegistration();
        Assert.assertEquals(objHomePage.getRegistrationTitle(), "Registration");
    }

    @And("^I fill all fields$")
    public void iFillAllFields() {
        oldName = objRegistration.generateName();
        newName = objRegistration.generateName();
        objRegistration.setFirstName("Edward")
                .setLastName("Dziąsło")
                .setMaritalStatus("single")
                .setHobby("dance")
                .setCountry("Poland")
                .setDateOfBirth("5", "12", "1995")
                .setPhoneNumber("48123123123")
                .setUsernameAndEmail(oldName, oldName + "@onet.pl")
                .setProfilePicture("E:\\edward.jpg")
                .setAboutYourself("Im Edward")
                .setPassword("Edward123", "Edward123");
    }

    @And("^I click register button$")
    public void iClickRegisterButton() {
        objRegistration.submit();
    }

    @Then("^I see correct registration message$")
    public void iSeeCorrectRegistrationMessage() {
        Assert.assertEquals(objRegistration.getRegistrationMessage(), "Thank you for your registration");
        System.out.println("Registered");
    }

    @When("^I fill again with the same data$")
    public void iFillAgainWithTheSameData() {
        objRegistration.setPassword("Edward123", "Edward123");
    }

    @Then("^I see Username Already Exist message$")
    public void iSeeUsernameAlreadyExistMessage() {
        Assert.assertEquals(objRegistration.getErrorMessage(), "Error: Username already exists");
    }

    @When("^I change username$")
    public void iChangeUsername() {
        System.out.println("Changing username");
        objRegistration.setUsernameAndEmail(newName, oldName + "@onet.pl")
                .setCountry("Poland")
                .setDateOfBirth("5", "12", "1995")
                .setPassword("Edward123", "Edward123");
    }

    @Then("^I see Email address already exist message$")
    public void iSeeEmailAddressAlreadyExistMessage() {
        Assert.assertEquals(objRegistration.getErrorMessage(), "Error: E-mail address already exists");
    }

    @When("^I change email address$")
    public void iChangeEmailAddress() {
        System.out.println("Changing email");
        objRegistration.setUsernameAndEmail(newName, newName + "@onet.pl")
                .setCountry("Poland")
                .setDateOfBirth("5", "12", "1995")
                .setPassword("Edward123", "Edward123");
    }
}
