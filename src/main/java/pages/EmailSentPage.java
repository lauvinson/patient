package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {

    private WebDriver driver;
    private By contentText = By.id("content");

    public EmailSentPage(WebDriver driver) {
        this.driver = driver; 
    }

    public String getContentText() {
        return driver.findElement(contentText).getText();
    }


}
