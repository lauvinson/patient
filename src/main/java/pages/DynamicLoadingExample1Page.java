package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.cssSelector("#finish h4");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    /** 
     * Click start button and wait until loading of page is complete before
     * returning back control
     */
    public void clickStart() {
        driver.findElement(startButton).click();

        /* Wait object the tells maximum time to wait during an interaction
        Other configurations include polling time, exceptions */

        /* Wait for 5 seconds at most and poll every 1 second and ignore
        exceptions if no elements on found */
        FluentWait wait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
        
        // Wait at maximum wait time specificed above or if condition is 
        // satisfied - in this case the loading indicator becomes invisible
        wait.until(ExpectedConditions.invisibilityOf(
            driver.findElement(loadingIndicator)));

    }

    public String getLoadingText() {
        return driver.findElement(loadedText).getText();
    }





}
