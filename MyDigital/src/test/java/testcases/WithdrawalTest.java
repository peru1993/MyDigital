package testcases;
import java.util.Arrays; 
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SideMenu;
import pages.WithdrawalPage;

public class WithdrawalTest extends BaseTest {
	LoginPage loginpage;
	SideMenu sidemenu;
	WithdrawalPage withdrawalpage;

	@Test(priority = 1, enabled = true, description = "Navigate to Withdrawals Menu from Side Menu.")
	public void verifynavigatetowithdrawalsMenu() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		Assert.assertTrue(sidemenu.getmenuName("Withdrawals").getText().equals("Withdrawals"),
				"Withdrawals Text does not match exactly.");
	}

	@Test(priority = 2, enabled = true, description = "Verify 'i' Icon Visibility and Tooltip on Hover")
	public void verifyiiconvisibility() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		Assert.assertTrue(
				withdrawalpage.testIconHoverText().getText()
						.equals("Downloading this type of document in CSV format may result in data loss"),
				"Hover text does not match the expected value.");
	}

	@Test(priority = 5, enabled = true, description = "Verify Search Functionality with Invalid Details")
	public void verifyInValidSearchFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		withdrawalpage.SearchByHoverClick();
		withdrawalpage.enterInvalidTransactionID();
		Assert.assertTrue(withdrawalpage.getInvalidSearchResultsText().getText().equals("No transactions"),
				"No Transactions text is not displaying correctly");
	}

	@Test(priority = 6, enabled = true, description = "Verify Search Functionality with Valid")
	public void verifyValidSearchFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		withdrawalpage.SearchByHoverClick();
		withdrawalpage.entervalidTransactionID();
		Assert.assertTrue(withdrawalpage.getvalidTransactionResultsText().getText()
				.equals("d91ac558-6c2f-47c7-9733-b105b540b34e"), "Transaction ID value is not displaying correctly");
	}

	@Test(priority = 7, enabled = true, description = "Verify Display of Filter Button")
	public void verifyVisibilityOfFilterButton() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		Assert.assertTrue(withdrawalpage.getFilterButtonText().getText().equals("Filter"),
				"Filter button text is not displaying correctly");
		withdrawalpage.clickFilterButton();
	}

	@Test(priority = 8, enabled = true, description = "Verify Filter Options Displayed as per Client Requirements")
	public void verifyFiltersAndOptions() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		withdrawalpage.clickFilterButton();
		Assert.assertTrue(withdrawalpage.getText("Assets").getText().equals("Assets"),
				"Assert filter is not displayed correctly");
		List<String> expectedAssertOptions = Arrays.asList("AVAX", "BTC", "ETH", "LINK", "USDC", "USDT", "MATIC",
				"POLYX", "XRP", "SOL", "XLM");
		for (String option : expectedAssertOptions) {
			System.out.println(option);
			Assert.assertTrue(withdrawalpage.isOptionPresent(withdrawalpage.getAssertOptions(), option),
					"Assert filter option " + option + " is not displayed");
		}
		Assert.assertTrue(withdrawalpage.getText("Date Seen").getText().equals("Date Seen"),
				"Date Seen filter is not displayed correctly");
		List<String> expectedDateSeenOptions = Arrays.asList("Last 24 hours", "Last 7 days", "Last 30 days",
				"All Time");
		for (String option : expectedDateSeenOptions) {
			System.out.println(option);
			Assert.assertTrue(withdrawalpage.isOptionPresent(withdrawalpage.getDateSeenOptions(), option),
					"Date Seen filter option " + option + " is not displayed");
		}
		Assert.assertTrue(withdrawalpage.getText("Approval Status").getText().equals("Approval Status"),
				"Approval Status is not displayed correctly");
		List<String> expectedApprovalStatusOptions = Arrays.asList("Approved", "Pending", "Rejected");
		for (String option : expectedApprovalStatusOptions) {
			System.out.println(option);
			Assert.assertTrue(withdrawalpage.isOptionPresent(withdrawalpage.getApprovalStatusOptions(), option),
					"Approval Status filter option " + option + " is not displayed");
		}
	}

	@Test(priority = 9, enabled = true, description = "Verify the State of the \"Clear All\" Button")
	public void verifyClearAllButtonState() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		withdrawalpage.clickFilterButton();
		Assert.assertTrue(withdrawalpage.getText("Clear Filters").getAttribute("class").contains("select-none"),
				"Clear All button should be enabled initially after click Filter Icon");
	}
	
	@Test(priority = 10, enabled = true, description = "Verify the Functionality of the \"Clear All\" Button")
	public void verifyClearAllButtonFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver);
		withdrawalpage.clickFilterButton();
		withdrawalpage.clickAllApprovalStatus();
		withdrawalpage.clickFilter("Clear Filters");
	}
	
	@Test(priority = 11, enabled = true, description = "Verify Checkbox Selection for Filter Options")
	public void verifyFilterCheckboxSelection() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver).clickFilterButton().clickAssertOptions().clickApprovalStatusOptions().clickAllApprovalStatus();
		withdrawalpage.clickallFilterOptions();
	}
	
	@Test(priority = 13, enabled = true, description = "Verify Transaction Details Display")
	public void verifyTransactionDetailsDisplay() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver).clickfirstrowinList();
		Assert.assertTrue(withdrawalpage.getName("Withdrawal Details").getText().equals("Withdrawal Details"), "Withdrawal Details text is not displaying correctly");
		withdrawalpage.clickWithdrawalDetailsCancel();
	}
	
	@Test(priority = 14, enabled = true, description = "Verify Transaction Details for Pending Transactions.")
	public void verifyPendingTransactionDetails() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver).clickFilterButton().clickPendingApprovalStatus().clickfirstrowinList();
		Assert.assertTrue(withdrawalpage.getName("Pending Approval").getText().equals("Pending Approval"), "Pending Approval Details text is not displaying correctly");
		withdrawalpage.clickwithdrawalTransactionID();
		Assert.assertTrue(withdrawalpage.gettransactionIDToastLocator().getText().equals("Transaction ID copied to clipboard."), "Hover text does not match the expected value.");
		withdrawalpage.clickwithdrawalWalletID();
		Assert.assertTrue(withdrawalpage.getWalletIDToastLocator().getText().equals("Wallet ID copied to clipboard."), "Hover text does not match the expected value.");
		withdrawalpage.clickwithdrawalfrom();
		Assert.assertTrue(withdrawalpage.getWithrawalfromToastLocator().getText().equals("Origin address copied to clipboard."), "Hover text does not match the expected value.");
		withdrawalpage.clickwithdrawalto();
		Assert.assertTrue(withdrawalpage.getWithrawaltoToastLocator().getText().equals("Destination address copied to clipboard."), "Hover text does not match the expected value.");
	}
	
	@Test(priority = 15, enabled = true, description = "Verify \"Approve\" and \"Reject\" Buttons for Manager Users")
	public void verifyApproveRejectButtonDisplay() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver).clickFilterButton().clickPendingApprovalStatus().clickfirstrowinList();
		Assert.assertTrue(withdrawalpage.getName("Pending Approval").getText().equals("Pending Approval"), "Pending Approval text is not displaying correctly");
		Assert.assertTrue(withdrawalpage.getApproveButtonText().getText().equals("Approve"), "Pending Button text is not displaying correctly");
		Assert.assertTrue(withdrawalpage.getRejectButtonText().getText().equals("Reject"), "Reject Button text is not displaying correctly");
	}
	
	@Test(priority = 22, enabled = true, description = "Verify User Can See the Close Icon in Transaction Details")
	public void verifySeeCloseIconinTransactionDetails() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Withdrawals");
		withdrawalpage = new WithdrawalPage(driver).clickFilterButton().clickPendingApprovalStatus().clickfirstrowinList().clickWithdrawalDetailsCancel();	
	}
	
}
