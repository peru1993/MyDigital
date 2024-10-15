package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.SideMenu;

public class AccountTest extends BaseTest {
	
	LoginPage loginpage;
	SideMenu sidemenu;
	AccountPage accountpage;

	@Test(priority = 1, enabled = true, description = "Verify that the user can navigate to the Accounts menu from the side menu.")
	public void verifyUserCanNavigateToAccountMenu() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.getMyAccountTextElement().getText().equals("My Account"),
				"My Account label text does not match exactly.");
	}

	@Test(priority = 2, enabled = true, description = "Verify that the Account details are visible in the My Account screen.")
	public void verifyAccountDetailsVisible() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.getAccountdetails("Sub").getText().equals("Sub"),
				"Sub text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetails("First Name").getText().equals("First Name"),
				"First Name text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetails("Last Name").getText().equals("Last Name"),
				"Last Name text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetails("Email").getText().equals("Email"),
				"Email text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetail("Webhook URL").getText().equals("Webhook URL"),
				"Webhook URL text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetail("Webhook Key").getText().equals("Webhook Key"),
				"Webhook Key text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetail("API Key").getText().equals("API Key"),
				"API Key text does not match exactly.");
	}

	@Test(priority = 3, enabled = true, description = "Verify that the 'i' icons provide the correct tooltips when hovered over.")
	public void verifyHoverIconsTooltips() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		Assert.assertTrue(
				accountpage.testWebHookURLIconHoverText().getText()
						.equals("Notifications about transactions can be sent as HTTP requests to a given URL."),
				"Hover text does not match the expected value.");
		Assert.assertTrue(
				accountpage.testWebAPIKeyIconHoverText().getText()
						.equals("To use the Etana Digital API, include this key as a header in each HTTP request:"),
				"Hover text does not match the expected value.");
		Assert.assertTrue(
				accountpage.testWebHookKeyIconHoverText().getText()
						.equals("Use this 32-byte key to decode webhooks with AES."),
				"Hover text does not match the expected value.");
	}

	@Test(priority = 4, enabled = true, description = "Verify that the Show and Hide buttons work correctly for the Webhook Key and API Key.")
	public void verifyShowHideButtonFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		accountpage.webhookKeyclick();
		Assert.assertTrue(
				accountpage.getWebhookKeyapiFieldValues().getText()
						.equals("cda5feb83a30084a3b84ea6ae5d97ee42386d354d173a940f79bc35f4b96937d"),
				"WebhookKey Values does not match the expected value.");
		accountpage.webhookKeyclick();
		Assert.assertTrue(accountpage.getWebhookKeyapiFieldValues().getText().equals("******************************"),
				"WebhookKey Values does not match the expected value.");
		accountpage.apiKeyclick();
		Assert.assertTrue(
				accountpage.getApiKeyapiFieldValues().getText()
						.equals("6c16f4e2b24b092db3ff7055792ee1a878e85c6c097f0a0abb8e657c0a0ae18f"),
				"APIKey Values does not match the expected value.");
		accountpage.apiKeyclick();
		Assert.assertTrue(accountpage.getWebhookKeyapiFieldValues().getText().equals("******************************"),
				"APIKey Values does not match the expected value.");
	}

	@Test(priority = 5, enabled = true, description = "Verify that the user can copy the Webhook Key and API Key successfully.")
	public void verifyToastCopyMessages() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		accountpage.clickWebhookKeyCopyButton();
		Assert.assertTrue(accountpage.getWebhookKeyToastValues().getText().equals("Webhook key copied to clipboard."),
				"Webhook Key Toast messages does not match exactly.");
	}

	@Test(priority = 6, enabled = true, description = "Verify that the user can edit the Webhook URL and that the appropriate buttons appear.")
	public void verifyWebhookUrlEditFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		accountpage.clickEditInfoButton();
		Assert.assertTrue(accountpage.getWebhookURLFieldValueElement().isEnabled(),
				"WebhookURL Field is not able to editable.");
		Assert.assertTrue(accountpage.getSaveChangesButtonValues().getText().equals("Save Changes"),
				"Save Changes Values does not match exactly.");
		Assert.assertTrue(accountpage.getCancelButtonValues().getText().equals("Cancel"),
				"Cancel Values does not match exactly.");
//		Assert.assertTrue(accountpage.getFirstNameFieldValues().isEnabled(), "FirstName Field Values is editable.");
//		Assert.assertTrue(accountpage.getLastnameFieldValues().isEnabled(), "LastName Field Values is editable.");
	}

	@Test(priority = 7, enabled = true, description = "Verify that the user can cancel edits to the Webhook URL and that the original details remain unchanged.")
	private void verifyCancelButtonFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		accountpage.clickEditInfoButton().enterWebhookURL().clickCancelButton().clickEditInfoButton();
		Assert.assertTrue(accountpage.verifyEmailFieldValue().equals("https://etanaDigital.com/"),
				"Email field value does not match the expected value.");
		accountpage.clickCancelButton();
	}

	@Test(priority = 8, enabled = true, description = "Verify that the user can save edits to the Webhook URL and that the changes are reflected.")
	private void verifySaveButtonFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		accountpage.clickEditInfoButton().enterWebhookURL().clickSaveChangesButton().clickEditInfoButton();
		Assert.assertTrue(accountpage.verifyEmailFieldValue().equals("https://etana.com/"),
				"Email field value does not match the expected value.");
	}

	@Test(priority = 9, enabled = true, description = "Verify that the \"Verified\" text is displayed next to the email ID for the new Investor user.")
	public void verifyVerifiedTextDisplayed() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Account");
		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.getAccountdetails("Email").getText().equals("Email"),
				"Email text does not match exactly.");
		Assert.assertTrue(accountpage.getAccountdetail("Verified").getText().equals("Verified"),
				"Verified text does not match exactly.");
	}

}
