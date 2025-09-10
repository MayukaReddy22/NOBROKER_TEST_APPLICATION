package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features/contactnumpayment.feature",
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner_ContactNum_PaymentPage extends AbstractTestNGCucumberTests {
}
