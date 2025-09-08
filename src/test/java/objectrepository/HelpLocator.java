package objectrepository;

import org.openqa.selenium.By;

public class HelpLocator {
	
	//login page locator
	public static By loginButton=By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div");
	public static By inputNumber=By.id("signUp-phoneNumber");
	public static By continueButton=By.id("signUpSubmit");
	public static By otpInputs = By.xpath("//input[@aria-label='Please enter verification code. Digit 1']");
	public static By resendOtpButton=By.xpath("//div[contains(@class,'nb__G_7wy') and text()='Resend OTP']");
}