package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	By logoutQuestionLocator = By.xpath("//h1[normalize-space(text())='Are you sure you want to logout?']");
	By goHomeButtonLocator = By.xpath("//button[normalize-space(text())='Go Home']");
	By logoutButtonLocator = By.xpath("//button[normalize-space(text())='Logout']");

	
	//find element locators
	
	public WebElement getlogoutPromptQuestionElement() {
		return driver.findElement(logoutQuestionLocator);
	}
	
	public WebElement getLogoutButtonElement() {
		return driver.findElement(logoutButtonLocator);
	}

	public WebElement getgoHomeButtonElement() {
		return driver.findElement(goHomeButtonLocator);
	}

		
	//click action

	public LogoutPage clickLogoutButton() {
		clickElement(logoutButtonLocator, "logout_click");
		return this;
	}

	public LogoutPage clickgoHomeButton() {
		clickElement(goHomeButtonLocator, "goHome_click");
		return this;
	}
	

}
