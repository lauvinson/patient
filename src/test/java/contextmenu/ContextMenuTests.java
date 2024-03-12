package contextmenu;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;

/**
 * All tests for login functionality
 */
public class ContextMenuTests extends BaseTests {

    @Test
    public void testSuccessfulContextClick() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.contextClickHotSpot();

        Assert.assertEquals(contextMenuPage.getAlertText() ,"You selected a context menu", "Context menu text incorrect");
        contextMenuPage.alertClose();
    }

}
