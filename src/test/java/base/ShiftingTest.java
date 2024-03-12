package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.util.List;

/**
 * Check multiple pages and number of links on last page
 */
public class ShiftingTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

    }

    @org.testng.annotations.Test
    public void unitTest() {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        printLocation();        
        WebElement shiftingLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingLink.click();

        printLocation();   
        shiftingLink = driver.findElement(By.partialLinkText("Example 1"));
        shiftingLink.click();

        printLocation();   
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Found " + links.size() + " links.\n");

        driver.quit();
        
        Assert.assertTrue(links.size() > 1);
    }

    public void printLocation() {
        System.out.println("\nPage: " +  driver.getCurrentUrl() + "\n");
    }
}
