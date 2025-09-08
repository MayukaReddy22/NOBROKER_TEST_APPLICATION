package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(
	features="src\\test\\resources\\features\\home.feature",
	glue="stepdefinitions",
	plugin= {"pretty","html:reports/cucumber-html-report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
	
}