package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginpage;
	HomePage homePage;

	@Test(priority = 1, enabled = true, description = "Verify the system's response when attempting to log in without entering credentials.")
	public void verifyInvestorLoginWithoutCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.clickLoginButton();
		Assert.assertTrue(loginpage.getEmptyAlertMessages().getText().equals("Please enter your email and password."),
				"Alert Messages is not appears correctly");
	}

	@Test(priority = 2, enabled = true, description = "Verify the system's response when attempting to log in with only the email details entered.")
	public void verifyInvestorLoginWithoutPasswordCredentials() {
		loginpage = new LoginPage(driver).enterEmail().clickLoginButton();
		Assert.assertTrue(loginpage.getPasswordAlertMessages().getText().equals("Please enter your password."),
				"PasswordAlert Messages is not appears correctly");
	}

	@Test(priority = 3, enabled = true, description = "Verify the system's response when attempting to log in with only the password details entered.")
	public void verifyInvestorLoginWithoutEmailCredentials() {
		loginpage = new LoginPage(driver).enterPassword().clickLoginButton();
		Assert.assertTrue(loginpage.getEmailAlertMessages().getText().equals("Please enter your email."),
				"EmailAlert Messages is not appears correctly");
	}

	@Test(priority = 4, enabled = true, description = "Verify the system's response when attempting to log in with invalid credentials.")
	public void verifyInvestorLoginWithInvalidCredentials() {
		loginpage = new LoginPage(driver).enterInvalidEmail().enterInvalidPassword().clickLoginButton();
		Assert.assertTrue(loginpage.getAlertMessages().getText().equals("Incorrect username or password."),
				"Alert Messages is not appears correctly");
	}
	
	@Test(priority = 5, enabled = true, description = "Verify successful login to the Etana Digital Application with Valid Crendentials")
	public void verifyInvestorLoginWithvalidCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getetanaTrustTextElement().getText().equals("ETANATRUST"), "Etanatrust label text does not match exactly.");
		Assert.assertTrue(homePage.getdashboardTextElement().getText().equals("DASHBOARD"), "Dashboard label text does not match exactly.");
		Assert.assertTrue(homePage.getinvestorTextElement().getText().equals("INVESTOR"), "Investor label text does not match exactly.");
	}
	
	

}
