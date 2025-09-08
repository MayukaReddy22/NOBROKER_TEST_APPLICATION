package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/navigation.feature",
    glue = {"stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/navigation.html",
        "json:target/cucumber-reports/navigation.json",
        "junit:target/cucumber-reports/navigation.xml"
    },
    monochrome = true
)
public class TestRunner_Blog extends AbstractTestNGCucumberTests {
}
