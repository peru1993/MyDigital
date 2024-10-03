package testcases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SideMenu;
import utilities.ConfigReader;

public class HomeTest extends BaseTest {

	private String expectedUrl = ConfigReader.getPropertyFromKey("homeurl");
	String[] expectedOrder = { "Home", "Withdrawals", "Deposits", "Wallets", "Organization", "Account", "Logout" };

	LoginPage loginpage;
	SideMenu sidemenu;
	HomePage homepage;

	@Test(priority = 1, enabled = true, description = "Verify that the Home page is displayed correctly after logging in and navigating through the side menu.")
	public void verifyHomePageNavigation() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver).menuName("Logout").menuName("Home");
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.getetanaTrustTextElement().getText().equals("ETANATRUST"),
				"Etanatrust label text does not match exactly.");
		Assert.assertTrue(homepage.getdashboardTextElement().getText().equals("DASHBOARD"),
				"Dashboard label text does not match exactly.");
		Assert.assertTrue(homepage.getinvestorTextElement().getText().equals("INVESTOR"),
				"Investor label text does not match exactly.");
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "The current URL does not match the expected URL.");
	}

	@Test(priority = 2, enabled = true, description = "Verify that the side menu options are visible and displayed in the correct order along with the Etana Digital logo.")
	public void verifySideMenuAndLogo() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		Assert.assertTrue(sidemenu.getEtanaLogo().isDisplayed(), "Etana Digital logo is not displayed!");
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verifySideMenuOrder(expectedOrder),
				"Side menu options are not in the correct order!");
	}

	@Test(priority = 3, enabled = true, description = "Verify that the hamburger menu is functional and consistently shows or hides the side panel.")
	public void verifySideMenuShoworHide() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver).clicksideMenuIcon(6);
	}

	@Test(priority = 4, enabled = true, description = "Verify that the user name, currency type, and currency values are displayed correctly on the home screen.")
	public void verifyUserNameCurrencyTypeAndValue() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		homepage = new HomePage(driver);
		homepage.assertcurrentytype().assertCurrencyvalue();
	}

	@Test(priority = 5, enabled = true, description = "Verify that user click on the Notification icon and see the Notifications displayed.")
	public void verifyNotificationiconanddisplay() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		homepage = new HomePage(driver);
		homepage.clickNotificationElement();
		String dateTimeText = homepage.getdateTimeValue();
		String regex = "\\d{1,2}/\\d{1,2}/\\d{4}, \\d{1,2}:\\d{2}:\\d{2} [APM]{2}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(dateTimeText);
		Assert.assertTrue(matcher.matches(), "The date and time format is incorrect. Actual: " + dateTimeText);
		String depositMessage  = homepage.getNotificationValue();
		String depositRegex  = "New deposit \\(\\d+\\.\\d+ ETH\\) successful";
		Pattern depositPattern  = Pattern.compile(depositRegex);
		Matcher depositMatcher   = depositPattern.matcher(depositMessage);
		Assert.assertTrue(depositMatcher.matches(), "The deposit message format is incorrect. Actual: " + depositMessage);
	}
}
