package objectrepository;

import org.openqa.selenium.By;


public class PaymentLocators {
    public static By payRentButton = By.xpath("//*[@id='rentPayment']/div[2]");
    public static By toContactButton = By.xpath("/html/body/div[1]/div/main/div[2]/div[3]/div[1]/div/div[1]/div[1]/div/div/div[2]");
    public static By panNumberInput = By.xpath("//input[@placeholder='Enter PAN number']");
    public static By verifyButton = By.xpath("//*[@id='btnSubmit5']");
}
