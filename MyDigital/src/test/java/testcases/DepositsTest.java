package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DepositsPage;
import pages.LoginPage;
import pages.SideMenu;

public class DepositsTest extends BaseTest {
	LoginPage loginpage;
	SideMenu sidemenu;
	DepositsPage depositspage;

	@Test(priority = 1, enabled = true, description = "Navigate to Deposits Menu from Side Menu")
	public void verifynavigatetodepositsMenu() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Deposits");
		Assert.assertTrue(sidemenu.getmenuName("Deposits").getText().equals("Deposits"),
				"Deposits Text does not match exactly.");
	}

	@Test(priority = 2, enabled = true, description = "Verify 'i' Icon Visibility and Tooltip on Hover")
	public void verifyiiconvisibility() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Deposits");
		depositspage = new DepositsPage(driver);
		Assert.assertTrue(depositspage.testIconHoverText().getText().equals("Downloading this type of document in CSV format may result in data loss"), "Hover text does not match the expected value.");
	}
	
	@Test(priority = 8, enabled = true, description = "Verify Table Header on the Deposits Page")
	public void verifyTableHeader() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Deposits");
		depositspage = new DepositsPage(driver);
		Assert.assertTrue(depositspage.getName("Wallet ID").getText().equals("Wallet ID"), "Wallet ID text is not displaying correctly");
		Assert.assertTrue(depositspage.getName("Amount").getText().equals("Amount"), "Amount text is not displaying correctly");
		Assert.assertTrue(depositspage.getName("Date Seen").getText().equals("Date Seen"), "Date Seen text is not displaying correctly");
		Assert.assertTrue(depositspage.getName("Origin").getText().equals("Origin"), "Origin text is not displaying correctly");
	}
	
	
	@Test(priority = 9, enabled = true, description = "Verify Date and Time Format on the Deposits Page")
	public void verifyDateTimeFormat() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Deposits");
		depositspage = new DepositsPage(driver);
		Assert.assertTrue(depositspage.verifyDateSeenFormat(), "The 'Date Seen' format is incorrect. Expected format: DD/MM/YYYY, HH:MM:SS");
	}
	
	
	
	@Test(priority = 11, enabled = true, description = "Verify Deposit Details Displayed on Row Click")
	public void verifyDepositDetails() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Deposits");
		depositspage = new DepositsPage(driver).clickfirstrowinList();
		Assert.assertTrue(depositspage.getText("Wallet ID").getText().equals("Wallet ID"), "Wallet ID text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Owner").getText().equals("Owner"), "Owner text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Transaction Hash").getText().equals("Transaction Hash"), "Transaction Hash text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Amount").getText().equals("Amount"), "Amount text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Amount (base units)").getText().equals("Amount (base units)"), "Amount (base units) text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Asset (base units)").getText().equals("Asset (base units)"), "Asset (base units) text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Date Seen").getText().equals("Date Seen"), "Date Seen text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Block Number").getText().equals("Block Number"), "Block Number text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Origin").getText().equals("Origin"), "Origin text is not displaying correctly");
		Assert.assertTrue(depositspage.getText("Destination").getText().equals("Destination"), "Destination text is not displaying correctly");
	}
	
	
	@Test(priority = 12, enabled = true, description = "Verify Deposit Details and Copy to Clipboard Functionality")
	public void verifyCopytoClipboardFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.LoginInvestor();
		sidemenu = new SideMenu(driver);
		sidemenu.menuName("Deposits");
		depositspage = new DepositsPage(driver).clickfirstrowinList();
		Assert.assertTrue(depositspage.getName("Deposit Details").getText().equals("Deposit Details"), "Deposit Details text is not displaying correctly");
		depositspage.clickDepositsWalletID();
		Assert.assertTrue(depositspage.getWalletIDToastLocator().getText().equals("Wallet ID copied to clipboard."), "Hover text does not match the expected value.");
		depositspage.clickDepositsHashID();
		Assert.assertTrue(depositspage.getHashIDToastLocator().getText().equals("Transaction Hash copied to clipboard."), "Hover text does not match the expected value.");
	}

}
