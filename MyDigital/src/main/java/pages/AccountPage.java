package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilities.ConfigReader;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	private String changewebhookurl = ConfigReader.getPropertyFromKey("changewebhookurl");

	// By Locators:

	By myAccountTextLocator = By.xpath("//h1[text()='My Account']");
	By editInfoButtonLocator = By.xpath("//button[contains(.,'Edit Info')]");
	By webhookURLiconLocator = By.xpath("(//span[text()='Webhook URL']/following-sibling::div)[1]");
	By webhookURLiconTextLocator = By.xpath(
			"//div[text()='Notifications about transactions can be sent as HTTP requests to a given URL.']");
	By webhookKeyiconLocator = By.xpath("(//span[text()='Webhook Key']/following-sibling::div)[1]");
	By webhookKeyiconTextLocator = By.xpath("//div[text()='Use this 32-byte key to decode webhooks with AES.']");
	By apiKeyiconLocator = By.xpath("(//span[text()='API Key']/following-sibling::div)[1]");
	By apiKeyiconTextLocator = By.xpath(
			"//span[(text())='To use the Etana Digital API, include this key as a header in each HTTP request:']");
	By webhooKeyShowHideLocator = By.xpath("(//span[@class='flex space-x-1']//div)[2]");
	By webhooKeyFieldValue = By.xpath("(//div[contains(@class,'flex text-xs')]//span)[1]");
	By webapiKeyFieldValue = By.xpath(
			"//span[normalize-space(text())='6c16f4e2b24b092db3ff7055792ee1a878e85c6c097f0a0abb8e657c0a0ae18f']");
	By apiKeyShowHideLocator = By.xpath("(//div[contains(@class,'text-gray-400 hover:text-blue-300')])[2]");
	By WebhookKeycopyLocator = By.xpath("(//span[@class='flex space-x-1']//span)[2]");
	By webhookKeyToastLocator = By.xpath("//div[@role='status' and contains(text(), 'Webhook key copied')]");
	By saveChangesButtonLocator = By.xpath("//button[contains(.,'Save Changes')]");
	By cancelButtonLocator = By.xpath("//button[contains(.,'Cancel')]");
	By webhookURLFieldLocator = By.xpath("//input[@placeholder='Enter your webhook URL']");
	By webhookURLEditLocator = By.xpath("//div[@class='text-gray-300']/following-sibling::div[1]");
	By FirstNameLocator = By.xpath("//div[text()='First Name']/following-sibling::div");
	By LastNameLocator = By.xpath("//div[text()='Last Name']/following-sibling::div");

	// Action code:

	// Find Elements Code:

	public WebElement getMyAccountTextElement() {
		return locateElement(myAccountTextLocator, "getAccountTextLocator");
	}

	public WebElement getAccountdetails(String getName) {
		return locateElement(By.xpath("//div[text()='" + getName + "']"), "getAccountDetails");
	}

	public WebElement getAccountdetail(String getName) {
		return locateElement(By.xpath("//span[text()='" + getName + "']"), "getAccountDetails");
	}

	public WebElement getWebhookKeyapiFieldValues() {
		return locateElement(webhooKeyFieldValue, "getwebhookkeyapi_values");
	}

	public WebElement getApiKeyapiFieldValues() {
		return locateElement(webapiKeyFieldValue, "getAPIKey_values");
	}

	public WebElement getWebhookKeyToastValues() {
		return driver.findElement(webhookKeyToastLocator);
	}

	public WebElement getSaveChangesButtonValues() {
		return locateElement(saveChangesButtonLocator, "SaveChanges_values");
	}

	public WebElement getCancelButtonValues() {
		return locateElement(cancelButtonLocator, "CancelButton_values");
	}

//	public WebElement getFirstNameFieldValues() {
//		return locateElement(FirstNameLocator, "FirstName_values");
//	}
//	
//	public WebElement getLastnameFieldValues() {
//		return locateElement(LastNameLocator, "LastName_values");
//	}
//	

	public void getEditInfoButtonElement() {
		WebElement editInfoLabel = driver.findElement(editInfoButtonLocator);
		String actualText = editInfoLabel.getText();
		Assert.assertTrue(actualText.equals("Edit Info"), "Edit Info label text does not match exactly.");
	}

	public WebElement getWebhookURLFieldValueElement() {
		return locateElement(webhookURLFieldLocator, "WebhookURL_locate");
	}

	// click action code

	public AccountPage webhookKeyclick() {
		clickElement(webhooKeyShowHideLocator, "ShowHide_click");
		return this;
	}

	public AccountPage apiKeyclick() {
		clickElement(apiKeyShowHideLocator, "apikey_click");
		return this;
	}

	public AccountPage clickEditInfoButton() {
		clickElement(editInfoButtonLocator, "EditInfoButton_click");
		return this;
	}

	public AccountPage clickSaveChangesButton() {
		clickElement(saveChangesButtonLocator, "SaveChangesButton_click");
		return this;
	}

	public AccountPage clickWebhookKeyCopyButton() {
		clickElement(WebhookKeycopyLocator, "WebhookKeyCopyButton_click");
		return this;
	}

	public AccountPage enterWebhookURL() {
		textfieldclear(webhookURLFieldLocator, "webhookURLClear");
		sendKeysElement(webhookURLFieldLocator, changewebhookurl, "WebhookURL");
		return this;
	}

	public AccountPage clickCancelButton() {
		clickElement(cancelButtonLocator, "CancelButton_click");
//		driver.navigate().refresh();
		return this;
	}

	// hover code for webhook URL and Key

	public WebElement testWebHookURLIconHoverText() {
		WebElement svgElement = locateElement(webhookURLiconLocator, "ElementLocate");
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();
		WebElement hoverTextElement = locateElement(webhookURLiconTextLocator, "ElementLocate");
		return hoverTextElement;
	}

	public WebElement testWebHookKeyIconHoverText() {
		WebElement svgElement = locateElement(webhookKeyiconLocator, "ElementLocate");
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();
		WebElement hoverTextElement1 = locateElement(webhookKeyiconTextLocator, "ElementLocate");
		return hoverTextElement1;
	}

	public WebElement testWebAPIKeyIconHoverText() {
		WebElement svgElement = locateElement(apiKeyiconLocator, "ElementLocate");
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();
		WebElement hoverTextElement1 = locateElement(apiKeyiconTextLocator, "ElementLocate");
		return hoverTextElement1;
	}

	public String verifyEmailFieldValue() {
		String actualEmailValue = locateElement(webhookURLFieldLocator, "WebhookURL_locate").getAttribute("value");
		return actualEmailValue;
	}

}
