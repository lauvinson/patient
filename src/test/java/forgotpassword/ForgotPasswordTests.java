package forgotpassword;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testEmailSentText() {
               
        var forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setEmailField("tua@example.com");
        var emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();

        Assert.assertTrue(emailSentPage.getContentText().contains("Your e-mail's been sent"), "No content was found");

    }
}
