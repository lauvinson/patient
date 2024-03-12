package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private WebDriver driver;

    /**
     * Search for div with a class figure that contains the user avatars and user information
     */
    private By figureBox = By.className("figure");

    private By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Hover mouse over a specific numbered figure
     * @param index starts at 1 and the number of the user
     * @return FigureCaption element
     */
    public FigureCaption hoverOverFigure(int index) {

        // List index starts at zero, but index provided will start at 1
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        /*
         * Actions class contains advanced actions for page interaction. 
         * Action uses a builder pattern where methods can be queue and it
         * can execute them all at once
         */
        var actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    /**
     * Inner class to support the figure and caption on 
     * the page with user and profile information
     */
    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }   

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        /**
         * @return http(s) link that the link directs to
         */
        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }


}
