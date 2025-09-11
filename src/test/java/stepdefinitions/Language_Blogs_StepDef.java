package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Language_Blogs_page;

import com.aventstack.extentreports.Status;

public class Language_Blogs_StepDef {

    Language_Blogs_page menuPage = new Language_Blogs_page(Hooks.driver, Hooks.extTest);

    @When("the user clicks on the menu in blogs")
    public void the_user_clicks_on_the_menu_in_blogs() {
        try {
            menuPage.clickMenu();
            Hooks.extTest.log(Status.PASS, "Clicked Menu in Blogs");
        } catch (Exception e) {
            Hooks.extTest.log(Status.FAIL, "Failed to click Menu in Blogs: " + e.getMessage());
        }
    }

    @When("the user clicks on blogs for language")
    public void the_user_clicks_on_blogs_for_language() {
        try {
            menuPage.clickBlogs();
            Hooks.extTest.log(Status.PASS, "Clicked Blogs for Language");
        } catch (Exception e) {
            Hooks.extTest.log(Status.FAIL, "Failed to click Blogs for Language: " + e.getMessage());
        }
    }

    @When("the user clicks on the hamburger menu in blogs")
    public void the_user_clicks_on_the_hamburger_menu_in_blogs() {
        try {
            menuPage.clickHamburger();
            Hooks.extTest.log(Status.PASS, "Clicked Hamburger Menu in Blogs");
        } catch (Exception e) {
            Hooks.extTest.log(Status.FAIL, "Failed to click Hamburger Menu: " + e.getMessage());
        }
    }

    @When("the user selects {string} language from the dropdown")
    public void the_user_selects_language_from_the_dropdown(String language) {
        try {
            menuPage.selectLanguageDropdown();
            Hooks.extTest.log(Status.PASS, "Opened Language Dropdown");

            if(language.equalsIgnoreCase("Hindi")) {
                menuPage.selectHindiLanguage();
                Hooks.extTest.log(Status.PASS, "Selected Hindi Language");
            }
        } catch (Exception e) {
            Hooks.extTest.log(Status.FAIL, "Failed to select language: " + e.getMessage());
        }
    }

    @Then("the language should be switched to {string}")
    public void the_language_should_be_switched_to(String language) {
        try {
            if(language.equalsIgnoreCase("Hindi")) {
                Assert.assertTrue(menuPage.isHindiSelected(), "Hindi language was not selected");
                Hooks.extTest.log(Status.PASS, "Hindi language successfully switched");
            }
        } catch (AssertionError ae) {
            Hooks.extTest.log(Status.FAIL, "Assertion failed: " + ae.getMessage());
        } catch (Exception e) {
            Hooks.extTest.log(Status.FAIL, "Error verifying language switch: " + e.getMessage());
        }
    }
}
