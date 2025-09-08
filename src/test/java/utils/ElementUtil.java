package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

    WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void doClick(By locator) {
        driver.findElement(locator).click();
    }

    public void doSendKeys(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public boolean doIsDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
