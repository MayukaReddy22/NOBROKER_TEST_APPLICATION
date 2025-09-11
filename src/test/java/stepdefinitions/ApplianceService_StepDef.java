package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.Appliance_ServicePage;

public class ApplianceService_StepDef {

    WebDriver driver = Hooks.driver;
  
    Appliance_ServicePage applianceServicePage; // Reusing AC_ServicePage for appliance flow

    

    @When("the user navigates to Appliance Repair and selects Refrigerator")
    public void the_user_navigates_to_appliance_repair_and_selects_refrigerator() {
        applianceServicePage = new Appliance_ServicePage(driver);
        applianceServicePage.navigateToApplianceRepairForBooking();
        System.out.println("✅ Navigated to Appliance Repair and selected Refrigerator option");
    }


    
}
