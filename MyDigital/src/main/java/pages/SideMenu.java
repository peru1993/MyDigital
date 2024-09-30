package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends BasePage {

	public SideMenu(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	By withdrawalTextLocator = By.xpath("//span[normalize-space(text())='Withdrawals']");
	By organisationTextLocator = By.xpath("//span[normalize-space(text())='Organization']");
	By accountTextLocator = By.xpath("//button[contains(.,'Account')]");
	By logoutTextLocator = By.xpath("//span[normalize-space(text())='Logout']");
	
	
	
	//TextSideMenuElement
	
	public WebElement getWithdrawalsLabelElement() {
		return driver.findElement(withdrawalTextLocator); 
	}
	
	public WebElement getOrganisationLabelElement() {
		return driver.findElement(organisationTextLocator); 
	}
	
	public WebElement getAccountLabelElement() {
		return driver.findElement(accountTextLocator); 
	}
	
	public WebElement getLogoutTextElement() {
		return driver.findElement(logoutTextLocator);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	}
	
	
	
	

	public SideMenu menuName(String MenuName) {
		clickElement(By.xpath("//span[text()='" + MenuName + "']"), "sidemenu_click");
		return this;
	}


}
