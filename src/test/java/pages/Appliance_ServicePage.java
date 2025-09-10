package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Appliance_ServicePage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Appliance_ServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By acApplianceService = By.xpath("//*[@id='hs_ac_repair']/div[2]"); // AC & Appliance Service
    private By applianceRepairOption = By.xpath("//*[@id=\"app\"]/div/div/main/div/div/div[2]/div/div/div/div[2]/div[2]"); // Appliance Repair option
    private By refrigeratorServiceOption = By.xpath("//*[@id=\"hs_appliance\"]/div[1]/div[1]/div"); // Refrigerator option


    /**
     * Navigate to AC Services
     */
    public void navigateToACServicesForBooking() {
        // Click main menu
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
        System.out.println("✅ Menu button clicked.");

        // Click Painting & Cleaning
        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        painting.click();
        System.out.println("✅ Painting & Cleaning clicked.");

        // Handle city selection modal
        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            System.out.println("✅ Chennai city selected.");
        } catch (Exception e) {
            System.out.println("ℹ City modal not displayed, continuing...");
        }

        // Click AC & Appliance Services
        WebElement acAppliance = wait.until(ExpectedConditions.visibilityOfElementLocated(acApplianceService));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", acAppliance);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acAppliance);
        System.out.println("✅ AC & Appliance Services clicked.");

        // Existing steps for AC Repair...
        // ... skipped for brevity
    }

    /**
     * Navigate to Appliance Repair and select Refrigerator service
     */
    public void navigateToApplianceRepairForBooking() {
        // Click main menu
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
        menu.click();
        System.out.println("✅ Menu button clicked.");

        // Click Painting & Cleaning
        WebElement painting = wait.until(ExpectedConditions.elementToBeClickable(paintingCleaning));
        painting.click();
        System.out.println("✅ Painting & Cleaning clicked.");

        // Handle city selection modal
        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            System.out.println("✅ Chennai city selected.");
        } catch (Exception e) {
            System.out.println("ℹ City modal not displayed, continuing...");
        }

        // Click AC & Appliance Services
        WebElement acAppliance = wait.until(ExpectedConditions.visibilityOfElementLocated(acApplianceService));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", acAppliance);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acAppliance);
        System.out.println("✅ AC & Appliance Services clicked.");

        // Click Appliance Repair option
        WebElement applianceRepair = wait.until(ExpectedConditions.elementToBeClickable(applianceRepairOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applianceRepair);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applianceRepair);
        System.out.println("✅ Appliance Repair clicked.");

        // Select Refrigerator service
        WebElement refrigerator = wait.until(ExpectedConditions.elementToBeClickable(refrigeratorServiceOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", refrigerator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", refrigerator);
        System.out.println("✅ Refrigerator service selected.");
    }
}
