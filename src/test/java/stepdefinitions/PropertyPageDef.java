package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PropertyPage;

public class PropertyPageDef {
	
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	
	PropertyPage propertyPage;

	@Given("User is on House Rent page")
    public void user_is_on_house_rent_page() {
		String actResult = driver.getCurrentUrl();
		Assert.assertTrue(actResult.contains("https://www.nobroker.in/property/rent/chennai/Velachery"));
    }
	
	@When("User selects sort by")
	public void user_selects_sort_by() {
		propertyPage=new PropertyPage(driver, extTest);
		propertyPage.clickSortBy();
	}
	
	@When("user selects sorting options")
	public void user_selects_sorting_option() {
		propertyPage.selectSortingOption();

	}
	
	@Then("Property list should display in sorted")
	public void property_list_should_display_in_sorted() {
	    boolean isSorted = propertyPage.isPropertyListSortedNewToOld();
	    Assert.assertTrue(isSorted, "Property list is not displayed in New → Old order");
	    extTest.log(Status.PASS, "Property list is displayed in New → Old order");
	}
	
	@When("User views image of property card")
    public void user_views_image_of_property_card() {
		propertyPage=new PropertyPage(driver, extTest);
        boolean isDisplayed = propertyPage.validateFirstPropertyImageDisplayed();
        Assert.assertTrue(isDisplayed, "Property image is not displayed");
    }

    @Then("Property images should be displayed")
    public void property_images_should_be_displayed() {
        boolean navigated = propertyPage.clickImageAndValidateDetailPage();
        Assert.assertTrue(navigated, "Property detail page did not open after clicking image");
    }




}