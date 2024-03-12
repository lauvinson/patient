package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;

public class WindowManager {

    private static final Logger LOGGER = Logger.getLogger(WindowManager.class.getName());

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = this.driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    /**
     * @param url Point browser to a URL
     */
    public void goTo(String url) {
        navigate.to(url);
    }

    /**
     * @param tabName name of window tab to switch to
     */
    public void switchToTab(String tabName) {
        var windows = driver.getWindowHandles();

        LOGGER.setLevel(Level.INFO);

        LOGGER.log(Level.INFO, "Number of tabs: " + windows.size());

        LOGGER.log(Level.INFO, "Windows handles:");

        for (Iterator<String> i = windows.iterator(); i.hasNext();) {
            String item = i.next();
            LOGGER.log(Level.INFO, item);
        }

        for (String window : windows) {
            LOGGER.log(Level.INFO, "Switching to window: " + window);
            driver.switchTo().window(window);

            LOGGER.log(Level.INFO, "Current window title: " + driver.getTitle());

            // break if iteration on target tab
            if (tabName.equals(driver.getTitle())) {
                break;
            }
        }
    }

    /**
     * @paran tabNumber is number of the tabs starting from 0
     */
    public void switchToTab(int tabNumber) {
        ArrayList<String> openTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.get(tabNumber));
        LOGGER.log(Level.INFO, "Switching to window handle: " + openTabs.get(tabNumber));
    }

}
