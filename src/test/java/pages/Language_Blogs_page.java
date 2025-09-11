package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.time.Duration;

public class Language_Blogs_page {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    // Locators (example)
    private By menuButton = By.id("menuBtn");
    private By blogsButton = By.id("blogsBtn");
    private By listButton = By.id("listBtn");
    private By languageDropdown = By.id("langDropdown");
    private By hindiOption = By.xpath("//li[text()='Hindi']");

    public Language_Blogs_page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

    private void robustClick(By locator, String elementName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement el = driver.findElement(locator);
            try {
                el.click();
                extTest.log(Status.PASS, "Clicked: " + elementName);
            } catch (Exception e1) {
                try {
                    new Actions(driver).moveToElement(el).click().perform();
                    extTest.log(Status.PASS, "Clicked via Actions: " + elementName);
                } catch (Exception e2) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", el);
                    extTest.log(Status.PASS, "Clicked via JS: " + elementName);
                }
            }
        } catch (Exception ex) {
            extTest.log(Status.FAIL, "Failed to click " + elementName + ": " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public void clickMenu() {
        robustClick(menuButton, "Menu Button");
    }

    public void clickBlogs() {
        robustClick(blogsButton, "Blogs Button");
    }

    public void clickHamburger() {
        robustClick(listButton, "Hamburger Menu");
    }

    public void selectLanguageDropdown() {
        robustClick(languageDropdown, "Language Dropdown");
    }

    public void selectHindiLanguage() {
        robustClick(hindiOption, "Hindi Language Option");
    }

    public boolean isHindiSelected() {
        try {
            WebElement hindiCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(hindiOption));
            boolean visible = hindiCheck.isDisplayed();
            extTest.log(Status.INFO, "Hindi language selected: " + visible);
            return visible;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Hindi language not selected: " + e.getMessage());
            return false;
        }
    }
}
