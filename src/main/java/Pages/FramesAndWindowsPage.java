package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesAndWindowsPage {

    WebDriver driver;

    By newBrowserLink = By.linkText("New Browser Tab");
    By homeBtn = By.id("menu-item-38");

    public FramesAndWindowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewBrowserTab(){
        driver.findElement(newBrowserLink).click();
    }
    public void returnToHomepage(){
        driver.findElement(homeBtn).click();
    }
}
