package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    
    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver; 
     }
 
     public void setEmailField(String email) {
         driver.findElement(emailField).sendKeys(email);
     }
 
     public EmailSentPage clickRetrievePasswordButton() {
         // temporary workaround due to website error
         driver.get("https://the-internet.herokuapp.com/email_sent");
         return new EmailSentPage(driver);
     }

      
     public EmailSentPage clickRetrievePasswordButtonWithOutBuSentPage() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);
    }
}
