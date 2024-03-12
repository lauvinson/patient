package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.cssSelector("#finish h4");
    private By startButtonId= By.id("start");

    public DynamicLoadingExample2Page(WebDriver driver) {
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

        // WebDriverWait wait = new WebDriverWait(driver, 5);

        /* Wait for 5 seconds at most and poll every 1 second and ignore
        exceptions if no elements on found */
        FluentWait wait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
        
        // Wait at maximum wait time specificed above or if condition is 
        // satisfied - in this case the loading indicator becomes invisible
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));

    }

    public String getLoadingText() {
        return driver.findElement(loadedText).getText();
    }

    public String getStartButtonText() {
        /* Wait for 5 seconds at most and poll every 1 second and ignore
        exceptions if no elements on found */
        FluentWait wait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
        
        // Wait at maximum wait time specificed above or if condition is 
        // satisfied - in this case the loading indicator becomes invisible
        wait.until(ExpectedConditions.visibilityOfElementLocated(startButtonId));        
        return driver.findElement(startButton).getText();
    }





}
