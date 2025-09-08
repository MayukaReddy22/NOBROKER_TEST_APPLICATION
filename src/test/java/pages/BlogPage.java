package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import objectrepository.Locators;

public class BlogPage {

    WebDriver driver;
    WebDriverWait wait;

    public BlogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickMenu() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(Locators.menuButton));
        menu.click();
        System.out.println("✅ Menu clicked.");
    }

    public void clickBlogs() {
        WebElement blogs = wait.until(ExpectedConditions.elementToBeClickable(Locators.blogs));
        blogs.click();
        System.out.println("✅ Blogs clicked.");
    }

    public void clickInteriors() {
        WebElement interiors = wait.until(ExpectedConditions.elementToBeClickable(Locators.interiors));
        interiors.click();
        System.out.println("✅ Interiors clicked.");
    }

    public void selectRenovation() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.dropdown));
        dropdown.click();
        System.out.println("✅ Renovation selected from dropdown.");
    }
}
