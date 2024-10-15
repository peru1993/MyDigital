package pages;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DepositsPage extends BasePage {

	public DepositsPage(WebDriver driver) {
		super(driver);
	}

	By mouseOverIconLocator = By.xpath("//div[@class='flex space-x-2']//*[name()='svg' and @data-slot='icon']");
	By mouseOverTextLocator = By
			.xpath("// div[text()='Downloading this type of document in CSV format may result in data loss']");
	By firstrowLocators = By.xpath("//tbody[@class='w-full']//tr[1]");
	
	By depositWalletID = By.xpath("(//span[@class='text-gray-400 ml-2']//span)[1]");
	By depositHashID = By.xpath("(//span[@class='text-gray-400 ml-2']//span)[2]");
	
	By walletIDToastLocator = By.xpath("//div[text()='Wallet ID copied to clipboard.']");
	By hashIDToastLocator = By.xpath("//div[text()='Transaction Hash copied to clipboard.']");
	By dateSeenElement = By.xpath("(//td[@class='pl-4'])[2]");
	
	// Find Elements
	
	
	public WebElement getText(String filtername) {
		return locateElement(By.xpath("//td[text()='" + filtername + "']"), "getText");
	}
	
	public WebElement getName(String name) {
		return locateElement(By.xpath("//span[text()='" + name + "']"), "getElements");
	}
	
	public WebElement testIconHoverText() {
		WebElement svgElement = locateElement(mouseOverIconLocator, "mouseOverIconLocator");
		Actions action = new Actions(driver);
		action.moveToElement(svgElement).perform();
		WebElement hoverTextElement = locateElement(mouseOverTextLocator, "mouseOverTextLocator");
		return hoverTextElement;
	}
	
	public WebElement getWalletIDToastLocator() {
		return driver.findElement(walletIDToastLocator);
	}
	
	public WebElement getHashIDToastLocator() {
		return driver.findElement(hashIDToastLocator);
	}
	

	
	public WebElement getDateSeenLocator() {
		return locateElement(dateSeenElement, "getDate");
	}

	// Click Actions

	public DepositsPage clickfirstrowinList() {
		clickElement(firstrowLocators, "clickfirstrowinList");
		return this;
	}
	
	public DepositsPage clickDepositsWalletID() {
		clickElement(depositWalletID, "click_DepositsWalletID");
		return this;
	}
	
	public DepositsPage clickDepositsHashID() {
		clickElement(depositHashID, "click_DepositHashID");
		return this;
	}
	
	 public boolean verifyDateSeenFormat() {
	        String dateSeenText = getDateSeenLocator().getText();
	        String regexPattern = "(\\d{1,2})/(\\d{1,2})/(\\d{4}), (\\d{1,2}):(\\d{2}):(\\d{2}) (AM|PM)";
	        boolean isMatch = Pattern.matches(regexPattern, dateSeenText);
	        return isMatch;
	    }

}
