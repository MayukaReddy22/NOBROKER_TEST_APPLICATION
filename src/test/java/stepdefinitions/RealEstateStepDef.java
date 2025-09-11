package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.LoginPage; // assuming you already have this
import pages.RealEstatePage;

public class RealEstateStepDef {

    private static final String Buy = null;
	private WebDriver driver;
    private RealEstatePage realEstatePage;
    private LoginPage loginPage;

    public RealEstateStepDef() {
        // Initialize driver here or through dependency injection
        this.driver = Hooks.driver;
        this.realEstatePage = new RealEstatePage(driver);
        this.loginPage = new LoginPage(driver, null);
    }

    
    @When("User clicks on the menu button for real estate")
    public void user_clicks_on_the_menu_button_for_real_estate() {
        realEstatePage.clickMenu();
    }

    @When("User clicks on blogs button for real estate")
    public void user_clicks_on_blogs_button_for_real_estate() {
        realEstatePage.clickBlogs();
    }

    @When("User clicks on the blog menu for real estate")
    public void user_clicks_on_the_blog_menu_for_real_estate() {
        realEstatePage.clickList();
    }

    @When("User clicks on the real estate dropdown")
    public void user_clicks_on_the_real_estate_dropdown() {
        realEstatePage.clickRealEstateDropdown();
    }

    @When("User selects {string} option from dropdown")
    public void user_selects_option_from_dropdown(String option) {
        if (option.equalsIgnoreCase("Buy")) {
            realEstatePage.selectBuyOption();
        }
    }
    }

   

