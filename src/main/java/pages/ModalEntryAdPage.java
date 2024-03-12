package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page with modals (div on top of page that takes focus, but preserves page's DOM)
 */
public class ModalEntryAdPage {

    private WebDriver driver;
    private By modalFooterCloseLink = By.cssSelector(".modal-footer p");
    private By modalActivateLink = By.linkText("click here");

    public ModalEntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeModalWindwow() {
        driver.findElement(modalFooterCloseLink);
    }

    public String getModalActivateLink() {
        return driver.findElement(modalActivateLink).getText();
    }

}
