package objectrepository;

import org.openqa.selenium.By;


public class UpiLocators {
	    public By payRentButton = By.xpath("//div[@class='text-header-text-color' and text()='Pay Rent']");
	    public By upiPaymentOption = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div/div[1]/div[2]/div/div");
	    public By panInputField = By.xpath("//input[@placeholder='Enter PAN']");
	    public By verifyButton = By.xpath("//*[@id='btnSubmit5']");
}