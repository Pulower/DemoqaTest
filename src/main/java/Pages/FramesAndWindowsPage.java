package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesAndWindowsPage {

    private WebDriver driver;

    @FindBy(linkText = "New Browser Tab")
    private WebElement newBrowserLink;

    @FindBy(id = "menu-item-38")
    private WebElement homeBtn;

    @FindBy(id = "menu-primary-menu")
    private WebElement menu;


    public FramesAndWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewBrowserTab(){
        while(!menu.isDisplayed()){
            driver.navigate().refresh();
        }
        newBrowserLink.click();
    }
    public void returnToHomepage(){
        homeBtn.click();
    }
}


