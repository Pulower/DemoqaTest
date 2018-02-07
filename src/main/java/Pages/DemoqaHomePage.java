package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoqaHomePage {

    private WebDriver driver;
    private By homePageTitle = By.className("entry-title");
    private By registrationTitle = By.className("entry-title");
    private By registrationBtn = By.id("menu-item-374");

    public DemoqaHomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageTitle(){
        while (!driver.findElement(homePageTitle).isDisplayed()){
            driver.navigate().refresh();
        }
        return driver.findElement(homePageTitle).getText();
    }

    public String getRegistrationTitle(){
        return driver.findElement(registrationTitle).getText();
    }

    public void clickRegistration(){
        driver.findElement(registrationBtn).click();
    }
}
