package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderPage {

    private WebDriver driver;
    private WebElement slider;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void resetSlider(int pos) {
        slider = driver.findElement(By.xpath("//*[@id=\"slider-range-max\"]/span"));
        for (int i = 0; i <= pos; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void moveSlider(int pos) {
        slider = driver.findElement(By.xpath("//*[@id=\"slider-range-max\"]/span"));
        for (int i = 1; i < pos; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
}


