package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.OrganizationPage;
import pages.SideMenu;
import utilities.ConfigReader;

public class OrganizationTest extends BaseTest {

	private String ValidSearchText = ConfigReader.getPropertyFromKey("ValidSearchText");
	private String InvalidSearchText = ConfigReader.getPropertyFromKey("InvalidSearchText");

	LoginPage loginpage;
	SideMenu sidemenu;
	OrganizationPage organizationpage;

	@Test(priority = 1, enabled = true, description = "Verify that the user can navigate to the Organization menu from the side menu.")
	public void verifyUserCanNavigateToOrganizationMenu() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		Assert.assertTrue(sidemenu.getmenuName("Organization").getText().equals("Organization"),
				"Organization Text does not match exactly.");
	}

	@Test(priority = 2, enabled = true, description = "Verify that the Organization User Page displays both Admin and Investor users correctly.")
	public void verifyUserCanAdminandInvestorUsers() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.clickdownArrowButton();
		Assert.assertTrue(sidemenu.getmenuName("Admins").getText().equals("Admins"),
				"Admins Text does not match exactly.");
		Assert.assertTrue(sidemenu.getmenuName("Investors").getText().equals("Investors"),
				"Investors Text does not match exactly.");
	}

	@Test(priority = 3, enabled = true, description = "Verify that the search results display the correct users based on the email address entered.")
	private void verifySearchWithValidInput() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.enterSearch(ValidSearchText);
		Assert.assertTrue(organizationpage.getValidSearchResultsText().getText().contains(ValidSearchText),
				"Search results do not contain the expected valid input: " + ValidSearchText);
	}

	@Test(priority = 4, enabled = true, description = "Verify that when an unregistered email address is searched, appropriate messages are displayed.")
	private void verifySearchWithInValidInput() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.enterSearch(InvalidSearchText);
		Assert.assertTrue(organizationpage.getName("admins").getText().equals("No admins"),
				"No Admin text does not match exactly");
		Assert.assertTrue(organizationpage.getName("investors").getText().equals("No investors"),
				"No Investors text does not match exactly");
	}

	@Test(priority = 5, enabled = true, description = "Verify that the non admin user cannot see the \"Invite New User\" button on the Organization User page.")
	private void verifyInviteNewUserButton() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.getAdminInviteNewUser();
	}

	@Test(priority = 6, enabled = true, description = "Verify that Investor users can access the Organization User Page, but the Edit icon is not displayed.")
	private void verifyEditIconVisibility() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.geteditIconLocator();
	}

	@Test(priority = 7, enabled = true, description = "Verify that Investor users can access the Organization User Page, but the Delete icon is not displayed.")
	private void verifyDeleteIconVisibility() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.getDeleteIconLocator();
	}

	@Test(priority = 8, enabled = true, description = "Verify that the pagination functionality works correctly, including behavior of the Next and Previous icons.")
	private void verifyPaginationFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Organization");
		organizationpage = new OrganizationPage(driver);
		organizationpage.investorArrowclick();
		Assert.assertTrue(organizationpage.getTableRowCount() <= 10, "Table contains more than 10 rows!");
		organizationpage.investorArrowclick().adminArrowclick();
		Assert.assertTrue(organizationpage.getTableRowCount() <= 10, "Table contains more than 10 rows!");
		organizationpage.adminArrowclick().adminNextIconclick().investorNextIconclick();
		organizationpage.adminPreviousIconclick().investorPreviousIconclick();
	}

}
