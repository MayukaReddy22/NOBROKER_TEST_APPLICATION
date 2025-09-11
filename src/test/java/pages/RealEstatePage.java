package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealEstatePage {
    private WebDriver driver;

    public RealEstatePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By menuButton = By.xpath("//*[@id='main-menu']/div[1]");
    private By blogsButton = By.xpath("//*[@id='main-menu']/div[2]/a[13]");
    private By listButton = By.xpath("//*[@id='hamburger']");
    private By realEstateDropdown = By.xpath("//*[@id='dropdownContent']/div[2]/div[2]/div[1]/div");
    private By buyOption = By.xpath("//*[@id='dropdownContent']/div[2]/div[2]/div[2]/a[1]");

    // Methods
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickBlogs() {
        driver.findElement(blogsButton).click();
    }

    public void clickList() {
        driver.findElement(listButton).click();
    }

    public void clickRealEstateDropdown() {
        driver.findElement(realEstateDropdown).click();
    }

    public void selectBuyOption() {
        driver.findElement(buyOption).click();
    }

    public boolean isBuyPageDisplayed() {
        CharSequence buy = null;
		// Implement your check here, example using URL or heading
        return driver.getCurrentUrl().contains(buy);
    }
}
