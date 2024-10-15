package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.ConfigReader;

public class WithdrawalPage extends BasePage {

	public WithdrawalPage(WebDriver driver) {
		super(driver);
	}

	private String ValidSearchText = ConfigReader.getPropertyFromKey("ValidTransactionId");
	private String InvalidSearchText = ConfigReader.getPropertyFromKey("InvalidSearchText");

	// Locators

	By mouseOverIconLocator = By.xpath("//div[@class='flex space-x-2']//*[name()='svg' and @data-slot='icon']");
	By mouseOverTextLocator = By
			.xpath("// div[text()='Downloading this type of document in CSV format may result in data loss']");
	By transactionid = By.xpath("//div[text()='Transaction ID']");
	By searchByClick = By.xpath("//input[@id='react-select-2-input']");
	By searchFieldLocator = By.xpath("//input[@placeholder='Transaction ID']");
	By notransactionsTextLocator = By.xpath("//div[text()='No transactions']");
	By validTransactionTextLocator = By.xpath("//mark[text()='d91ac558-6c2f-47c7-9733-b105b540b34e']");
	By filterButtonLocator = By.xpath("//span[text()='Filter']");
	By assertOptions = By.xpath("//div[@class='grid grid-cols-2']//label");
	By dateSeenOptions = By.xpath("//div[contains(@class,'flex flex-wrap')]//label");
	By approvalStatusOptions = By.xpath("//div[contains(@class,'flex justify-between')]//label");
	By firstrowLocators = By.xpath("//tbody[@class='w-full']//tr[1]");
	By withdrawalDetailsCancelLocators = By.xpath("//div[@class='flex justify-between']");
	By approvedLocator = By.xpath("(//input[contains(@class,'w-full rounded')])[1]");
	By pendingLocator = By.xpath("(//input[contains(@class,'w-full rounded')])[2]");
	By rejectedLocator = By.xpath("(//input[contains(@class,'w-full rounded')])[3]");
	By transactionIDToastLocator = By.xpath("//div[text()='Transaction ID copied to clipboard.']");
	By walletIDToastLocator = By.xpath("//div[text()='Wallet ID copied to clipboard.']");
	By withdrawalFromToastLocator = By.xpath("//div[text()='Origin address copied to clipboard.']");
	By withdrawalToToastLocator = By.xpath("//div[text()='Destination address copied to clipboard.']");
	By withdrawalTransactionID = By.xpath("//td[contains(text(), 'Transaction ID:')]/following-sibling::td/span[2]");
	By withdrawalWalletID = By.xpath("//td[contains(text(), 'Wallet ID:')]/following-sibling::td/span[2]");
	By withdrawalFrom = By.xpath("//td[contains(text(), 'From:')]/following-sibling::td/span[2]");
	By withdrawalTo = By.xpath("//td[contains(text(), 'To:')]/following-sibling::td/span[2]");
	By approveButtonLocator = By.xpath("(//div[@class='flex justify-evenly']//div)[1]");
	By rejectButtonLocator = By.xpath("(//div[@class='flex justify-evenly']//div)[2]");
	
	
	//div[text()='Pending Approval']
	// Find Elements

	public WebElement getText(String filtername) {
		return locateElement(By.xpath("//div[text()='" + filtername + "']"), "getText");
	}
	
	public WebElement getName(String name) {
		return locateElement(By.xpath("//span[text()='" + name + "']"), "getElements");
	}

	public WebElement getInvalidSearchResultsText() {
		return locateElement(notransactionsTextLocator, "getInValidSearchTextLocator");
	}

	public WebElement getvalidTransactionResultsText() {
		return locateElement(validTransactionTextLocator, "getvalidTransactionResultsText");
	}

	public WebElement getFilterButtonText() {
		return locateElement(filterButtonLocator, "getFilterButtonText");
	}
	
	public WebElement getApproveButtonText() {
		return locateElement(approveButtonLocator, "getApproveButtonText");
	}
	
	public WebElement getRejectButtonText() {
		return locateElement(rejectButtonLocator, "getRejectButtonText");
	}
	
	
	public WebElement gettransactionIDToastLocator() {
		return driver.findElement(transactionIDToastLocator);
	}
	
	public WebElement getWalletIDToastLocator() {
		return driver.findElement(walletIDToastLocator);
	}
	
	public WebElement getWithrawalfromToastLocator() {
		return driver.findElement(withdrawalFromToastLocator);
	}
	
	public WebElement getWithrawaltoToastLocator() {
		return driver.findElement(withdrawalToToastLocator);
	}
	
	// List Find Elements:

	public List<WebElement> getAssertOptions() {
		return driver.findElements(assertOptions);
	}

	public List<WebElement> getDateSeenOptions() {
		return driver.findElements(dateSeenOptions);
	}

	public List<WebElement> getApprovalStatusOptions() {
		return driver.findElements(approvalStatusOptions);
	}

	// send actions

	public WithdrawalPage enterInvalidTransactionID() {
		sendKeysElement(searchFieldLocator, InvalidSearchText, "enterInvalidTransactionID");
		return this;
	}

	public WithdrawalPage entervalidTransactionID() {
		sendKeysElement(searchFieldLocator, ValidSearchText, "entervalidTransactionID");
		return this;
	}

	public WebElement testIconHoverText() {
		WebElement svgElement = locateElement(mouseOverIconLocator, "mouseOverIconLocator");
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();
		WebElement hoverTextElement = locateElement(mouseOverTextLocator, "mouseOverTextLocator");
		return hoverTextElement;
	}

	// Click Actions
	
	public WithdrawalPage clickfirstrowinList() {
		clickElement(firstrowLocators, "clickfirstrowinList");
		return this;
	}

	public WithdrawalPage clickFilter(String filtername) {
		SmartWait(3);
		clickElement(By.xpath("//div[text()='" + filtername + "']"), "getFilter");
		return this;
	}
	
	public WithdrawalPage clickAssertOptions() {
		List<WebElement> elements = getAssertOptions();
		for (WebElement element : elements) {
			element.click(); 
		}
		return this;
	}

	public WithdrawalPage clickApprovalStatusOptions() {
		List<WebElement> elements = getDateSeenOptions();
		for (int i=0; i<3; i++) {
			elements.get(i).click(); 
		}
		return this;
	}


	public WithdrawalPage clickAllApprovalStatus() {
		List<WebElement> elements = getApprovalStatusOptions();
		for (WebElement element : elements) {
			element.click();
		}
		return this;
	}

	public WithdrawalPage clickFilterButton() {
		clickElement(filterButtonLocator, "clickFilterButton");
		return this;
	}
	
	public WithdrawalPage clickWithdrawalDetailsCancel() {
		clickElement(withdrawalDetailsCancelLocators, "clickCancelIcon");
		return this;
	}
	

	public void SearchByHoverClick() {
		clickElement(searchByClick, "searchByClick");
		Actions action = new Actions(driver);
		WebElement transactionidOptions = locateElement(transactionid, "transactionid");
		action.moveToElement(transactionidOptions).click().perform();
	}
	
	public WithdrawalPage clickPendingApprovalStatus() {
		clickElement(pendingLocator, "click_Pending");
		return this;
	}
	
	public WithdrawalPage clickwithdrawalTransactionID() {
		clickElement(withdrawalTransactionID, "click_TransactionID");
		return this;
	}
	
	public WithdrawalPage clickwithdrawalWalletID() {
		clickElement(withdrawalWalletID, "click_WalletID");
		return this;
	}
	
	public WithdrawalPage clickwithdrawalfrom() {
		clickElement(withdrawalFrom, "click_withdrawalfrom");
		return this;
	}
	
	public WithdrawalPage clickwithdrawalto() {
		clickElement(withdrawalTo, "click_withdrawalto");
		return this;
	}
	


	// Method to verify that a specific option exists within a filter
	public boolean isOptionPresent(List<WebElement> options, String expectedOption) {
		for (WebElement option : options) {
			if (option.getText().equals(expectedOption) && option.isDisplayed()) {
				return true;
			}
		}
		return false;
	}
	
	public void clickallFilterOptions() {
		SmartWait(3);
		clickAssertOptions();
		clickApprovalStatusOptions();
		clickAllApprovalStatus();
	}
	

}
