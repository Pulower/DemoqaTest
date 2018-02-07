package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesAndWindowsPage {

    private WebDriver driver;

    private By newBrowserLink = By.linkText("New Browser Tab");
    private By homeBtn = By.id("menu-item-38");
    private WebElement menu;

    public FramesAndWindowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewBrowserTab(){
        menu = driver.findElement(By.id("menu-primary-menu"));
        while(!menu.isDisplayed()){
            driver.navigate().refresh();
        }
        driver.findElement(newBrowserLink).click();
    }
    public void returnToHomepage(){
        driver.findElement(homeBtn).click();
    }
}


