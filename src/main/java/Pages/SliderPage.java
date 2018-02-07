package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"slider-range-max\"]/span")
    private WebElement slider;

    @FindBy(id = "menu-primary-menu")
    private WebElement menu;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void resetSlider(int pos) {
        while(!menu.isDisplayed()){
            driver.navigate().refresh();
        }
        for (int i = 0; i <= pos; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void moveSlider(int pos) {
        for (int i = 1; i < pos; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}


