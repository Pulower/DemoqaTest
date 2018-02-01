package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerPage {

    WebDriver driver;

    By dateField = By.id("datepicker1");
    By nextDateBtn = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]");
    By prevDateBtn = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]");
    By dayChooser = By.className("ui-state-default");
    By monthName = By.className("ui-datepicker-month");
    By year = By.className("ui-datepicker-year");

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPresentDate(String mm, String dd, String yy) {
        driver.findElement(dateField).click();
        while (!(driver.findElement(year).getText().equals(yy))) {
            driver.findElement(nextDateBtn).click();
        }
        while (!(driver.findElement(monthName).getText().equals(mm))) {
            driver.findElement(nextDateBtn).click();
        }
        List<WebElement> list = driver.findElements(dayChooser);
        for (WebElement w : list) {
            if (w.getText().equals(dd)) {
                w.click();
            }
        }
    }

    public void setPastDate(String mm, String dd, String yy) {
        driver.findElement(dateField).click();
        while (!(driver.findElement(year).getText().equals(yy))) {
            driver.findElement(prevDateBtn).click();
        }
        while (!(driver.findElement(monthName).getText().equals(mm))) {
            driver.findElement(prevDateBtn).click();
        }
        List<WebElement> list = driver.findElements(dayChooser);
        for (WebElement w : list) {
            if (w.getText().equals(dd)) {
                w.click();
            }
        }
    }

    public String getDate() {
        return driver.findElement(dateField).getAttribute("value");
    }


}
