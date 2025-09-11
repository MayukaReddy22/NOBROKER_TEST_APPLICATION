package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BankAccount_PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public BankAccount_PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators
    public By payRentButton = By.xpath("//div[@class='text-header-text-color' and text()='Pay Rent']");
    public By bankAccountOption = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div/div[1]/div[3]/div/div/div[1]");
    public By panInputField = By.xpath("//input[@placeholder='Enter PAN']");
    public By verifyButton = By.xpath("//*[@id='btnSubmit5']");
    public By bankAccountPaymentPageHeader = By.xpath("//h1[contains(text(),'Bank Account Payment')]"); // Adjust if needed

    // Methods
    public void clickPayRent() {
        WebElement payRent = wait.until(ExpectedConditions.elementToBeClickable(payRentButton));
        payRent.click();
    }

    public void selectBankAccountOption() {
        WebElement bankOption = wait.until(ExpectedConditions.elementToBeClickable(bankAccountOption));
        bankOption.click();
    }

    public void enterPanNumber(String pan) {
        WebElement panField = wait.until(ExpectedConditions.visibilityOfElementLocated(panInputField));
        panField.sendKeys(pan);
    }

    public void clickVerifyButton() {
        WebElement verify = wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
        verify.click();
    }

    public boolean isOnBankAccountPaymentPage() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(bankAccountPaymentPageHeader));
        return header.isDisplayed();
    }
}
