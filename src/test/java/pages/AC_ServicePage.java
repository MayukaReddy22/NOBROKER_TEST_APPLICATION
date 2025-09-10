package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AC_ServicePage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public AC_ServicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By menuBtn = By.xpath("//*[@id='main-menu']/div[1]");
    private By paintingCleaning = By.xpath("//*[@id='main-menu']/div[2]/a[3]");
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By acApplianceService = By.xpath("//*[@id='hs_ac_repair']/div[2]"); // AC & Appliance Service
    private By acRepairOption = By.xpath("//*[@id=\"app\"]/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]"); // AC Repair option
    private By acServiceOption = By.xpath("//*[@id='hs_fhc']/div[1]/div[1]"); // AC Service
   

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

        // **NEW STEP: Click AC Repair**
        WebElement acRepair = wait.until(ExpectedConditions.elementToBeClickable(acRepairOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", acRepair);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acRepair);
        System.out.println("✅ AC Repair clicked.");

        // Click AC Service
        WebElement acService = wait.until(ExpectedConditions.elementToBeClickable(acServiceOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", acService);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acService);
        System.out.println("✅ AC Service selected.");
        
        
    }


	public void navigateToApplianceServicesForBooking() {
		// TODO Auto-generated method stub
		
	}

    /**
     * Verify AC Services page is visible
     */


}
