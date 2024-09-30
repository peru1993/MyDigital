package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//By Locators
	
	By adminTextLocator = By.xpath("//div[normalize-space(text())='ADMIN']");
	By investorTextLocator = By.xpath("//div[normalize-space(text())='INVESTOR']");
	By etanatrustTextLocator = By.xpath("//h1[normalize-space(text())='ETANATRUST']");
	By dashboardTextLocator = By.xpath("//span[normalize-space(text())='DASHBOARD']");
	
	//Find Locators Elements

	public WebElement getAdminTextElement() {
		return driver.findElement(adminTextLocator);
	}
	
	public WebElement getinvestorTextElement() {
		return driver.findElement(investorTextLocator);
	}
	
	public WebElement getetanaTrustTextElement() {
		return driver.findElement(etanatrustTextLocator);
	}
	
	public WebElement getdashboardTextElement() {
		return driver.findElement(dashboardTextLocator);
	}
	

}
