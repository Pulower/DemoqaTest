package Steps;

import Base.BaseUtil;
import Pages.DatePickerPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class DatePickerSteps extends BaseUtil {

    private DatePickerPage datePicker;
    private BaseUtil base;

    public DatePickerSteps(BaseUtil base) {
        this.base = base;
        datePicker = new DatePickerPage(driver);
    }

    @And("^I set present date ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void iSetPresentDate(String mm, String dd, String yy) {
        datePicker.setPresentDate(mm, dd, yy);
    }

    @Then("^I see correct present date in text field$")
    public void iSeeCorrectPresentDateInTextField() {
        Assert.assertEquals(datePicker.getDate(), "April 24, 2020");
    }

    @And("^I set past date ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void iSetPastDate(String mm, String dd, String yy) {
        datePicker.setPastDate(mm, dd, yy);
    }

    @Then("^I see correct past date in text field$")
    public void iSeeCorrectPastDateInTextField() {
        Assert.assertEquals(datePicker.getDate(), "January 1, 2017");

    }
}
