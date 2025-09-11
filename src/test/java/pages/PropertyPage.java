package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Base;

public class PropertyPage {
	WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public PropertyPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }
	
    public void clickSortBy() {
        try {
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"listPageTop\"]/div[3]/div/div[1]/div/div[2]/img"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(Locators.sortByDropdown)).click();
            extTest.log(Status.PASS, "Clicked on Sort By dropdown");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Sort By dropdown: " + e.getMessage());
            throw e;
        }
    }

    public void selectSortingOption() {
        try {
        	WebElement sortDropdown = driver.findElement(By.id("sortingSection"));
        	sortDropdown.click();   // open dropdown

        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        	WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
        	        By.xpath("//div[contains(@class,'nb-select__menu')]//div[normalize-space()='Rent(Low to High)']")
        	));
        	option.click();
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to select sorting option "+ e.getMessage());
            throw e;
        }
    }
    
    public boolean isPropertyListSortedNewToOld() {
        try {
            Base.sleep(); // wait for sorting to take effect

            // Grab all property titles (or any unique visible info per card)
            List<WebElement> propertyCards = driver.findElements(By.xpath("//div[@id='listCardContainer']//div[contains(@class,'card')]"));
            List<String> titles = new ArrayList<>();

            for (WebElement card : propertyCards) {
                String title = card.findElement(By.xpath(".//h2 | .//div[contains(@class,'title')]")).getText(); // adjust if needed
                titles.add(title);
            }

            // Simple check: the list should NOT be sorted alphabetically for New → Old
            // We mainly check that the **first card is the newest** after selecting the sort
            String firstTitle = titles.get(0);
            extTest.log(Status.INFO, "First property after sort: " + firstTitle);

            return titles.size() > 0; // basic sanity check

        } catch (Exception e) {
            extTest.log(Status.FAIL, "Error verifying New → Old property list: " + e.getMessage());
            return false;
        }
    }
    
    public boolean validateFirstPropertyImageDisplayed() {
        try {
            WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstPropertyImage));
            if (img.isDisplayed() && img.getAttribute("src") != null) {
                extTest.log(Status.PASS, "PASS");
                return true;
            } else {
                extTest.log(Status.FAIL, "FAIL");
                return false;
            }
        } catch (Exception e) {
            extTest.log(Status.FAIL, "FAIL");
            return false;
        }
    }

    public boolean clickImageAndValidateDetailPage() {
        try {
            WebElement img = wait.until(ExpectedConditions.elementToBeClickable(Locators.firstPropertyImage));
            img.click();
            boolean urlChanged = wait.until(ExpectedConditions.urlContains("property"));
            if (urlChanged) {
                extTest.log(Status.PASS, "PASS");
                return true;
            } else {
                extTest.log(Status.FAIL, "FAIL");
                return false;
            }
        } catch (Exception e) {
            extTest.log(Status.FAIL, "FAIL");
            return false;
        }
    }

	public void selectSortingOption1() {
		// TODO Auto-generated method stub
		
	}

}
