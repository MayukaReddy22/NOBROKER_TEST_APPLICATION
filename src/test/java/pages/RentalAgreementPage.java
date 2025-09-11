package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentalAgreementPage {

    WebDriver driver;

    public RentalAgreementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By menuButton = By.xpath("//*[@id=\"main-menu\"]/div[1]"); // Example locator
    private By rentalAgreementLink = By.xpath("//*[@id=\"main-menu\"]/div[2]/a[2]"); // Example locator
    private By chennaiImage = By.xpath("//*[@id='modalContent']/div[2]/div/div[3]/img");
    private By aadhaarEsign = By.xpath("//*[@id=\"content-wrapper\"]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div/div[2]");
    private By ongoingAgreements = By.xpath("//*[@id=\"topSection\"]/div[3]/div[2]");
    private By uploadDraft = By.xpath("//*[@id=\"content-wrapper\"]/div[1]/div/div[2]/div[1]/div[2]/div[1]");
    private By estamped = By.xpath("//*[@id=\"content-wrapper\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]");
    private By renewAgreement = By.xpath("//*[@id=\"topSection\"]/div[3]/div[1]");

    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickRentalAgreement() {
        driver.findElement(rentalAgreementLink).click();
        try {
            WebDriverWait modalWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement chennai = modalWait.until(ExpectedConditions.elementToBeClickable(chennaiImage));
            chennai.click();
            System.out.println("✅ Chennai city selected.");
        } catch (Exception e) {
            System.out.println("ℹ City modal not displayed, continuing...");
        }
    }

   

    public void clickAadhaarEsignAgreement() {
        driver.findElement(aadhaarEsign).click();
    }

  

    public void clickYourOngoingAgreements() {
        driver.findElement(ongoingAgreements).click();
    }

  

    public void clickUploadYourDraft() {
        driver.findElement(uploadDraft).click();
    }

   

    public void clickEStampedAgreement() {
        driver.findElement(estamped).click();
    }

    

    public void clickRenewYourAgreement() {
        driver.findElement(renewAgreement).click();
    }

	public Object isRentalAgreementPageDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object isUploadPageDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object isEStampedPageDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object isAadhaarEsignPageDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}


}
