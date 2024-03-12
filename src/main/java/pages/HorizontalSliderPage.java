package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By sliderInputField = By.cssSelector(".sliderContainer input");
    private By sliderValueField = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Keep moving the slider until the desired slider value reaches the targetValue
     * @param targetValue
     */
    public void setSliderValue(String targetValue){
        while(!getSlideValue().equals(targetValue)){
            driver.findElement(sliderInputField).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSlideValue() {
        return driver.findElement(sliderValueField).getText();
    }

}
