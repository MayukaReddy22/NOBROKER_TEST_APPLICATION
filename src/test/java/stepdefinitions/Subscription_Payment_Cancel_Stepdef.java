package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SubscriptionPaymentcancelPage;
import utils.Base;

public class Subscription_Payment_Cancel_Stepdef extends Base {

    LoginPage loginPage;
    SubscriptionPaymentcancelPage subscriptionPage;

   @Given("the user is logged in for payment cancel")
   public void user_is_logged_in_for_payment_cancel() {
       driver.get("https://www.nobroker.in/");

       loginPage = new LoginPage(driver, Hooks.extTest);

       loginPage.clickLogin();
       loginPage.enterMobileNumber("8122802783");
       loginPage.clickContinue();
       loginPage.enterOtpManually(driver);
       loginPage.clickContinue();

       Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
       System.out.println("✅ User logged in successfully");

       subscriptionPage = new SubscriptionPaymentcancelPage(driver);
   }
    @When("the user navigates to Tenant Plans and selects Freedom Plan for view plans")
    public void the_user_navigates_to_tenant_plans_and_selects_freedom_plan_for_view_plans() {
        subscriptionPage.clickMenu();
        subscriptionPage.clickTenantPlans();
        subscriptionPage.clickFreedomPlanSubscribe();
        System.out.println("✅ Freedom Plan Subscribe button clicked, payment page opened");
    }

    @When("the user cancels the payment")
    public void the_user_cancels_the_payment() {
        subscriptionPage.clickBackButton();
        subscriptionPage.confirmCancelPayment();
        System.out.println("✅ Payment cancel confirmed");
    }

    
}