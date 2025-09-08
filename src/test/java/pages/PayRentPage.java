package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayRentPage {

    WebDriver driver;

    public PayRentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/div/main/div[2]/div[2]/div[2]")
    private WebElement payRentButton;

    public void selectPayRentOption() {
        payRentButton.click();
    }
}
