package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends BasePage {

	public SideMenu(WebDriver driver) {
		super(driver);
	}

	// Locators
	By sideMenuOpenLocator = By.xpath("//div[contains(@class,'rounded-full bg-white')]");
	By etanaLogo = By.xpath("//img[contains(@class,'translate-x-0 delay-75')]");

	// Locator Element Action

	public WebElement getEtanaLogo() {
		return locateElement(etanaLogo, "LocateEtanaLogo");
	}

	public WebElement getmenuName(String MenuName) {
		return locateElement(By.xpath("//span[text()='" + MenuName + "']"), "getmenuName");
	}

	// click Action

	public SideMenu clicksideMenuIcon(int numberOfClicks) {
		for (int i = 0; i < numberOfClicks; i++) {
			clickElement(sideMenuOpenLocator, "sidemenuIcon_click");
		}
		return this;
	}

	public SideMenu menuName(String MenuName) {
		clickElement(By.xpath("//span[text()='" + MenuName + "']"), "sidemenu_click");
		return this;
	}

}
