package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/acservice.feature",
    glue = {"stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports-ac.html",
        "json:target/cucumber-ac.json"
    },
    monochrome = true
)
public class TestRunner_AC_Service extends AbstractTestNGCucumberTests {
}
