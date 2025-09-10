package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.AC_ServicePage; // Reusing AC_ServicePage but with modified navigation logic in it
import pages.Appliance_ServicePage;

public class ApplianceService_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Appliance_ServicePage applianceServicePage; // Reusing AC_ServicePage for appliance flow

    @Given("the user logs in with a valid mobile number and OTP for {string}")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp(String serviceType) {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully for " + serviceType);
    }

    @When("the user navigates to Appliance Repair and selects Refrigerator")
    public void the_user_navigates_to_appliance_repair_and_selects_refrigerator() {
        applianceServicePage = new Appliance_ServicePage(driver);
        applianceServicePage.navigateToApplianceRepairForBooking();
        System.out.println("✅ Navigated to Appliance Repair and selected Refrigerator option");
    }


    
}
