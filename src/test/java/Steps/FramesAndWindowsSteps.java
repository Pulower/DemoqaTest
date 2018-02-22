package Steps;

import Base.BaseUtil;
import Pages.FramesAndWindowsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import java.util.ArrayList;


public class FramesAndWindowsSteps extends BaseUtil{

    private FramesAndWindowsPage framesAndWindows;
    private String parentWindow;
    private BaseUtil base;

    public FramesAndWindowsSteps(BaseUtil base) {
        this.base = base;
        framesAndWindows = new FramesAndWindowsPage(driver);
    }

    @When("^I click NewBrowserTab$")
    public void iClickNewBrowserTab() {
        parentWindow = driver.getWindowHandle();
        framesAndWindows.createNewBrowserTab();
    }

    @And("^I switch to child window$")
    public void iSwitchToChildWindow() {
        for (String childWindow : driver.getWindowHandles()) {
            driver.switchTo().window(childWindow);
        }
    }

    @And("^I back to homepage$")
    public void iBackToHomepage() {
        framesAndWindows.returnToHomepage();
    }

    @And("^I switch to parent window$")
    public void iSwitchToParentWindow() {
        driver.switchTo().window(parentWindow);
    }

    @And("^I close child window$")
    public void iCloseChildWindow() {
       driver.close();
    }

    @Then("^Windows count should be (\\d+)$")
    public void windowsCountShouldBe(int count) {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        Assert.assertEquals(windows.size(), count);
    }
}
