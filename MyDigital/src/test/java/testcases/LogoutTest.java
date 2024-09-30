package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SideMenu;
import utilities.ConfigReader;

public class LogoutTest extends BaseTest {


	private LoginPage loginPage;
	private SideMenu sideMenu;
	private LogoutPage logoutPage;
	private HomePage homepage;
	private String expectedUrl = ConfigReader.getPropertyFromKey("homeurl");
	
	@Test(priority = 1, enabled = true, description = "Verify Logout Button Functionality")
	private void verifyInvestorLogoutAction() {
		printMethodName();
		loginPage = new LoginPage(driver);
		loginPage.LoginInvestor();
		sideMenu = new SideMenu(driver);
		sideMenu.menuName("Logout");
		logoutPage = new LogoutPage(driver);
		Assert.assertTrue(logoutPage.getlogoutPromptQuestionElement().getText().equals("Are you sure you want to logout?"), "Prompt_Confirmationtext is not displayed.");
		Assert.assertTrue(logoutPage.getLogoutButtonElement().getText().equals("Logout"), "Logout Button is not displayed.");
		Assert.assertTrue(logoutPage.getgoHomeButtonElement().getText().equals("Go Home"), "GoHome Button is not displayed.");
		logoutPage.clickLogoutButton();
		System.out.println("Dfdsfdsfdfdfdf" + loginPage.getLoginButton().getText());
		Assert.assertTrue(loginPage.getLoginButton().getText().equals("Login"), "Login label text does not match exactly.");
		
	}


	@Test(priority = 2, enabled = true, description = "Verify GoHome Button Functionality")
	private void verifyInvestorGoHomeAction() {
		printMethodName();
		loginPage = new LoginPage(driver);
		loginPage.LoginInvestor();
		sideMenu = new SideMenu(driver);
		sideMenu.menuName("Logout");
		logoutPage = new LogoutPage(driver);
		Assert.assertTrue(logoutPage.getlogoutPromptQuestionElement().getText().equals("Are you sure you want to logout?"), "Prompt_Confirmationtext is not displayed.");
		Assert.assertTrue(logoutPage.getLogoutButtonElement().getText().equals("Logout"), "Logout Button is not displayed.");
		Assert.assertTrue(logoutPage.getgoHomeButtonElement().getText().equals("Go Home"), "GoHome Button is not displayed.");
		logoutPage.clickgoHomeButton();
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.getinvestorTextElement().getText().equals("INVESTOR"), "Investor label text does not match exactly.");
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The current URL does not match the expected URL.");
	}

	
	
	
	
	

	

//	@Test(priority = 3, enabled = true)
//	private void verifyGoHomeButtonAdminFunctionality() {
//		printMethodName();
//		loginPage = new LoginPage(driver);
//		loginPage.LoginAdmin();
//		sideMenu = new SideMenu(driver);
//		sideMenu.menuName("Logout");
//		logoutPage = new LogoutPage(driver);
//		logoutPage.clickgoHomeButton();
//		homepage = new HomePage(driver);
//		Assert.assertTrue(homepage.getAdminTextElement().getText().equals("ADMIN"), "Admin label text does not match exactly.");
//		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The current URL does not match the expected URL.");
//	}
//	

	

	
}
