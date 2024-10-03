package pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// By Locators
	By adminTextLocator = By.xpath("//div[text()='ADMIN']");
	By investorTextLocator = By.xpath("//div[text()='INVESTOR']");
	By etanatrustTextLocator = By.xpath("//h1[text()='ETANATRUST']");
	By dashboardTextLocator = By.xpath("//span[text()='DASHBOARD']");
	By sideMenuOptions = By.xpath("//span[contains(@class,'ml-5 transition-all')]");
	By userNameLocator = By.xpath("//div[text()='Gobinath Test']");
	By currentyLocator = By.xpath("//span[contains(@class,'text-gray-300 text-left')]/following-sibling::span");
	By datetimeLocator = By.xpath("(//p[@class='text-xs text-gray-400'])[1]");
	By notificationLocator = By.xpath("//div[@class='hover:text-teal-400 text-right']//div[1]");
	By notificationstatus = By.xpath("//p[contains(text(), 'ETH')]");

	// Find Locators Elements

	public WebElement getCurrentyType(String MenuName) {
		return locateElement(By.xpath("//span[contains(.,'" + MenuName + ":')]"), "CurrentyTypeLocator");
	}

	public WebElement getAdminTextElement() {
		return locateElement(adminTextLocator, "adminText");
	}

	public WebElement getinvestorTextElement() {
		return locateElement(investorTextLocator, "InvestorText");
	}

	public WebElement getetanaTrustTextElement() {
		return locateElement(etanatrustTextLocator, "getetanaTrustText");
	}

	public WebElement getdashboardTextElement() {
		return locateElement(dashboardTextLocator, "dashboardText");
	}

	public List<WebElement> getSideMenuOptions() {
		return driver.findElements(sideMenuOptions);
	}

	public WebElement getUsernameTextElement() {
		return locateElement(userNameLocator, "UsernameText");
	}

	// clickElements

	public HomePage clickNotificationElement() {
		clickElement(notificationLocator, "click_Notification");
		return this;
	}


	public String getdateTimeValue() {
		WebElement datetimeElement = locateElement(datetimeLocator, "locate_datetime");
		return datetimeElement.getText();
	}
	
	public String getNotificationValue() {
		WebElement displayElement = locateElement(notificationstatus, "locate_Notification");
		return displayElement.getText();
	}
	

	public List<String> getCurrencyValue() {
		List<WebElement> spanElement = driver.findElements(currentyLocator);
		return spanElement.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public boolean verifySideMenuOrder(String[] expectedOrder) {
		List<WebElement> menuOptions = getSideMenuOptions();
		for (int i = 0; i < menuOptions.size(); i++) {
			if (!menuOptions.get(i).getText().equals(expectedOrder[i])) {
				return false; // If any option is out of order, return false
			}
		}
		return true; // If all options are in order, return true
	}

	public HomePage assertcurrentytype() {
		String[] currenciesType = { "AVAX", "BTC", "ETH", "POLYX", "XLM", "XRP" };
		for (String currency : currenciesType) {
			String expectedCurrencyType = currency + ":";
			Assert.assertTrue(getCurrentyType(currency).getText().equals(expectedCurrencyType),
					"Currency type does not match for " + currency);
		}
		return this;
	}

	public HomePage assertCurrencyvalue() {
		List<String> spanTexts = getCurrencyValue();
		System.out.println(spanTexts.size());
		String[] regexPatterns = { "\\d+\\.\\d+", "0\\.\\d+", "\\d+\\.\\d+", "\\d{5}\\.\\d+", "\\d{3}\\.\\d+", "\\d+" };
		for (int i = 0; i < spanTexts.size(); i++) {
			String spanText = spanTexts.get(i);
			String regex = regexPatterns[i];
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(spanText);
			Assert.assertTrue(matcher.matches(),
					"Span text \"" + spanText + "\" does not match the expected pattern: " + regex);
		}
		return this;
	}

}
