package objectrepository;

import org.openqa.selenium.By;


public class PaymentLocators {
	    public By payRentButton = By.xpath("//div[@class='text-header-text-color' and text()='Pay Rent']");
	    public By contactNumberOption = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div/div[1]/div[1]/div/div/div[2]");
	    public By panInputField = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[3]/form");
	    public By verifyButton = By.xpath("//*[@id='btnSubmit5']");
}
