package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.BlogPage;

public class BlogStepDef {

    WebDriver driver = Hooks.driver;
  
    BlogPage blogPage;

   
    @When("the user navigates to Interiors -> Renovation")
    public void the_user_navigates_to_interiors_renovation() {
        blogPage = new BlogPage(driver);
        blogPage.navigateToRenovationBlogs();
        System.out.println("✅ Navigated to Interiors -> Renovation");
    }

   
}
