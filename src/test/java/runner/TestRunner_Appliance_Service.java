package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/applianceService.feature",
    glue = {"stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports-appliance.html",
        "json:target/cucumber-appliance.json"
    },
    monochrome = true
)
public class TestRunner_Appliance_Service extends AbstractTestNGCucumberTests {
}
