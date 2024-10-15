package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ConfigReader;

public class LoginPage extends BasePage {
	
	private String investorEmail = ConfigReader.getPropertyFromKey("InvestorEmail");
	private String password = ConfigReader.getPropertyFromKey("Password");
	private String invalidEmail = ConfigReader.getPropertyFromKey("InvalidEmail");
	private String invalidPassword = ConfigReader.getPropertyFromKey("InvalidPassword");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	
	By emailLocator = By.xpath("//input[@type='email']");
	By passwordLocator = By.xpath("//input[@type='password']");
	By loginButton = By.xpath("//button[@type='submit']");
	By alertEmptyLocator = By.xpath("//div[text()='Please enter your email and password.']");
	By alertEmailLocator = By.xpath("//div[text()='Please enter your email.']");
	By alertPasswordLocator = By.xpath("//div[text()='Please enter your password.']");	
	By alertLocator = By.xpath("//div[text()='Incorrect username or password.']");
	
	// Actions
	
	// Page Locate elements

	public WebElement getEmptyAlertMessages() {
		return locateElement(alertEmptyLocator, "EmptyAlertMessages");
	}
	
	public WebElement getEmailAlertMessages() {
		return locateElement(alertEmailLocator, "EmailAlertMessages");
	}
	
	public WebElement getPasswordAlertMessages() {
		return locateElement(alertPasswordLocator, "PasswordAlertMessages");
	}
	
	public WebElement getAlertMessages() {
		return locateElement(alertLocator, "AlertMessages");
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	
	
	

	// Page Click actions

	public LoginPage clickLoginButton() {
		clickElement(loginButton, "login_click");
		return this;
	}
	
	// Page Send Action
	
	public LoginPage enterEmail() {
		sendKeysElement(emailLocator, investorEmail, "Email");
		return this;
	}
	
	public LoginPage enterPassword() {
		sendKeysElement(passwordLocator, password, "Password");
		return this;
	}
	

	public LoginPage enterInvalidEmail() {
		sendKeysElement(emailLocator, invalidEmail, "InvalidEmail");
		return this;
	}
	
	public LoginPage enterInvalidPassword() {
		sendKeysElement(passwordLocator, invalidPassword, "InvalidPassword");
		return this;
	}
	
	public void LoginInvestor() {
		enterEmail().enterPassword().clickLoginButton();
		SmartWait(2);
	}
	

}
