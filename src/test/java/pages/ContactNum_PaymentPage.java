package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactNum_PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ContactNum_PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators
    private By payRentBtn = By.xpath("//*[@id='rentPayment']/div[2]");
//    private By toContactBtn = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div/div[1]/div[1]/div/div/div[2]");
//    private By panNumberField = By.xpath("//*[@id='cx_pan_number']");
//    private By verifyBtn = By.xpath("//*[@id='btnSubmit5']");

    // Methods to interact with elements

    public void clickPayRent() {
        WebElement payRent = wait.until(ExpectedConditions.elementToBeClickable(payRentBtn));
        payRent.click();
        System.out.println("✅ Pay Rent button clicked");
    }

    
}
