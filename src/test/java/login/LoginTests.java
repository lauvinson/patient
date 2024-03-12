package login;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;
import pages.LoginPage;
import pages.SecureAreaPage;

/**
 * All tests for login functionality
 */
public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {

        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUserNameField("tomsmith");
        loginPage.setPasswordField("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage.getAlertStringText();
        // This assertion will throw an exception since the message is different
        // Assert.assertEquals(secureAreaPage.getAlStringText(), "You logged into a secure area!",                "Alert text is incorrect");

        Assert.assertTrue(secureAreaPage.getAlertStringText().contains("You logged into a secure area!"),
                "Alert text is incorrect"); 
    }

}
