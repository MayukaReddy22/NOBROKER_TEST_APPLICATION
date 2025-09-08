package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.AC_ServicePage;

public class AC_Service_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    AC_ServicePage acServicePage;

    @Given("the user logs in with a valid mobile number and OTP for AC service")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully");
    }

    // Changed annotation to match feature file step exactly
    @When("the user navigates to AC services")
    public void the_user_navigates_to_ac_services() {
        acServicePage = new AC_ServicePage(driver);
        acServicePage.navigateToACServicesForBooking();
        System.out.println("✅ Navigated to AC services page");
    }

    
}
