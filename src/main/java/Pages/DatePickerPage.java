package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DatePickerPage {

    private WebDriver driver;

    @FindBy(id = "datepicker1")
    private WebElement dateField;

    @FindBy(className = "ui-datepicker-year")
    private WebElement year;

    @FindBy(className = "ui-datepicker-month")
    private WebElement monthName;

    @FindBy(className = "ui-state-default")
    private List<WebElement> dayChooser;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[1]")
    private  WebElement prevDateBtn;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[2]")
    private WebElement nextDateBtn;

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPresentDate(String mm, String dd, String yy) {
        while(!dateField.isDisplayed()){
            driver.navigate().refresh();
        }
        dateField.click();
        while (!year.getText().equals(yy)) {
            nextDateBtn.click();
        }
        while (!monthName.getText().equals(mm)) {
            nextDateBtn.click();
        }
        List<WebElement> list = dayChooser;
        for (WebElement w : list) {
            if (w.getText().equals(dd)) {
                w.click();
            }
        }
    }

    public void setPastDate(String mm, String dd, String yy) {
        dateField.click();
        while (!year.getText().equals(yy)) {
            prevDateBtn.click();
        }
        while (!monthName.getText().equals(mm)) {
            prevDateBtn.click();
        }
        List<WebElement> list = dayChooser;
        for (WebElement w : list) {
            if (w.getText().equals(dd)) {
                w.click();
            }
        }
    }

    public String getDate() {
        return dateField.getAttribute("value");
    }


}