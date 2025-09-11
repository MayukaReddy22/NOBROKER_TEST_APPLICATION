package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SubscriptionPage;
import utils.Base;

public class Subscription_Stepdef extends Base {

    LoginPage loginPage;
    SubscriptionPage tenantPlansPage;

    @Given("the user is logged in for Subscription")
    public void the_user_logged_in_for_subscription() {
        driver.get("https://www.nobroker.in/");

        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully");

        tenantPlansPage = new SubscriptionPage(driver);
    }

    @When("the user navigates to Tenant Plans and selects Freedom Plan")
    public void the_user_navigates_to_tenant_plans_and_selects_freedom_plan() {
        tenantPlansPage.clickMenu();
        tenantPlansPage.clickTenantPlans();
        tenantPlansPage.clickFreedomPlanSubscribe();
        System.out.println("✅ Freedom Plan Subscribe button clicked");
    }
}