package keys;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;

public class KeysTests extends BaseTests {

    @Test
    /**
     * Test entering some keys and back space key into the input and check text.
     * Uses Keys class to input special keys
     */
    public void testBackspace() {
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE );

        Assert.assertEquals(keyPage.getResult(), "You entered: BACK_SPACE");

    }

    @Test
    /**
     * Test entering symbol pi and = 3.14
     */
    public void testPi() {
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
        Assert.assertEquals(keyPage.getResult(), "You entered: 4");
    }
    
}
