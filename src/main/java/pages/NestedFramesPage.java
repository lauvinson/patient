package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getLeftFrameText() {
        return getNestedFrame("frame-left");
    }

    public String getBottomFrameText() {
        return getFrameText("frame-bottom");
    }

    private String getNestedFrame(String frameName) {
        driver.switchTo().frame("frame-top");
        String text = getFrameText(frameName);
        switchToParentFrame();
        return text;
    }

    private String getFrameText(String frameName) {
        driver.switchTo().frame(frameName);
        String text = driver.findElement(By.tagName("body")).getText();
        switchToParentFrame();
        return text;
    }

    private void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
    
}
