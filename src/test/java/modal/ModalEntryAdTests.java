package modal;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;

/**
 * Test modal Window open and close
 */
public class ModalEntryAdTests extends BaseTests {

    @Test
    public void testSuccessfulCloseAndSeeModalLink() {

        var modalEntryAdPage = homePage.clickEntryAd();
        modalEntryAdPage.closeModalWindwow();   

        Assert.assertEquals(modalEntryAdPage.getModalActivateLink(), "click here", "Modal activation link not correct"); 
    }

}
