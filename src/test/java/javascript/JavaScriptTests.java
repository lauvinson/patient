package javascript;

import org.testng.annotations.Test;
import base.BaseTests;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        
        var largeAndDeepDomPage = homePage.clickLargeAndDeepDom();

        largeAndDeepDomPage.scrollToTable();

    }

    @Test
    public void testScrollToFifthParagraph() {
        var infiniteScrollPage = homePage.clickInfiniteScroll();
        
        infiniteScrollPage.scrollToParagraph(5);
    }
}