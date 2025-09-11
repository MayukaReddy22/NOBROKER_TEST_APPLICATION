package stepdefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import pages.AC_ServicePage;
import com.aventstack.extentreports.ExtentTest;

public class AC_Service_StepDef {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    AC_ServicePage acServicePage;

    @When("the user navigates to AC services")
    public void the_user_navigates_to_ac_services() {
        acServicePage = new AC_ServicePage(driver, extTest);
        acServicePage.navigateToACServicesForBooking();
    }
}
