package training;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import entity.Patient;
import jakarta.annotation.PostConstruct;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.JsonArrayToMap;
import utils.Reader;

@SpringBootApplication
public class AppExample {

    /**
     * String for Sample
     */
    private static final String COMMON_ID = "some-id";
    public static WebDriver driver = null;
    // 存放病人的map key是那条数据的PatientID，value就是那条数据，其他地方可以直接用PatientID取到那条数据
    public static Map<String, Map<String, Object>> patients;

    public static void main(String[] args) throws InterruptedException, IOException {
        // 准备在线的病人数据返回值为新建的map
        patients = JsonArrayToMap.convert("/Users/vinson/Develop/java/datatool/data.json");

        // Optional. If not specified, WebDriver searches the PATH for chromedriver
        System.setProperty("webdriver.chrome.driver",
                "/Users/vinson/Downloads/undetect/chromedriver");
        // ChromeOptions options = new ChromeOptions();
        // Optional. Sets a non-standard location for Chrome, not required if Chrome is installed in
        // a standard location
        // options.setBinary("C:\\Users\\justi\\Downloads\\chrome\\GoogleChromePortable\\App\\Chrome-bin");
        // WebDriver driver = new ChromeDriver(options);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get("http://www.yihhm.com:82");

        Cookie c1 = new Cookie("ASP.NET_SessionId", "2jzaao453s0xt2reqwsr5pj3", "/");
        Cookie c2 = new Cookie(".ASPX-EIPWeb", "1A590BF806E292FB70E97E5B0CA43B27BC04BA33F4B8BACB7D361787E46A8A588579FD5287434692E22FAAD186243069AF255774C3A1BE590A7486D824148FDC32B6D8A2C7E1683007203BD98560982A20F6747F89BFDC24E1D2B6048F70D0250196A51314015E579BBF094EB32AB1660BAA43EC", "/");

        // 添加cookie
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        SpringApplication.run(AppExample.class);
    }

    @PostConstruct
    public void run() {
        Reader<Patient> reader = new Reader<>();
        reader.indexOrNameRead("data.xlsx");

        /*
         * Note: WebDriver API also provides a close() method and sometimes this confuses the
         * beginners. The close() method just closes the browser and can be reopened anytime. It
         * doesn't destroy the WebDriver object. The quit() method is more appropriate when you no
         * longer need the browser.
         */

//        System.exit(0);
    }

    /**
     * Selenium Demonstration code for Screenshots, JavaScript, Cookies
     *
     * @param driver
     */
    private static void otherInteractions(WebDriver driver) {

        /*
         * Taking Screenshots First, we need to cast WebDriver to TakesScreenshot type which is an
         * interface. Next, we can call getScreenshotAs() and pass OutputType.FILE. Finally, we can
         * copy the file into the local file system with the appropriate extensions like *.jpg,
         * *.png, etc.
         */

        File fileScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copy screenshot in local file system with *.png extension
        try {
            FileUtils.copyFile(fileScreenshot, new File("path/MyScreenshot.png"));
        } catch (IOException e) {
            System.out.println("File save problem");
            e.printStackTrace();
        }

        /*
         * Executing JavaScript Inject or execute any valid piece of JavaScript through Selenium
         * WebDriver First, we need to cast WebDriver to the type JavaScriptExecutor
         */
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // There could be several use-cases to do with the JavaScriptExecutor:

        // Performing operations the natural way to do so if the WebDriver API failed - like a
        // click() or sendKeys().
        js.executeScript("driver.getElementById('some-id').click();");

        // Find the element by using WebDriver locators and pass that element to the executeScript()
        // as the second argument. It is the more natural way to use JavaScriptExecutor:

        // First find the element by using any locator
        WebElement element = driver.findElement(By.id(COMMON_ID));

        // Pass the element to js.executeScript() as the 2nd argument
        js.executeScript("arguments[0].click();", element);

        // To set the value of an input field:
        String value = "some value";
        element = driver.findElement(By.id(COMMON_ID));
        js.executeScript("arguments[0].value=arguments[1];", element, value);

        // Scrolling the page to the borttom:

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scrolling the element to bring it to the viewport:

        element = driver.findElement(By.id(COMMON_ID));

        // If the element is at the bottom pass true, otherwise false
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Altering the page (adding or removing some attributes of an element):

        element = driver.findElement(By.id(COMMON_ID));
        js.executeScript("arguments[0].setAttribute('myattr','myvalue')", element);

        /*
         * Accessing Cookies Since many websites use cookies to store user state or other data, it
         * may be useful for you to programmatically access it using Selenium. Some common cookie
         * operations are outlined below.
         */

        // Get all cookies:
        driver.manage().getCookies();

        String targetCookie = "fs30928f";
        org.openqa.selenium.Cookie mySavedCookie =
                new org.openqa.selenium.Cookie("mine", "4y30928f");

        // Get a specific cookie:
        driver.manage().getCookieNamed(targetCookie);

        // Add a cookie:
        driver.manage().addCookie(mySavedCookie);

        // Delete a cookie:
        driver.manage().deleteCookie(mySavedCookie);
    }

    /**
     * Selenium Demonstration code for element interactions from
     *
     * @param driver
     */
    private static void elementInteraction(WebDriver driver) {

        /*
         * Newsletter location using example: <input id="widget-newsletter" type="email" value=""
         * name="email" class="required email input-lg" placeholder="Enter your email...">
         */

        // Locating Elements via className (html attribute class)
        WebElement newsletterEmail = driver.findElement(By.className("required email input-lg"));

        /*
         * e.g. from <select name="age"> <option value="Yet to born">Not Born</option> <option
         * value="Under 20">Under 20</option> <option value="20 to 29">Under 30</option> <option
         * value="30 to 39">Under 40</option> <option value="40 to 50">Under 50</option> <option
         * value="Over 50">Above 60</option> <option value="Ghost">Not Defined</option> </select>
         */
        WebElement age = driver.findElement(By.name("age"));

        // Locating Elements via name, example only
        newsletterEmail = driver.findElement(By.name("email"));

        // Locating Elements via id
        newsletterEmail = driver.findElement(By.id("widget-newsletter"));

        /*
         * Locating Elements via xpath, useful when multiple elements have the same attribute but
         * not the same html value e.g. <input name="gender" type="Radio" value="Female">Female<br>
         */
        WebElement gender = driver.findElement(By.xpath("//input[@value='Female']"));

        // Locating Elements via cssSelector like h1, input - e.g. <input name="language_java"
        // type="Checkbox" value="java">Java<br>
        WebElement languageC = driver.findElement(By.cssSelector("input[value=c]"));
        WebElement languageJava = driver.findElement(By.cssSelector("input[value=java]"));

        // Locating Elements via linkText - .e.g <a href="/">Stack Abuse</a>
        WebElement homepageLink = driver.findElement(By.linkText("Stack Abuse"));

        // Locating Elements via partialLinkText - e.g. <a
        // href="">random-text-xyz-i-wont-change-random-digit-123</a>
        WebElement iWontChangeLink = driver.findElement(By.partialLinkText("i-wont-change"));

        // Wait until load for slow element loading
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // WebElement testingLink = wait.until(
        //         ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Testing")));

        //使用 JavaScript 代码弹出 Alert 弹窗
//        JavascriptExecutor driver_js= ((JavascriptExecutor) driver);
//        driver_js.executeScript("window.alert('来自java的弹窗警告')");
        /*
         * Selenium Demonstration code for element interactions for
         * locating Elements via tagName like <a>, <div>, there may be multiple elements with the
         * same tag Useful if used with findElement on another element which narrows the search
         */
        WebElement tagNameElem = driver.findElement(By.tagName("select"));

        /* === Interactions === */

        // Clicking on a link
        homepageLink.click();

        // Inputting text
        newsletterEmail.sendKeys("billy@gmail.com");

        // Selecting radio buttons
        gender.click();

        // Selecting Checkboxes
        languageC.click();
        languageJava.click();

        // Selecting items from dropdown
        Select select = new Select(age);

        // Select by Displayed Text
        select.selectByVisibleText("Under 30");

        // Select by Value (the value atribute)
        select.selectByValue("20 to 30");

        // Index (starts with 0)
        select.selectByIndex(2);

        // To check if the application allows multiple selections we can run:
        select.isMultiple();

        // There are lots of other useful operations that we can perform on the dropdown list:

        // Getting the list of options:

        java.util.List<WebElement> options = select.getOptions();

        // Getting the list of selected options:

        java.util.List<WebElement> options2 = select.getAllSelectedOptions();

        // Getting the first selected option

        WebElement options3 = select.getFirstSelectedOption();

        // Deselect all options

        select.deselectAll();

        // Deselect by displayed text:

        select.deselectByVisibleText("Under 30");

        // Deselect by value:

        select.deselectByValue("20 to 30");

        // Deselect by index:

        select.deselectByIndex(2);

        // Find and click on the Submit button
        driver.findElement(By.id("submit_htmlform")).click();

        // Find element by name=age and select it
        Select select2 = new Select(driver.findElement(By.name("age")));

        // Get the value of a particular attribute in an element
        driver.findElement(By.id(COMMON_ID)).getAttribute("class");

        // and set it Option 1 using Javascripts
        WebElement elementToChange = driver.findElement(By.id(COMMON_ID));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('some-id').setAttribute('class', 'enable')");
        // and set it Option 2
        setAttribute(elementToChange, "enable", true);

    }

    /**
     * Mouse and keyboard interactions
     */
    private static void mouseAndKeyboard(WebDriver driver) {
        // Onstantiate Actions and pass it the WebDriver instance:
        Actions builder = new Actions(driver);

        // Moving the Mouse
        WebElement elem = driver.findElement(By.id(COMMON_ID));
        builder.moveToElement(elem).build().perform();

        // Dragging an element over another element:

        WebElement sourceElement = driver.findElement(By.id(COMMON_ID));
        WebElement targetElement = driver.findElement(By.id("some-other-id"));
        builder.dragAndDrop(sourceElement, targetElement).build().perform();

        // Dragging an element by some pixels (e.g. 200 px horizontal and 0px vertical):
        elem = driver.findElement(By.id(COMMON_ID));
        builder.dragAndDropBy(elem, 200, 0).build().perform();

        // Pressing Keys
        // Hold a particular key while typing some text like the Shift key:
        elem = driver.findElement(By.id(COMMON_ID));
        builder.keyDown(Keys.SHIFT).sendKeys(elem, "some value").keyUp(Keys.SHIFT).build()
                .perform();

        /* Perform operations like Ctrl+a, Ctrl+c, Ctrl+v, and TAB */

        // Select all and copy
        builder.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "c")).build()
                .perform();

        // Press the tab to focus on the next field
        builder.sendKeys(Keys.TAB).build().perform();

        // Paste in the next field
        builder.sendKeys(Keys.chord(Keys.CONTROL, "v")).build().perform();


    }

    private static void browserInteraction(WebDriver driver) {

        // Can be used for web scraping
        driver.getPageSource();

        // Getting the Page Title
        driver.getTitle();

        // Maximizing the Browser
        driver.manage().window().maximize();
    }

    /**
     * Set and attribute of an WebElement
     *
     * @param element    to change
     * @param value      new value
     * @param clearFirst whether to clear the value first before setting it
     */
    public static void setAttribute(WebElement element, String value, Boolean clearFirst) {
        if (clearFirst) {
            element.clear();
        }
        element.sendKeys(value);
    }
}
