package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.RentalAgreementPage;

public class RentalAgreementStepDef {

	private WebDriver driver;
	private LoginPage loginPage;

	public RentalAgreementStepDef() {

		this.driver = Hooks.driver;
	}

	@Given("the user is logged in with valid mobile number and OTP for Rental Agreement")
	public void user_is_logged_in_with_valid_mobile_number_and_otp_for_rental_agreement() {
		loginPage = new LoginPage(driver, Hooks.extTest);

		loginPage.clickLogin();
		loginPage.enterMobileNumber("8122802783");
		loginPage.clickContinue();

		loginPage.enterOtpManually(driver);
		loginPage.clickContinue();

		Assert.assertTrue(loginPage.loginsuccessful(), "Login failed!");
		System.out.println("✅ User logged in successfully");
	}

	@When("the user clicks on the top-right \"Menu\"")
	public void the_user_clicks_on_menu() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickMenu();
	}

	@When("the user clicks on \"Rental Agreement\"")
	public void the_user_clicks_on_rental_agreement() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickRentalAgreement();
	}

	@When("the user clicks on \"Paperless Rental Agreement with Aadhaar E-Sign\"")
	public void the_user_clicks_on_aadhaar() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickAadhaarEsignAgreement();
	}

	@When("the user clicks on \"Your Ongoing Agreements\"")
	public void the_user_clicks_on_your_ongoing_agreements() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickYourOngoingAgreements();
	}

	@When("the user clicks on \"Upload your Draft\"")
	public void the_user_clicks_on_upload() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickUploadYourDraft();
	}

	@When("the user clicks on \"E-Stamped Agreement\"")
	public void the_user_clicks_on_estamped() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickEStampedAgreement();
	}

	@When("the user clicks on \"Renew Your Agreement\"")
	public void the_user_clicks_on_renew() {
		RentalAgreementPage page = new RentalAgreementPage(driver);
		page.clickRenewYourAgreement();
	}
}
