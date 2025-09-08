package pages;

import org.openqa.selenium.WebDriver;

import objectrepository.PaymentLocators;

public class ContactNum_PaymentPage {
    WebDriver driver;

    public ContactNum_PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPayRent() throws InterruptedException {
        driver.findElement(PaymentLocators.payRentButton).click();
        Thread.sleep(3000);
    }

    public void selectContactNumberOption() throws InterruptedException {
        driver.findElement(PaymentLocators.toContactButton).click();
        Thread.sleep(3000);
    }

    public void enterPanNumberAndVerify(String panNumber) {
        driver.findElement(PaymentLocators.panNumberInput).sendKeys(panNumber);
        driver.findElement(PaymentLocators.verifyButton).click();
    }
}