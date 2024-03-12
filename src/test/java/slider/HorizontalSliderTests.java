package slider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends BaseTests {
 
    @Test
    public void testSliding() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.setSliderValue("3");
        horizontalSliderPage.getSlideValue();

        Assert.assertEquals(horizontalSliderPage.getSlideValue(), "3");

    }
}