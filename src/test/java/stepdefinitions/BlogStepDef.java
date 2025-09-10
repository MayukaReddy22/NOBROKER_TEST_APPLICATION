package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.BlogPage;

public class BlogStepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    BlogPage blogPage;

    @Given("the user is logged in and navigates to menu")
    public void the_user_is_logged_in_and_navigates_to_menu() {
        loginPage = new LoginPage(driver, Hooks.extTest);

        loginPage.clickLogin();
        loginPage.enterMobileNumber("8122802783");
        loginPage.clickContinue();

        loginPage.enterOtpManually(driver);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
        System.out.println("✅ User logged in successfully");

        // Click the menu button to expand options
        loginPage.clickMenu();
        System.out.println("✅ Menu clicked");
    }

    @When("the user navigates to Interiors -> Renovation")
    public void the_user_navigates_to_interiors_renovation() {
        blogPage = new BlogPage(driver);
        blogPage.navigateToRenovationBlogs();
        System.out.println("✅ Navigated to Interiors -> Renovation");
    }

   
}
