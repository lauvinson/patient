package navigation;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;

public class NavigationTests extends BaseTests {
    
    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testNavigatorExample2() {
        var dynamicLoadingExample2Page = homePage.clickDynamicLoading().controlClickExample2();
        Assert.assertEquals(dynamicLoadingExample2Page.getStartButtonText(), "Start");
    }

}
