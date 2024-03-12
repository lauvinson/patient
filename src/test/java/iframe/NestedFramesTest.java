package iframe;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;
import pages.NestedFramesPage;

public class NestedFramesTest extends BaseTests {
    
    @Test
    public void testLeftAndBottomNestedFrames() {
        var framesPage = homePage.clickFramesPage();
        NestedFramesPage nestedFramesPage = framesPage.clickNestedFramesLink();

        String text1 = nestedFramesPage.getLeftFrameText();
        String text2 = nestedFramesPage.getBottomFrameText();

        Assert.assertEquals(text1, "LEFT");
        Assert.assertEquals(text2, "BOTTOM");
    }
}
