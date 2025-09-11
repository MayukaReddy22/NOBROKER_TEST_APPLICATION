package objectrepository;

import org.openqa.selenium.By;

public class Locators {

    public static final By sortByDropdown = null;
	public static final By touchProfile1 = null;
	// login page locator
    public static By loginButton = By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div");
    public static By inputNumber = By.id("signUp-phoneNumber");
    public static By continueButton = By.id("signUpSubmit");
    public static By otpInputs = By.xpath("//input[@aria-label='Please enter verification code. Digit 1']");
    public static By resendOtpButton = By.xpath("//div[contains(@class,'nb__G_7wy') and text()='Resend OTP']");

    /// search section
    public static By searchCity = By.id("searchCity");
    public static By searchLocality = By.id("listPageSearchLocality");
    public static By searchButton = By.xpath("//button[@type='button' and contains(@class,'prop-search-button')]");
    public static By historySection = By.cssSelector("div.QuickBook_autoSearchPopover__g1zGj");
    public static By historyItems = By.cssSelector("div.QuickBook_autoSearchPopover__g1zGj div");

    // AC services locator 
    public static By acServices = By.xpath("//div[contains(@style,'-565px -170px')]");
	public static By firstPropertyImage;
	public static By signOutBtn;
	
	
        //SignOut locator
	    public static By touchProfile = By.xpath("//*[@id=\"profile-icon\"]/div/div[1]/img"); // example
	    public static By signOutBtn1 = By.xpath("//*[@id=\"profile-menu-dropdown\"]/div[6]"); // correct locator
	}

    
    


