package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactNum_PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public ContactNum_PaymentPage() {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators
    public By payRentButton = By.xpath("//div[@class='text-header-text-color' and text()='Pay Rent']");
    public By contactNumberOption = By.xpath("//div[contains(text(),'to Contact')]\r\n"
    		+ "");
    public By panInputField = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[3]/form");
    public By verifyButton = By.xpath("//*[@id='btnSubmit5']");

    // Methods to perform actions

    public void clickPayRent() {
        WebElement payRent = wait.until(ExpectedConditions.elementToBeClickable(payRentButton));
        payRent.click();
    }

    public void selectContactNumberOption() {
        WebElement contactOption = wait.until(ExpectedConditions.elementToBeClickable(contactNumberOption));
        contactOption.click();
    }

    public void enterPanNumber(String panNumber) {
        WebElement panField = wait.until(ExpectedConditions.visibilityOfElementLocated(panInputField));
        panField.sendKeys(panNumber);
    }

    public void clickVerifyButton() {
        WebElement verify = wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
        verify.click();
    }
}
