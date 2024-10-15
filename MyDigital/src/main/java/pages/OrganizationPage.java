package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrganizationPage extends BasePage {

	public OrganizationPage(WebDriver driver) {
		super(driver);
	}

	// Locators:

	By adminInvestorarrowLocator = By.xpath("(//span[@class='pr-2'])");
	By organisationTextLocator = By.xpath("//span[text()='Organization']");
	By OrganisationSearchLocator = By.xpath("//input[@placeholder='Search users']");
	By validSearchLocator = By.xpath("//mark[text()='gopinath.r+admin@etana.com']");
	By adminNewUserButtonLocator = By.xpath("//button[contains(.,'Invite New User')]");
	By adminPreviousIconLocator = By.xpath("(//span[contains(@class,'flex justify-between')]//div)[1]");
	By adminNextIconLocator = By.xpath("(//span[contains(@class,'flex justify-between')]//div)[2]");
	By investorPreviousIconLocator = By.xpath("(//span[contains(@class,'flex justify-between')]//div)[3]");
	By investorNextIconLocator = By.xpath("(//span[contains(@class,'flex justify-between')]//div)[4]");
	By getTableRowCountLocator = By.xpath("(//table[contains(@class,'w-full whitespace-nowrap')]//tbody//tr)");
	By adminsarrowLocator = By.xpath("(//span[@class='pr-2'])[1]");
	By investorarrowLocator = By.xpath("(//span[@class='pr-2'])[2]");
	By editIconLocator = By.xpath("(//tr[contains(@class,'border-y border-dotted')]//button)[1]");
	By DeleteIconLocator = By.xpath("(//tr[contains(@class,'border-y border-dotted')]//button)[3]");

	// Find Elements Code:

	public WebElement getValidSearchResultsText() {
		return locateElement(validSearchLocator, "getValidSearchTextLocator");
	}

	public WebElement getAdminInviteNewUser() {
		return locateElement(adminNewUserButtonLocator, "getAdminInviteNewUserTextLocator");
	}

	public WebElement getName(String MenuName) {
		return locateElement(By.xpath("//div[text()='" + MenuName + "']"), "Get_Name");
	}
	
	public WebElement geteditIconLocator() {
		return locateElement(editIconLocator, "geteditIconLocator");
	}

	public WebElement getDeleteIconLocator() {
		return locateElement(DeleteIconLocator, "getDeleteIconLocator");
	}

	

	// Click Action

	public OrganizationPage clickdownArrowButton() {
		List<WebElement> clickButtons = driver.findElements(adminInvestorarrowLocator);
		for (WebElement arrowbutton : clickButtons) {
			arrowbutton.click();
		}
		return this;
	}

	public int getTableRowCount() {
		List<WebElement> rows = driver.findElements(getTableRowCountLocator);
		return rows.size();
	}

	public OrganizationPage adminNextIconclick() {
		clickElement(adminNextIconLocator, "adminNextIconclick");
		return this;
	}

	public OrganizationPage investorNextIconclick() {
		clickElement(investorNextIconLocator, "investorNextIconclick");
		return this;
	}

	public OrganizationPage adminPreviousIconclick() {
		clickElement(adminPreviousIconLocator, "adminPreviousIconclick");
		return this;
	}

	public OrganizationPage investorPreviousIconclick() {
		clickElement(investorPreviousIconLocator, "investorPreviousIconclick");
		return this;
	}

	public OrganizationPage adminArrowclick() {
		clickElement(adminsarrowLocator, "adminArrowclick");
		return this;
	}

	public OrganizationPage investorArrowclick() {
		clickElement(investorarrowLocator, "investorArrowclick");
		return this;
	}

	// Search Action

	public OrganizationPage enterSearch(String Search) {
		sendKeysElement(OrganisationSearchLocator, Search, "get_Search");
		return this;
	}


}
