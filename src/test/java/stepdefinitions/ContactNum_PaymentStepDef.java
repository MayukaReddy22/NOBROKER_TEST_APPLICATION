package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.ContactNum_PaymentPage;
import io.cucumber.java.en.*;

import java.time.Duration;

public class ContactNum_PaymentStepDef {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ContactNum_PaymentPage paymentPage;

    public ContactNum_PaymentStepDef() {
        this.driver = Hooks.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.paymentPage = new ContactNum_PaymentPage();
    }

    @Given("User is logged in with valid phone number and OTP for contact payment")
    public void user_is_logged_in_with_valid_phone_number_and_otp () {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully");
    }

    @When("User clicks on Pay Rent button")
    public void user_clicks_on_pay_rent_button() {
        WebElement payRent = wait.until(ExpectedConditions.elementToBeClickable(paymentPage.payRentButton));
        payRent.click();
    }

    @When("User selects Contact Number payment option")
    public void user_selects_contact_number_payment_option() {
        WebElement contactOption = wait.until(ExpectedConditions.elementToBeClickable(paymentPage.contactNumberOption));
        contactOption.click();
    }

    @When("User enters PAN number {string}")
    public void user_enters_pan_number(String panNumber) {
        WebElement panField = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentPage.panInputField));
        panField.sendKeys(panNumber);
    }

    @Then("User verifies the PAN number")
    public void user_verifies_the_pan_number() {
        WebElement verify = wait.until(ExpectedConditions.elementToBeClickable(paymentPage.verifyButton));
        verify.click();
    }

    @Then("User is redirected to the payment page")
    public void user_is_redirected_to_the_payment_page() {
        wait.until(ExpectedConditions.urlContains("payment"));
        System.out.println("✅ User is redirected to the payment page");
    }
}
