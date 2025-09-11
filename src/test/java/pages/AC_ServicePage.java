package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AC_ServicePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest extTest;

    // Locators defined inside the class
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By acApplianceService = By.xpath("//*[@id='hs_ac_repair']/div[2]");
    private By acRepairOption = By.xpath("//*[@id=\"app\"]/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]");
    private By acServiceOption = By.xpath("//*[@id='hs_fhc']/div[1]/div[1]");
    private By acServicesPage = By.xpath("//h1[contains(text(),'AC Services')]"); // Example page check

    public AC_ServicePage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }

    // Robust click helper
    private void robustClick(By locator, String name) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement el = driver.findElement(locator);
            try {
                el.click();
                extTest.log(Status.PASS, "Clicked: " + name);
                return;
            } catch (WebDriverException e1) {
                try {
                    new Actions(driver).moveToElement(el).click().perform();
                    extTest.log(Status.PASS, "Clicked via Actions: " + name);
                    return;
                } catch (Exception e2) {
                    try {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", el);
                        extTest.log(Status.PASS, "Clicked via JS: " + name);
                        return;
                    } catch (Exception jsEx) {
                        extTest.log(Status.FAIL, "JS click failed for " + name + ": " + jsEx.getMessage());
                        throw jsEx;
                    }
                }
            }
        } catch (Exception ex) {
            extTest.log(Status.FAIL, "Failed to click " + name + ": " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    // Navigate to AC Services
    public void navigateToACServicesForBooking() {

        // Click Menu
        robustClick(menuBtn, "Menu button");

        // Click Painting & Cleaning
        robustClick(paintingCleaning, "Painting & Cleaning");

        // City selection modal
        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            extTest.log(Status.PASS, "Selected Chennai city");
        } catch (Exception e) {
            extTest.log(Status.INFO, "City modal not displayed, continuing...");
        }

        // Click AC & Appliance Services
        robustClick(acApplianceService, "AC & Appliance Services");

        // Click AC Repair
        robustClick(acRepairOption, "AC Repair");

        // Click AC Service
        robustClick(acServiceOption, "AC Service");
    }

    // Check if AC Services page is displayed
    public boolean isACServicesPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(acServicesPage));
            extTest.log(Status.PASS, "AC Services page is visible.");
            return true;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "AC Services page not visible: " + e.getMessage());
            return false;
        }
    }
}
