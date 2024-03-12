package pages;

import org.openqa.selenium.*;

public class SecureAreaPage {

    private WebDriver driver;
    private By statusAlert = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertStringText() {
        return driver.findElement(statusAlert).getText();
    }
}
