package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private By clickableContextBox = By.id("hot-spot");
    private WebDriver driver;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void contextClickHotSpot() {
        var actions = new Actions(driver);
        actions.moveToElement(driver.findElement(clickableContextBox)).contextClick().perform();
    }

    public void alertClose() {
        driver.switchTo().alert().accept();
    }



}
