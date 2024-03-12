package hover;

import org.testng.*;
import org.testng.annotations.Test;
import base.BaseTests;

public class HoverTests extends BaseTests {
    
    @Test
    public void testHoverUser1() {
        var hoversPage = homePage.clickHovers();

        var caption = hoversPage.hoverOverFigure(1);

        Assert.assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed");
        Assert.assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        Assert.assertTrue(caption.getLink().endsWith("/users/1"), "Link Incorrect");

    }
}
