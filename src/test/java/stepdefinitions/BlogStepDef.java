package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.BlogPage;

public class BlogStepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    BlogPage navigationPage;

    @Given("the user logs in with a valid mobile number and OTP")
    public void the_user_logs_in_with_a_valid_mobile_number_and_otp() {
        loginPage = new LoginPage(driver, Hooks.extTest);
        
        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();
        
        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();
        
        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully.");
    }

    @When("the user navigates through Menu to select renovation in Interiors")
    public void the_user_navigates_through_menu_to_select_renovation_in_interiors() {
        navigationPage = new BlogPage(driver);

        navigationPage.clickMenu();
        navigationPage.clickBlogs();
        navigationPage.clickInteriors();
        navigationPage.selectRenovation();

        System.out.println("✅ Navigation to renovation completed.");
    }
}
