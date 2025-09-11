package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import io.cucumber.java.en.*;

import java.time.Duration;

public class ContactNum_PaymentStepDef {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    public ContactNum_PaymentStepDef() {
        this.driver = Hooks.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("User is logged in with valid phone number and OTP for contact payment")
    public void user_is_logged_in_with_valid_phone_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);  // Enter OTP manually in console
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully");
    }

    @When("User clicks on Pay Rent button")
    public void user_clicks_on_pay_rent_button() {
        WebElement payRent = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rentPayment']/div[2]")));
        payRent.click();
        System.out.println("✅ Pay Rent button clicked");
    }

    
}
