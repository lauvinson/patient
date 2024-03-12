package wait;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {

        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        String text = loadingPage.getLoadingText();

        Assert.assertEquals(text, "Hello World!", "Loading text incorrect"); 
    } 

    @Test
    public void testWaitUntilVisible() {

        var loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        String text = loadingPage.getLoadingText();

        Assert.assertEquals(text, "Hello World!", "Loading text incorrect"); 
    } 

}