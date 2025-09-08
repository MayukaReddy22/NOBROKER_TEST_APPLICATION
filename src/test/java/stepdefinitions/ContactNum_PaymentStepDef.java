package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.*;
import io.cucumber.messages.types.Duration;
import pages.LoginPage;
import utils.Base;

public class ContactNum_PaymentStepDef extends Base {

    WebDriverWait wait;

    @Given("the user logs in with a valid mobile number and OTP for booking")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        LoginPage loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        boolean isLoggedIn = loginPage.loginsuccessful();
        Assert.assertTrue(isLoggedIn, "❌ Login failed! Element indicating success not found.");
        System.out.println("✅ User logged in successfully");
    }


    private void enterOtpManually(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@When("User clicks on Pay Rent button")
    public void user_clicks_on_pay_rent_button() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rentPayment']/div[2]"))).click();
    }

    @And("User selects Contact Number payment option")
    public void user_selects_contact_number_payment_option() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div/div[1]/div[1]/div/div/div[2]"))).click();
    }

    @And("User enters PAN number {string}")
    public void user_enters_pan_number(String panNumber) {
        driver.findElement(By.id("IJSPP4270C")).sendKeys(panNumber);
    }

    @And("User clicks on Verify button")
    public void user_clicks_on_verify_button() {
        driver.findElement(By.xpath("//*[@id='btnSubmit5']")).click();
    }

    
}
