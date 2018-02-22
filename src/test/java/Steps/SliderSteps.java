package Steps;

import Base.BaseUtil;
import Pages.SliderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class SliderSteps extends BaseUtil{

    private SliderPage slider;
    private BaseUtil base;

    public SliderSteps(BaseUtil base) {
        this.base = base;
        slider = new SliderPage(driver);
    }

    @When("^I reset slider$")
    public void iResetSlider() {
        slider.resetSlider();
    }

    @And("^move slider to (\\d+)$")
    public void moveSliderToSliderPosition(int sliderPos) {
        slider.moveSlider(sliderPos);
    }

    @Then("^I check ([^\"]*)$")
    public void iCheckSliderRange(String range) {
        Assert.assertEquals(slider.getSliderPos(), "left: " + range + ";");
    }
}
