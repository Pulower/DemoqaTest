package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaHomePage {

    private WebDriver driver;

    @FindBy(className = "entry-title")
    private WebElement homePageTitle;

    @FindBy(id = "menu-item-374")
    private WebElement registrationBtn;

    public DemoqaHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle(){
        while (!homePageTitle.isDisplayed()){
            driver.navigate().refresh();
        }
        return homePageTitle.getText();
    }

    public String getRegistrationTitle(){
        return homePageTitle.getText();
    }

    public void clickRegistration(){
        registrationBtn.click();
    }
}
