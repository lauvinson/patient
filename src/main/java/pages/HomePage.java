package pages;

import org.openqa.selenium.*;

/**
 * Framework page to build a Page Object Model design pattern like getting elements, clicking
 * buttons, etc. This frees up the test classes to focus on testing rather than page object models.
 * 
 * In other words, Selenium work is primarily in the framework classes and not the test cases.
 */
public class HomePage {

    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By dropdownLink = By.linkText("Dropdown");
    private By forgotPasswordLink = By.linkText("Forgot Password");
    private WebDriver driver;

    /**
     * Constructor for main page with links to different items to test out
     * 
     * @param driver Selenium WebDriver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Follows form auth link to look at form input and submission for authentication to secured
     * area
     */
    public LoginPage clickFormAuthentication() {
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }

    /**
     * Follows dropdown page to look at dropdown selection and input
     */
    public DropdownPage clickDropdown() {
        driver.findElement(dropdownLink).click();
        return new DropdownPage(driver);
    }

    /**
     * Follows forget password page to look at form input and submission
     */
    public ForgotPasswordPage clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPage(driver);
    }

    /**
     * Follow Hovers page for look at hover on with mouse functionality
     * 
     * @return
     */
    public HoversPage clickHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }


    public AlertsPage clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload() {
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public ModalEntryAdPage clickEntryAd() {
        clickLink("Entry Ad");
        return new ModalEntryAdPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwygEditorPage clickWYSIWYGEditor() {
        clickLink("WYSIWYG Editor");
        return new WysiwygEditorPage(driver);
    }

    public FramesPage clickFramesPage() {
        clickLink("Frames");
        return new FramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }
    
    public InfiniteScrollPage clickInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }

    private void clickLink(String linkName) {
        driver.findElement(By.linkText(linkName)).click();
    }


}

