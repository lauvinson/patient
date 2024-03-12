package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.WindowManager;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkXPathFormat = ".//a[contains(text(), '%s')]";
    private By linkExample1 = By.xpath(String.format(linkXPathFormat, "Example 1"));
    private By linkExample2 = By.xpath(String.format(linkXPathFormat, "Example 2"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(linkExample1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(linkExample1).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page controlClickExample2() {

        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();
        driver.findElement(linkExample1).click();
        action.keyUp(Keys.CONTROL).build().perform();
        WindowManager windowMgr = new WindowManager(driver);
        windowMgr.switchToTab(1);
        return new DynamicLoadingExample2Page(driver);
    }

}
