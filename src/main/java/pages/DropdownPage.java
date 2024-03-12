package pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropdown(String option) {
        
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();

        // Lambda expression on each element, get each element's text, then
        // collect into a list of Strings
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    /**
     * Helper method to get the dropdown element
     */
    private Select findDropdownElement() {
        // Select element for Dropdown, different than general WebElement
        // Allow selection of values, index, get options
        return new Select(driver.findElement(dropdown));
    }

    public void selectAllOptions() {
        changeDropdownToMultiple();

        Select dropdown = findDropdownElement();
        dropdown.selectByValue("1");
        dropdown.selectByValue("2");
    }

    private void changeDropdownToMultiple() {
        var jsExector = (JavascriptExecutor)driver;
        String script = "document.querySelector(\"#dropdown\").setAttribute('multiple', '')";
        jsExector.executeScript(script);
    }
}
