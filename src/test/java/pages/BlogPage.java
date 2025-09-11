package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BlogPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By menuButton = By.xpath("//*[@id='main-menu']/div[1]");
    private By blogsButton = By.xpath("//*[@id='main-menu']/div[2]/a[13]");
    private By listButton = By.xpath("//*[@id='hamburger']");
    private By interiorsDropdown = By.xpath("//*[@id='dropdownContent']/div[2]/div[5]/div[1]/div");
    private By renovationOption = By.xpath("//*[@id='dropdownContent']/div[2]/div[5]/div[2]/a[1]");
    private By overlayCloseBtn = By.cssSelector(".overlay .close-btn"); // Optional overlay

    // Constructor
    public BlogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Navigate to Renovation blogs
    public void navigateToRenovationBlogs() {

        // 1️⃣ Optional overlay close
        try {
            WebElement closeBtn = driver.findElement(overlayCloseBtn);
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
                System.out.println("✅ Overlay closed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("ℹ️ No overlay found, continuing...");
        } catch (Exception e) {
            System.out.println("⚠️ Error closing overlay: " + e.getMessage());
        }

        // 2️⃣ Click Menu button
        try {
            WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
            menuBtn.click();
            System.out.println("✅ Menu button clicked");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Menu button: " + e.getMessage());
            Assert.fail("Menu button click failed: " + e.getMessage());
        }

        // 3️⃣ Click Blog button
        try {
            WebElement blogBtn = wait.until(ExpectedConditions.elementToBeClickable(blogsButton));
            blogBtn.click();
            System.out.println("✅ Blog button clicked");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Blog button: " + e.getMessage());
            Assert.fail("Blog button click failed: " + e.getMessage());
        }

        // 4️⃣ Click List button
        try {
            WebElement listBtn = wait.until(ExpectedConditions.elementToBeClickable(listButton));
            listBtn.click();
            System.out.println("✅ List button clicked");
        } catch (Exception e) {
            System.out.println("❌ Failed to click List button: " + e.getMessage());
            Assert.fail("List button click failed: " + e.getMessage());
        }

        // 5️⃣ Click Interiors dropdown
        try {
            WebElement interiors = wait.until(ExpectedConditions.elementToBeClickable(interiorsDropdown));
            interiors.click();
            System.out.println("✅ Interiors dropdown clicked");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Interiors dropdown: " + e.getMessage());
            Assert.fail("Interiors dropdown click failed: " + e.getMessage());
        }

        // 6️⃣ Click Renovation option
        try {
            WebElement renovation = wait.until(ExpectedConditions.elementToBeClickable(renovationOption));
            renovation.click();
            System.out.println("✅ Renovation option clicked");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Renovation option: " + e.getMessage());
            Assert.fail("Renovation option click failed: " + e.getMessage());
        }

        System.out.println("✅ Navigation to Renovation blogs completed");
    }
}
