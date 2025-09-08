package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    WebDriver driver;

    By payRentLink = By.xpath("/html/body/div[1]/div/main/div[2]/div[2]/div[2]");
    By contactNumberOption = By.xpath("//*[@id='cx_contact_no']");
    By upiOption = By.xpath("/html/body/main/div[2]/div[3]/div[1]/div/div/div");
    By bankAccountOption = By.xpath("//*[@id='scrollthis']/div/div[2]");
    By panNumberField = By.xpath("//*[@id='cx_pan_number']");
    By contactNumberField = By.xpath("//*[@id='cx_contact_no']");
    By upiIdField = By.xpath("//*[@id='upi_id']");
    By bankAccountField = By.xpath("//*[@id='bank_account']");
    By submitButton = By.xpath("//*[@id='submit_payment']");
    By successMessage = By.xpath("//div[contains(text(),'Payment successful')]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWithPhoneNumber(String phone) {
        driver.get("https://www.nobroker.in/");
        driver.findElement(By.xpath("//*[@id='login-signup-form']")).sendKeys(phone);
        // Add additional steps to trigger OTP if needed
    }

    public void navigateToPayRent() {
        driver.findElement(payRentLink).click();
    }

    public void selectContactNumberOption() {
        driver.findElement(contactNumberOption).click();
    }

    public void selectUpiOption() {
        driver.findElement(upiOption).click();
    }

    public void selectBankAccountOption() {
        driver.findElement(bankAccountOption).click();
    }

    public void enterPanNumber(String pan) {
        driver.findElement(panNumberField).sendKeys(pan);
    }

    public void enterContactNumber(String contact) {
        driver.findElement(contactNumberField).sendKeys(contact);
    }

    public void enterUpiId(String upiId) {
        driver.findElement(upiIdField).sendKeys(upiId);
    }

    public void enterBankAccountDetails(String bankAccount) {
        driver.findElement(bankAccountField).sendKeys(bankAccount);
    }

    public void completePayment() {
        driver.findElement(submitButton).click();
    }

    public boolean isPaymentSuccessful() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
