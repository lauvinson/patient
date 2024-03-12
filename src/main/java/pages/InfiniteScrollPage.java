package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls until paragraph with index is in view
     * @param index is based on 1, 2, 3 ...
     */
    public void scrollToParagraph(int index) {

        /* JS to scroll (horizontal, vertical), horizontal = 0 
         and only vertical will scroll the height of the web page */
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExector = (JavascriptExecutor)driver;

        /* scroll once more until paragraphs are equal to index*/
        while(getNumberOfParagraphsPresent() < index) {
            jsExector.executeScript(script);
        }

    }

    /**
     * Get all elements of the text block type and find how many are
     * present on the page
     * @return number of paragraphs
     */
    private int getNumberOfParagraphsPresent() {
        return driver.findElements(textBlocks).size();
    }

}
