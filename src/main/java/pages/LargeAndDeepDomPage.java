package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls down page to the table, requires
     * JavaScript as WebElement does not support scrolling to it
     */
    public void scrollToTable() {
        WebElement tableElement = driver.findElement(table);
        
        String script = "arguments[0].scrollIntoView();";

        /* Cast driver to JS Exector
         * and execute JS while passing argument
         * to the JS 
         */
        ((JavascriptExecutor)driver).executeScript(script, tableElement);

    }

}
