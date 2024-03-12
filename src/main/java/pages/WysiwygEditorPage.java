package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page with What You See Is What You Get Editor inside an <code>iFrame</code
 */
public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeID = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div[2]/div/div[5]/button[1]");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }
    
    /**
     * Switch to editor's iFrame
     */
    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeID);
    }

    /**
     * Clear anything inside the editor text area
     * Good practice to exit out of a frame after performing an action
     */
    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    /**
     * Add text to editor text area
     * Good practice to exit out of a frame after performing an action
     */
    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    /**
     * Get text in editor 
     * Good practice to exit out of a frame after performing an action
     */
    public String getTextArea() {
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }


    public void decreaseIndent() {
        // Button is outside the iFrame and can be clicked as normal
        driver.findElement(decreaseIndentButton).click();
    }


}
